package org.example.manager.writer;

import java.nio.file.Path;
import java.util.List;
import org.example.manager.state.dto.FileFieldDTO;

public interface FileWriter {

  void write(List<FileFieldDTO> dtos, Path filePath);

}
