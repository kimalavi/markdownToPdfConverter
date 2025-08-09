package com.md2pdf;

import com.md2pdf.cli.CLIParser;
import com.md2pdf.converter.MarkdownToPdfConverter;
import com.md2pdf.io.DirectoryMirror;
import com.md2pdf.io.FileWalker;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CLIParser parser = new CLIParser(args);
        if (!parser.isValid()) {
            System.err.println(parser.getErrorMessage());
            System.exit(1);
        }

        Path inputDir = parser.getInputPath();
        Path outputDir = parser.getOutputPath();

        try {
            DirectoryMirror.mirrorStructure(inputDir, outputDir);
            List<Path> mdFiles = FileWalker.findMarkdownFiles(inputDir);

            MarkdownToPdfConverter converter = new MarkdownToPdfConverter(inputDir, outputDir);
            boolean allSuccess = converter.convertAll(mdFiles);

            System.exit(allSuccess ? 0 : 2);
        } catch (Exception e) {
            System.err.println("Fatal error: " + e.getMessage());
            System.exit(3);
        }
    }
}