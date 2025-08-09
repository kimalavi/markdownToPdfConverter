package com.md2pdf;

import com.md2pdf.cli.CLIParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CLIParserTest {

    @Test
    void testValidArgs() {
        String[] args = {"--input", "/tmp/in", "--output", "/tmp/out"};
        CLIParser parser = new CLIParser(args);
        assertTrue(parser.isValid());
    }
}