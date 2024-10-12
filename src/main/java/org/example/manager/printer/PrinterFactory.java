package org.example.manager.printer;

import org.example.manager.printer.impl.ConsolePrinter;

public class PrinterFactory {

  private PrinterFactory() {

  }

  public static Printer getPrinter() {
    return new ConsolePrinter();
  }

}
