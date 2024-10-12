package org.example.manager;

import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.manager.printer.Printer;
import org.example.manager.state.dto.FileFieldDTO;

@AllArgsConstructor
@NoArgsConstructor
public abstract class BasicPrintable {

  private Printer printer;

  protected void print(String message) {
    if (Objects.nonNull(printer)) {
      this.printer.print(message);
    }
  }

  protected void print(List<String> lines) {
    if (Objects.nonNull(printer)) {
      this.printer.print(lines);
    }
  }

  protected void printDTO(List<FileFieldDTO> dtos) {
    if (Objects.nonNull(printer)) {
      this.printer.printDTO(dtos);
    }
  }

}
