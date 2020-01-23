package it.lpleo.adventofcode.y2019.p7;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.service.InputManipulatorService;
import it.lpleo.adventofcode.y2019.PuzzleSolvers;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Test;

public class AmplificationCircuitPuzzleSolverTest {

  private AmplificationCircuitPuzzleSolver puzzleSolver = new AmplificationCircuitPuzzleSolver();

  @Test
  public void solvePart1_1() {
    List<String> input = InputManipulatorService.convertIntegerListInStringList(
        asList(3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0));
    String result = puzzleSolver.solvePart1(input);
    assertThat(result, Matchers.is("43210"));
  }

  @Test
  public void solvePart1_2() {
    List<String> input = InputManipulatorService.convertIntegerListInStringList(
        asList(3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23,
            101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0));
    String result = puzzleSolver.solvePart1(input);
    assertThat(result, Matchers.is("54321"));
  }

  @Test
  public void solvePart1_3() {
    List<String> input = InputManipulatorService.convertIntegerListInStringList(
        asList(3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33,
            1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0));
    String result = puzzleSolver.solvePart1(input);
    assertThat(result, Matchers.is("65210"));
  }

  @Test
  public void solvePart2_1() {
    List<String> input = InputManipulatorService.convertIntegerListInStringList(
        asList(3, 26, 1001, 26, -4, 26, 3, 27, 1002, 27, 2, 27, 1, 27, 26,
            27, 4, 27, 1001, 28, -1, 28, 1005, 28, 6, 99, 0, 0, 5));
    String result = puzzleSolver.solvePart2(input);
    assertThat(result, Matchers.is("139629729"));
  }

  @Test
  public void solvePart2_2() {
    List<String> input = InputManipulatorService.convertIntegerListInStringList(
        asList(3, 52, 1001, 52, -5, 52, 3, 53, 1, 52, 56, 54, 1007, 54, 5, 55, 1005, 55, 26, 1001,
            54,
            -5, 54, 1105, 1, 12, 1, 53, 54, 53, 1008, 54, 0, 55, 1001, 55, 1, 55, 2, 53, 55, 53, 4,
            53, 1001, 56, -1, 56, 1005, 56, 6, 99, 0, 0, 0, 0, 10));
    String result = puzzleSolver.solvePart2(input);
    assertThat(result, Matchers.is("18216"));
  }
}
