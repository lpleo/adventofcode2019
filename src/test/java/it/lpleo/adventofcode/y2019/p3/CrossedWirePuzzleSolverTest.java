package it.lpleo.adventofcode.y2019.p3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.y2019.PuzzleSolvers;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CrossedWirePuzzleSolverTest {

  private CrossedWirePuzzleSolver crossedWirePuzzleSolver = new CrossedWirePuzzleSolver();

  @Test
  public void solvePart1() {
    String result = crossedWirePuzzleSolver.solvePart1(Arrays.asList("R8,U5,L5,D3", "U7,R6,D4,L4"));
    assertThat(result,is(6.0+""));

    result = crossedWirePuzzleSolver.solvePart1(Arrays.asList("R75,D30,R83,U83,L12,D49,R71,U7,L72",
        "U62,R66,U55,R34,D71,R55,D58,R83"));
    assertThat(result,is(159.0+""));

    result = crossedWirePuzzleSolver.solvePart1(Arrays.asList("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
        "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"));
    assertThat(result,is(135.0+""));
  }

  @Test
  public void solvePart2() {
    String result = crossedWirePuzzleSolver.solvePart2(Arrays.asList("R8,U5,L5,D3", "U7,R6,D4,L4"));
    assertThat(result,is(30.0+""));

    result = crossedWirePuzzleSolver.solvePart2(Arrays.asList("R75,D30,R83,U83,L12,D49,R71,U7,L72",
        "U62,R66,U55,R34,D71,R55,D58,R83"));
    assertThat(result,is(610.0+""));

    result = crossedWirePuzzleSolver.solvePart2(Arrays.asList("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
        "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"));
    assertThat(result,is(410.0+""));
  }
}
