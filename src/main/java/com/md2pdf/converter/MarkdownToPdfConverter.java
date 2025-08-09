package com.md2pdf.converter;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownToPdfConverter {
    private final Path inputRoot;
    private final Path outputRoot;
    private final Logger logger = LoggerFactory.getLogger(MarkdownToPdfConverter.class);

    public MarkdownToPdfConverter(Path inputRoot, Path outputRoot) {
        this.inputRoot = inputRoot;
        this.outputRoot = outputRoot;
    }

    public boolean convertAll(List<Path> mdFiles) {
        boolean allSuccess = true;
        for (Path mdFile : mdFiles) {
            try {
                convert(mdFile);
                logger.info("Converted: " + mdFile);
            } catch (Exception e) {
                logger.error("Failed to convert: " + mdFile + " - " + e.getMessage());
                allSuccess = false;
            }
        }
        return allSuccess;
    }

    private void convert(Path mdFile) throws IOException {
        String markdown = Files.readString(mdFile);
        String html = FlexmarkHtmlConverter.builder().build().convert(markdown);

        Path relative = inputRoot.relativize(mdFile);
        String pdfPath = outputRoot.resolve(relative).toString().replaceAll("\\.md$", ".pdf");

        try (OutputStream os = new FileOutputStream(pdfPath)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(html, null);
            builder.toStream(os);
            builder.run();
        }
    }
}