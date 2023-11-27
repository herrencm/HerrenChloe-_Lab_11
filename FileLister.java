package recursivelister;

import java.io.File;

public class FileLister {

    public String listFiles(File directory) {
        StringBuilder stringBuilder = new StringBuilder();
        listFilesRecursively(directory, stringBuilder, 0);
        return stringBuilder.toString();
    }

    private void listFilesRecursively(File directory, StringBuilder stringBuilder, int depth) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    for (int i = 0; i < depth; i++) {
                        stringBuilder.append("\t"); // Add tabs for indentation
                    }
                    stringBuilder.append(file.getName()).append("\n");
                    if (file.isDirectory()) {
                        listFilesRecursively(file, stringBuilder, depth + 1);
                    }
                }
            }
        }
    }
}
