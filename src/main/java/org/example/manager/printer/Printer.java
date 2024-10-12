package org.example.manager.printer;

import java.util.List;
import org.example.manager.state.dto.FileFieldDTO;

public interface Printer {

  void print(String text);
  void print(List<String> lines);
  void printDTO(List<FileFieldDTO> dtos);
}
