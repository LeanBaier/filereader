package org.example.manager.state.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.manager.state.ProcessStateManager;
import org.example.manager.state.dto.FieldPositionDTO;
import org.example.manager.state.dto.FileProcessStateDTO;
import org.example.manager.state.enums.FileProcessState;

@Slf4j
public class ProcessStateManagerImpl implements ProcessStateManager {

  private FileProcessStateDTO state;

  public ProcessStateManagerImpl(FileProcessStateDTO state) {
    this.state = state;
    log.info("Process manager created with state: {}", state.getState().name());
  }

  @Override
  public void changeState(FileProcessState state) {
    this.state.setState(state);
    log.info("Process state changed to: {}", state.name());
  }

  @Override
  public void addPosition(String value, FieldPositionDTO position) {
    state.addPosition(value, position);
  }

  @Override
  public FileProcessStateDTO getState() {
    return this.state;
  }
}
