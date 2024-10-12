package org.example.manager.reader;

import java.nio.file.Path;
import java.util.List;

public interface FileReader {

  List<String> readAllLines(Path path);
}
