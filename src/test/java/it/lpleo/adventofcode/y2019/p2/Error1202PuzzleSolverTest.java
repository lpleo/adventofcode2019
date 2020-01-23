package it.lpleo.adventofcode.y2019.p2;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.junit.Test;

public class Error1202PuzzleSolverTest {

  private Error1202PuzzleSolver error1202PuzzleSolver = new Error1202PuzzleSolver();

  @Test
  public void solvePart1() {
    List<String> input = asList("1,9,10,3,2,3,11,0,99,30,40,50".split(","));

    String result = error1202PuzzleSolver.solvePart1(input);
    assertThat(Integer.parseInt(result), is(3500));
  }
}
