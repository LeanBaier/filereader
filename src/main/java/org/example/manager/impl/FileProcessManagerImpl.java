package org.example.manager.impl;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.manager.FileProcessManager;
import org.example.manager.dto.FieldDTO;
import org.example.manager.processor.FileProcessor;
import org.example.manager.reader.FileReader;
import org.example.manager.state.ProcessStateManager;
import org.example.manager.state.dto.FieldPositionDTO;
import org.example.manager.state.enums.FileProcessState;
import org.example.manager.writer.FileWriter;

@RequiredArgsConstructor
@Slf4j
public class FileProcessManagerImpl implements FileProcessManager {

  private final Path path;
  private final ProcessStateManager processStateManager;
  private final FileReader fileReader;
  private final FileWriter fileWriter;
  private final FileProcessor fileProcessor;

  @Override
  public void run() {
    processStateManager.changeState(FileProcessState.STARTED);
    var lines = fileReader.readAllLines(this.path);
    processStateManager.changeState(FileProcessState.IN_PROCESS);
    int row = 0;
    List<FieldDTO> result;
    for (var line : lines) {
      result = fileProcessor.process(line);
      int finalRow = row;

      result = result.stream().sorted(Comparator.comparing(FieldDTO::getCol)).toList();
      for (var item : result) {
        processStateManager.addPosition(item.getValue(),
            new FieldPositionDTO(finalRow, item.getCol()));
        row++;
      }
    }
    processStateManager.changeState(FileProcessState.WRITING);
    fileWriter.write(this.processStateManager.getState().getFields(),
        Path.of(path.toString() + ".parsed.txt"));
    processStateManager.changeState(FileProcessState.FINISHED);
  }
}

