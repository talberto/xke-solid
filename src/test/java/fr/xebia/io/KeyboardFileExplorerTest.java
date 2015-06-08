package fr.xebia.io;

import fr.xebia.model.fileexplorer.FileExplorer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.*;
import java.awt.event.KeyEvent;

@RunWith(MockitoJUnitRunner.class)
public class KeyboardFileExplorerTest {

    Keyboard keyboard;

    @Mock
    FileExplorer fileExplorer;

    @Before
    public void setUp() throws Exception {
        //!TODO Create a Keyboard delegating to a FileExplorer
    }

    @Test
    public void should_open_directory_on_key_left() {
        // When
        keyboard.keyPressed(mockKeyEvent(KeyEvent.VK_RIGHT));

        // Then
        Mockito.verify(fileExplorer).openHighlightedDirectory();
    }

    @Test
    public void should_move_up_on_key_up() {
        // When
        keyboard.keyPressed(mockKeyEvent(KeyEvent.VK_UP));

        // Then
        Mockito.verify(fileExplorer).moveUp();
    }

    @Test
    public void should_move_down_on_key_down() {
        // When
        keyboard.keyPressed(mockKeyEvent(KeyEvent.VK_DOWN));

        // Then
        Mockito.verify(fileExplorer).moveDown();
    }

    @Test
    public void should_move_to_parent_on_key_left() {
        // When
        keyboard.keyPressed(mockKeyEvent(KeyEvent.VK_LEFT));

        // Then
        Mockito.verify(fileExplorer).moveToParentDirectory();
    }

    private KeyEvent mockKeyEvent(int keyCode) {
        return new KeyEvent(Mockito.mock(Component.class), 0, 0, 0, keyCode, ' ');
    }
}