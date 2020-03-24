package it.lpleo.adventofcode.y2019.p12;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class NBodyProblemPuzzleSolverTest {

  private NBodyProblemPuzzleSolver nBodyProblemPuzzleSolver = new NBodyProblemPuzzleSolver();

  @Test
  public void solvePart1() {
    String result = nBodyProblemPuzzleSolver
        .solvePart1(asList("10", "-1,0,2", "2,-10,-7", "4,-8,8", "3,5,-1"));
    assertThat(result, is("179.0"));
  }

  @Test
  public void solvePart1_1() {
    String result = nBodyProblemPuzzleSolver
        .solvePart1(asList("100", "-8,-10,0", "5,5,10", "2,-7,3", "9,-8,-3"));
    assertThat(result, is("1940.0"));
  }

  @Test
  public void solvePart2() {
  }

}
