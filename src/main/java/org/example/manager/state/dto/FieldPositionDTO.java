package org.example.manager.state.dto;

public class FieldPositionDTO {

  private final int column;
  private final int row;

  public FieldPositionDTO(int column, int row) {
    this.column = column;
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public int getRow() {
    return row;
  }
}
