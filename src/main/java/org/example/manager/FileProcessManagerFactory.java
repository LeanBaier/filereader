package org.example.manager;

import java.nio.file.Path;
import org.example.manager.impl.FileProcessManagerImpl;
import org.example.manager.processor.impl.FileProcessorImpl;
import org.example.manager.reader.impl.FileReaderImpl;
import org.example.manager.state.ProcessStateManagerFactory;
import org.example.manager.state.enums.FileProcessState;
import org.example.manager.writer.impl.FileWriterImpl;
import org.example.manager.printer.Printer;
import org.example.manager.printer.PrinterFactory;

public class FileProcessManagerFactory {

  private FileProcessManagerFactory() {

  }

  public static FileProcessManager create(String filepath, boolean printableWriter) {
    Printer printer = null;
    if (printableWriter) {
      printer = PrinterFactory.getPrinter();
    }
    var reader = new FileReaderImpl();
    var processor = new FileProcessorImpl();
    var writer = new FileWriterImpl(printer);
    var stateManager = ProcessStateManagerFactory.create(FileProcessState.CREATED);
    return new FileProcessManagerImpl(Path.of(filepath), stateManager, reader, writer, processor);
  }
}
