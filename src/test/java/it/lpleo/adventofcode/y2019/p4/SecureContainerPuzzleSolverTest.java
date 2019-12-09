package it.lpleo.adventofcode.y2019.p4;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.y2019.PuzzleSolvers;
import org.hamcrest.Matchers;
import org.junit.Test;

public class SecureContainerPuzzleSolverTest {

  private SecureContainerPuzzleSolver puzzleSolver = new SecureContainerPuzzleSolver(
      PuzzleSolvers.getSecureContainerPuzzle());

  @Test
  public void solvePart1() {
    String result = puzzleSolver.solvePart1(asList("111111", "111111"));
    assertThat(result, Matchers.is("1"));

    result = puzzleSolver.solvePart1(asList("223450", "223450"));
    assertThat(result, Matchers.is("0"));

    result = puzzleSolver.solvePart1(asList("123789", "123789"));
    assertThat(result, Matchers.is("0"));

    result = puzzleSolver.solvePart1(asList("122345", "122345"));
    assertThat(result, Matchers.is("1"));

    result = puzzleSolver.solvePart1(asList("111123", "111123"));
    assertThat(result, Matchers.is("1"));

    result = puzzleSolver.solvePart1(asList("135679", "135679"));
    assertThat(result, Matchers.is("0"));

    result = puzzleSolver.solvePart1(asList("700444", "700444"));
    assertThat(result, Matchers.is("0"));
  }

  @Test
  public void solvePart2() {
    String result = puzzleSolver.solvePart1(asList("667788", "667788"));
    assertThat(result, Matchers.is("1"));

    result = puzzleSolver.solvePart1(asList("666677", "666677"));
    assertThat(result, Matchers.is("1"));

    result = puzzleSolver.solvePart1(asList("678444", "678444"));
    assertThat(result, Matchers.is("0"));
  }
}
