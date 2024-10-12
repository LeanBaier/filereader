package org.example.manager.state.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.example.manager.state.SimbolGenerator;
import org.example.manager.state.enums.FileProcessState;

public class FileProcessStateDTO {

  @Setter
  @Getter
  private FileProcessState state;
  private final Map<String, FileFieldDTO> fields;

  public FileProcessStateDTO(FileProcessState state) {
    this.state = state;
    this.fields = new HashMap<>();
  }

  public void addPosition(String value, FieldPositionDTO position) {
    Optional<FileFieldDTO> field =
        this.fields.containsKey(value) ? Optional.of(this.fields.get(value)) : Optional.empty();
    if (field.isPresent()) {
      field.get().addPosition(position);
    } else {
      this.fields.put(value, new FileFieldDTO(value, SimbolGenerator.getSimbol()));
    }
  }

  public List<FileFieldDTO> getFields() {
    return List.copyOf(this.fields.values());
  }

}
