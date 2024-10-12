package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.extern.slf4j.Slf4j;
import org.example.manager.FileProcessManagerFactory;

@Slf4j
public class Application {

  public static void main(String[] args) {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //try {
      /*log.info("File path: ");
      var filePath = reader.readLine();

      log.info("Use printer: ");
      var usePrinter = Boolean.parseBoolean(reader.readLine());
*/
      var fileManager = FileProcessManagerFactory.create(args[0], Boolean.parseBoolean(args[1]));
      fileManager.run();
/*    } catch (IOException e) {
      log.error("Error reading file path", e);
      throw new RuntimeException(e);
    }*/
  }
}