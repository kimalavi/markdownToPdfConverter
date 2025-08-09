package com.md2pdf;

import com.md2pdf.io.FileWalker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileWalkerTest {
    @Test
    void testFindMarkdownFiles() throws IOException {
        Path tempDir = Files.createTempDirectory("mdtest");
        Files.writeString(tempDir.resolve("test.md"), "# Hello");
        Files.writeString(tempDir.resolve("note.txt"), "Not markdown");

        List<Path> result = FileWalker.findMarkdownFiles(tempDir);
        assertEquals(1, result.size());
        assertTrue(result.get(0).toString().endsWith("test.md"));
    }
}