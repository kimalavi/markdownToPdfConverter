package com.md2pdf.cli;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CLIParser {
    private Path inputPath;
    private Path outputPath;
    private String errorMessage;

    public CLIParser(String[] args) {
        if (args.length != 4 || !args[0].equals("--input") || !args[2].equals("--output")) {
            errorMessage = "Usage: --input <path> --output <path>";
            return;
        }

        inputPath = Paths.get(args[1]);
        outputPath = Paths.get(args[3]);

        if (!Files.isDirectory(inputPath)) {
            errorMessage = "Input path is not a readable directory.";
        }
    }

    public boolean isValid() {
        return errorMessage == null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Path getInputPath() {
        return inputPath;
    }

    public Path getOutputPath() {
        return outputPath;
    }
}