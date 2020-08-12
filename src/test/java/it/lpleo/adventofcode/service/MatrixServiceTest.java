package it.lpleo.adventofcode.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class MatrixServiceTest {

  @Test
  public void initializeMatrixTest() {
    Integer[][] matrix = new Integer[3][2];
    MatrixService.initializeMatrix(matrix, 5);
    for (Integer[] integers : matrix) {
      for (int j = 0; j < 2; j++) {
        assertThat(integers[j], Matchers.is(5));
      }
    }
  }

  @Test
  public void printMatrixTest() {
    Integer[][] matrix = new Integer[][]{{3, 2, 1}, {4, 5, 6}};
    String result = MatrixService.printMatrix(matrix);
    assertThat(result,is("\n|3|2|1|\n|4|5|6|\n"));
  }
}