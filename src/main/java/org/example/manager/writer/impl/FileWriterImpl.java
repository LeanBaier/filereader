package org.example.manager.writer.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.example.manager.BasicPrintable;
import org.example.manager.printer.Printer;
import org.example.manager.state.dto.FileFieldDTO;
import org.example.manager.writer.FileWriter;

@Slf4j
public class FileWriterImpl extends BasicPrintable implements FileWriter {

  public FileWriterImpl() {
    super();
  }

  public FileWriterImpl(Printer printer) {
    super(printer);
  }

  @Override
  public void write(List<FileFieldDTO> dtos, Path filePath) {

    printDTO(dtos);
    var sb = new StringBuilder();
    for (var dto : dtos) {
      var sbi = new StringBuilder();
      for (var _ : dto.getPositions()) {
        sbi.append(dto.getValue());
      }
      sb.append(sbi);
    }

    try {
      print(sb.toString());
      Files.write(filePath, sb.toString().getBytes());
      log.info("Total Characters written: {}", sb.toString().getBytes().length);
    } catch (IOException e) {
      log.error("Error writing file: {}", filePath, e);
      throw new RuntimeException(e);
    }
  }
}
