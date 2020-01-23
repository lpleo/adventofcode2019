package it.lpleo.adventofcode.y2019.p9;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.domain.Puzzle;
import org.junit.Test;

public class SensorBoostPuzzleSolverTest {

  private static final SensorBoostPuzzleSolver puzzleSolver = new SensorBoostPuzzleSolver();

  @Test
  public void solvePart1_1() {
    String input = "109,19,204,-34,99";
    String result = puzzleSolver.solvePart1(asList(input.split(",")));
    assertThat(result, is("0"));
  }

  @Test
  public void solvePart1_2() {
    String input = "109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99";
    String result = puzzleSolver.solvePart1(asList(input.split(",")));
    assertThat(result, is(input));
  }

  @Test
  public void solvePart1_3() {
    String input = "1102,34915192,34915192,7,4,7,99,0";
    String result = puzzleSolver.solvePart1(asList(input.split(",")));
    assertThat(result.length(), is(16));
  }

  @Test
  public void solvePart1_4() {
    String input = "104,1125899906842624,99";
    String result = puzzleSolver.solvePart1(asList(input.split(",")));
    assertThat(result, is("1125899906842624"));
  }

  @Test
  public void solvePart1_5() {
    String input = "109,1,203,11,209,8,204,1,99,10,0,42,0";
    String result = puzzleSolver.solvePart1(asList(input.split(",")));
//    assertThat(result, is("1"));
  }


  @Test
  public void solvePart2() {
  }
}
