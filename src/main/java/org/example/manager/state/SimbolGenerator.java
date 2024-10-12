package org.example.manager.state;

public class SimbolGenerator {

  private static byte simbol = 10;

  private SimbolGenerator() {
  }

  public static String getSimbol() {
    return String.valueOf((char) simbol++);
  }
}
