package it.lpleo.adventofcode.y2019.p7;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.string.InputManipulator;
import it.lpleo.adventofcode.y2019.PuzzleSolvers;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Test;

public class AmplificationCircuitPuzzleSolverTest {

  private AmplificationCircuitPuzzleSolver puzzleSolver = new AmplificationCircuitPuzzleSolver(
      PuzzleSolvers
          .getAmplificationCircuitPuzzle());

  @Test
  public void solvePart1_1() {
    List<String> input = InputManipulator.convertInStringList(
        asList(3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0));
    String result = puzzleSolver.solvePart1(input);
    assertThat(result, Matchers.is("43210"));
  }

  @Test
  public void solvePart1_2() {
    List<String> input = InputManipulator.convertInStringList(
        asList(3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23,
            101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0));
    String result = puzzleSolver.solvePart1(input);
    assertThat(result, Matchers.is("54321"));
  }

  @Test
  public void solvePart1_3() {
    List<String> input = InputManipulator.convertInStringList(
        asList(3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33,
            1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0));
    String result = puzzleSolver.solvePart1(input);
    assertThat(result, Matchers.is("65210"));
  }

  @Test
  public void solvePart2() {
  }
}
