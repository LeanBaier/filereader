package org.example.manager.state.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;

@Getter
public class FileFieldDTO {

  private final String value;
  private final String simbol;
  private final List<FieldPositionDTO> positions;

  public FileFieldDTO(String value, String simbol) {
    this.value = value;
    this.simbol = simbol;
    this.positions = new ArrayList<>();
  }

  public void addPosition(FieldPositionDTO position) {
    positions.add(position);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileFieldDTO that = (FileFieldDTO) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
