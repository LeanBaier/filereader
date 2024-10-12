package org.example.manager.processor.impl;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.extern.slf4j.Slf4j;
import org.example.manager.BasicPrintable;
import org.example.manager.dto.FieldDTO;
import org.example.manager.printer.Printer;
import org.example.manager.processor.FileProcessor;

@Slf4j
public class FileProcessorImpl extends BasicPrintable implements FileProcessor {

  private static final List<String> IGNORED_FIELDS = List.of(" ", "\t", "\n");

  public FileProcessorImpl() {
    super();
  }

  public FileProcessorImpl(Printer printer) {
    super(printer);
  }

  @Override
  public List<FieldDTO> process(String line) {
    if (line == null || line.isEmpty()) {
      return Collections.emptyList();
    }

    List<FieldDTO> result = new CopyOnWriteArrayList<>();
    for (byte field : line.getBytes()) {
      if (!IGNORED_FIELDS.contains(String.valueOf((char) field))) {
        result.add(FieldDTO.builder()
            .value(String.valueOf((char) field))
            .col(result.size())
            .build());
      }
    }

    return result;
  }

}
