package it.lpleo.adventofcode.service;

import java.util.Arrays;

public class MatrixService {

  public static <T> void initializeMatrix(T[][] matrix, T value) {
    for (T[] row : matrix) {
      Arrays.fill(row, value);
    }
  }

  public static <T> String printMatrix(T[][] matrix) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\n");
    for (T[] row : matrix) {
      stringBuilder.append("|");
      for (T element : row) {
        stringBuilder.append(element.toString());
        stringBuilder.append("|");
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }
}
