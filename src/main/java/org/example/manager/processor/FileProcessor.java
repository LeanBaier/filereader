package org.example.manager.processor;

import java.util.List;
import org.example.manager.dto.FieldDTO;

public interface FileProcessor {

  List<FieldDTO> process(String line);

}
