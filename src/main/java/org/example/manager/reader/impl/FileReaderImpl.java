package org.example.manager.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.example.manager.BasicPrintable;
import org.example.manager.reader.FileReader;
import org.example.manager.printer.Printer;

@Slf4j
public class FileReaderImpl extends BasicPrintable implements FileReader {

  public FileReaderImpl() {
    super();
  }

  public FileReaderImpl(Printer printer) {
    super(printer);
  }

  @Override
  public List<String> readAllLines(Path path) {
    try {
      var lines = Files.readAllLines(path);
      super.print(lines);
      return lines;
    } catch (IOException e) {
      log.error("Error reading file: {}", path, e);
      throw new RuntimeException(e);
    }
  }

}
