package org.example.manager.printer.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.example.manager.printer.Printer;
import org.example.manager.state.dto.FileFieldDTO;

@Slf4j
public class ConsolePrinter implements Printer {

  private static final int ROW_LENGTH = 100;

  //C:\Users\leanb\Downloads\file.txt
  @Override
  public void print(String text) {
    int i = 0;
    int j = ROW_LENGTH;
    boolean repeat = true;
    while (repeat) {
      if (j > text.length()) {
        j = text.length() - 1;
        repeat = false;
      }
      log.info("{}", text.substring(i, j));
      i += ROW_LENGTH;
      j += ROW_LENGTH;
    }
  }

  @Override
  public void print(List<String> lines) {
    var text = String.join("", lines);
    print(text);
  }

  @Override
  public void printDTO(List<FileFieldDTO> dtos) {
    var lines = dtos.stream().map(FileFieldDTO::getSimbol).collect(Collectors.joining());
    print(lines);
  }
}
