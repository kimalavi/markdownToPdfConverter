package com.md2pdf.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryMirror {
    public static void mirrorStructure(Path inputRoot, Path outputRoot) throws IOException {
        Files.walk(inputRoot).forEach(path -> {
            try {
                Path relative = inputRoot.relativize(path);
                Path target = outputRoot.resolve(relative);
                if (Files.isDirectory(path)) {
                    Files.createDirectories(target);
                }
            } catch (IOException e) {
                System.err.println("Failed to create directory: " + path);
            }
        });
    }
}