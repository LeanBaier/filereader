package org.example.manager.state;

import org.example.manager.state.dto.FileProcessStateDTO;
import org.example.manager.state.enums.FileProcessState;
import org.example.manager.state.impl.ProcessStateManagerImpl;

public class ProcessStateManagerFactory {

  private ProcessStateManagerFactory() {
  }

  public static ProcessStateManager create(FileProcessState state) {
    return new ProcessStateManagerImpl(buildDTO(state));
  }

  private static FileProcessStateDTO buildDTO(FileProcessState state) {
    return new FileProcessStateDTO(state);
  }

}
