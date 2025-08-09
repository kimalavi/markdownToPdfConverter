# 📄 Markdown-to-PDF Batch Converter

A Java console application that recursively scans a directory of Markdown files and converts each `.md` file into a PDF, preserving the folder structure.

---

## 🚀 Features

- ✅ Command-line interface with input/output arguments
- 📁 Recursively scans nested directories
- 🧱 Mirrors folder structure in output
- 📝 Converts Markdown to HTML using **Flexmark**
- 📄 Renders HTML to PDF using **OpenHTMLtoPDF**
- 🧪 Includes unit tests for core functionality
- 📋 Logs progress and errors with **SLF4J**
- 🧵 Optional concurrency support (coming soon)

---

## 📦 Requirements

- Java 11 or higher
- Maven (for build and dependency management)

---

## 🔧 Build Instructions

Clone the repository and build the JAR:

```bash
git clone https://github.com/your-username/md2pdf-converter.git
cd md2pdf-converter
mvn clean package
```

This will generate a runnable JAR in the `target/` directory:

```
target/md2pdf-converter-1.0-jar-with-dependencies.jar
```

---

## 🧑‍💻 Usage

```bash
java -jar md2pdf-converter-1.0-jar-with-dependencies.jar \
  --input /path/to/markdown \
  --output /path/to/output
```

### Example

Given this input structure:

```
/docs
├── intro.md
└── guide/
    └── chapter1.md
```

The output will be:

```
/pdfs
├── intro.pdf
└── guide/
    └── chapter1.pdf
```

---

## 📚 Supported Markdown Features

- Headings (`#`, `##`, etc.)
- Lists (ordered and unordered)
- Code blocks
- Links and images
- Blockquotes and emphasis

---

## 🧪 Running Tests

```bash
mvn test
```

Includes unit tests for:

- CLI argument parsing
- Directory traversal
- Markdown-to-PDF conversion

---

## 🧰 Dependencies

| Library           | Purpose                     |
|------------------|-----------------------------|
| Flexmark          | Markdown → HTML conversion |
| OpenHTMLtoPDF     | HTML → PDF rendering       |
| SLF4J             | Logging                     |
| JUnit             | Unit testing                |

All dependencies are declared in `pom.xml`.

---

## 📎 Exit Codes

| Code | Meaning                          |
|------|----------------------------------|
| 0    | Success                          |
| 1    | Invalid CLI arguments            |
| 2    | One or more files failed to convert |
| 3    | Fatal error during execution     |

---

## 📌 License

This project is licensed under the MIT License. See `LICENSE` for details.

---

## 🙋‍♀️ Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

---

## ✨ Author

**Kimia Alavi** — built with ❤️ and Java.

```

---

Let me know if you'd like a version with badges (build status, license, etc.) or if you're planning to publish this on GitHub—I can help tailor it for that too!
