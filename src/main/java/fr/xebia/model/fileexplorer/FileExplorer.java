package fr.xebia.model.fileexplorer;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FileExplorer {
    File currentFile;
    List<File> files;
    Integer highlightedFileIndex = 0;
    Stack<Integer> indexStack = new Stack<>();

    public FileExplorer(File entryPoint) {
        currentFile = entryPoint;
        listFilesOfCurrentDirectory();
    }

    public void openHighlightedDirectory() {
        currentFile = files.get(highlightedFileIndex);
        listFilesOfCurrentDirectory();
        stackHighlightedFileIndex();
    }

    public void moveToParentDirectory() {
        File parentFile =  currentFile.getParentFile();

        if (parentFile != null) {
            currentFile = parentFile;
            listFilesOfCurrentDirectory();
            popHighlightedFileIndex();
        }
    }

    public void moveUp() {
        highlightedFileIndex = Math.max(0, highlightedFileIndex - 1);
    }

    public void moveDown() {
        highlightedFileIndex = Math.min(files.size() - 1, highlightedFileIndex + 1);
    }

    private File highlightedFile() {
        return files.get(highlightedFileIndex);
    }

    private void popHighlightedFileIndex() {
        if (indexStack.empty()) {
            highlightedFileIndex = 0;
        } else {
            highlightedFileIndex = indexStack.pop();
        }
    }

    private void stackHighlightedFileIndex() {
        indexStack.push(highlightedFileIndex);
        highlightedFileIndex = 0;
    }

    private void listFilesOfCurrentDirectory() {
        if (currentFile.isDirectory()) {
            files = Arrays.asList(currentFile.listFiles());
        }
    }
}
