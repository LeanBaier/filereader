package org.example.manager.state;

import org.example.manager.state.dto.FieldPositionDTO;
import org.example.manager.state.dto.FileProcessStateDTO;
import org.example.manager.state.enums.FileProcessState;

public interface ProcessStateManager {

  void changeState(FileProcessState state);

  void addPosition(String value, FieldPositionDTO position);

  FileProcessStateDTO getState();
}
