package fr.xebia.model.fileexplorer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FileExplorerTest {

    @Mock
    private File directory;

    @Mock
    private File file1;

    @Mock
    private File file2;

    private FileExplorer fileExplorer;

    @Before
    public void setUp() {
        when(directory.isDirectory()).thenReturn(true);
        when(directory.listFiles()).thenReturn(new File[]{file1, file2});
        fileExplorer = new FileExplorer(directory);
    }

    @Test
    public void should_list_directory_files() {
        // Then
        assertThat(fileExplorer.currentFile).isEqualTo(directory);
        assertThat(fileExplorer.files).contains(file1, file2);
        assertThat(fileExplorer.highlightedFileIndex).isEqualTo(0);
    }

    @Test
    public void should_move_down_highlight_cursor() {
        fileExplorer.moveDown();

        // Then
        assertThat(fileExplorer.highlightedFileIndex).isEqualTo(1);
    }

    @Test
    public void should_move_up_highlight_cursor() {
        // Given
        File file3 = mock(File.class);
        File file4 = mock(File.class);

        when(directory.listFiles()).thenReturn(new File[]{file1, file2, file3, file4});

        // When
        FileExplorer fileExplorer = new FileExplorer(directory);
        fileExplorer.moveDown();
        fileExplorer.moveUp();

        // Then
        assertThat(fileExplorer.highlightedFileIndex).isEqualTo(0);
    }

    @Test
    public void should_not_be_over_files_index() {
        // When
        fileExplorer.moveDown();
        fileExplorer.moveDown();
        fileExplorer.moveDown();

        // Then
        assertThat(fileExplorer.highlightedFileIndex).isEqualTo(1);
    }

    @Test
    public void should_not_be_under_files_index() {
        // When
        fileExplorer.moveUp();

        // Then
        assertThat(fileExplorer.highlightedFileIndex).isEqualTo(0);
    }

    @Test
    public void should_move_to_parent_directory() {
        // Given
        File parentDirectory = mock(File.class);

        File parentFile1 = mock(File.class);
        File parentFile2 = mock(File.class);

        when(directory.getParentFile()).thenReturn(parentDirectory);

        when(parentDirectory.isDirectory()).thenReturn(true);
        when(parentDirectory.listFiles()).thenReturn(new File[]{parentFile1, parentFile2});

        // When
        fileExplorer.moveToParentDirectory();

        // Then
        assertThat(fileExplorer.highlightedFileIndex).isEqualTo(0);
        assertThat(fileExplorer.files).contains(parentFile1, parentFile2);
    }

    @Test
    public void should_open_highlighted_directory() {
        // Given
        File subFile1 = mock(File.class);
        File subFile2 = mock(File.class);

        when(file2.isDirectory()).thenReturn(true);
        when(file2.listFiles()).thenReturn(new File[]{subFile1, subFile2});

        // When
        fileExplorer.moveDown();
        fileExplorer.openHighlightedDirectory();

        // Then
        assertThat(fileExplorer.files).contains(subFile1, subFile2);
        assertThat(fileExplorer.indexStack.peek()).isEqualTo(1);
        assertThat(fileExplorer.highlightedFileIndex).isEqualTo(0);
    }

    @Test
    public void should_highlight_selected_file_when_moving_to_parent() {
        // Given
        File subFile1 = mock(File.class);
        File subFile2 = mock(File.class);

        when(file2.isDirectory()).thenReturn(true);
        when(file2.listFiles()).thenReturn(new File[]{subFile1, subFile2});
        when(file2.getParentFile()).thenReturn(directory);

        // When
        fileExplorer.moveDown();
        fileExplorer.openHighlightedDirectory();
        fileExplorer.moveToParentDirectory();

        // Then
        assertThat(fileExplorer.indexStack.empty()).isTrue();
        assertThat(fileExplorer.highlightedFileIndex).isEqualTo(1);
        assertThat(fileExplorer.files).contains(file1, file2);
    }
}