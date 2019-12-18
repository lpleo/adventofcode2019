package it.lpleo.adventofcode.y2019.p6;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.y2019.PuzzleSolvers;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Test;

public class UniversalOrbitMapPuzzleSolverTest {

  private List<String> pt1 = asList(
      "COM)B\nB)C\nC)D\nD)E\nE)F\nB)G\nG)H\nD)I\nE)J\nJ)K\nK)L".split("\n"));

  @Test
  public void solvePart1() {
    UniversalOrbitMapPuzzleSolver puzzleSolver = new UniversalOrbitMapPuzzleSolver(
        PuzzleSolvers.getUniversalOrbitMapPuzzle());

    String result = puzzleSolver.solvePart1(pt1);
    assertThat(result, Matchers.is("42"));
  }

  @Test
  public void solvePart2() {
  }
}
