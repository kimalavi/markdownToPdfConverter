package com.md2pdf.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileWalker {
    public static List<Path> findMarkdownFiles(Path root) throws IOException {
        List<Path> mdFiles = new ArrayList<>();
        Files.walk(root).forEach(path -> {
            if (Files.isRegularFile(path) && path.toString().toLowerCase().endsWith(".md")) {
                mdFiles.add(path);
            }
        });
        return mdFiles;
    }
}