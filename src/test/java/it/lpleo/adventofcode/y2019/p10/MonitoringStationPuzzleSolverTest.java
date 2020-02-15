package it.lpleo.adventofcode.y2019.p10;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class MonitoringStationPuzzleSolverTest {

  private MonitoringStationPuzzleSolver monitoringStationPuzzleSolver = new MonitoringStationPuzzleSolver();


  @Test
  public void solvePart1_0() {
    String input = ".#..#\n.....\n#####\n....#\n...##";
    String result = monitoringStationPuzzleSolver.solvePart1(asList(input.split("\n")));
    assertThat(result, Matchers.is("(3.0,4.0) - 8"));
  }

  @Test
  public void solvePart1_1() {
    String input = "......#.#.\n#..#.#....\n..#######.\n.#.#.###..\n.#..#.....\n..#....#.#\n#..#....#.\n.##.#..###\n##...#..#.\n.#....####";
    String result = monitoringStationPuzzleSolver.solvePart1(asList(input.split("\n")));
    assertThat(result, Matchers.is("(5.0,8.0) - 33"));
  }

  @Test
  public void solvePart1_2() {
    String input = "#.#...#.#.\n.###....#.\n.#....#...\n##.#.#.#.#\n....#.#.#.\n.##..###.#\n..#...##..\n..##....##\n......#...\n.####.###.";
    String result = monitoringStationPuzzleSolver.solvePart1(asList(input.split("\n")));
    assertThat(result, Matchers.is("(1.0,2.0) - 35"));
  }

  @Test
  public void solvePart1_3() {
    String input = ".#..#..###\n####.###.#\n....###.#.\n..###.##.#\n##.##.#.#.\n....###..#\n..#.#..#.#\n#..#.#.###\n.##...##.#\n.....#.#..";
    String result = monitoringStationPuzzleSolver.solvePart1(asList(input.split("\n")));
    assertThat(result, Matchers.is("(6.0,3.0) - 41"));
  }

  @Test
  public void solvePart1_4() {
    String input = ".#..##.###...#######\n##.############..##.\n.#.######.########.#\n.###.#######.####.#.\n#####.##.#.##.###.##\n..#####..#.#########\n####################\n#.####....###.#.#.##\n##.#################\n#####.##.###..####..\n..######..##.#######\n####.##.####...##..#\n.#####..#.######.###\n##...#.##########...\n#.##########.#######\n.####.#.###.###.#.##\n....##.##.###..#####\n.#.#.###########.###\n#.#.#.#####.####.###\n###.##.####.##.#..##";
    String result = monitoringStationPuzzleSolver.solvePart1(asList(input.split("\n")));
    assertThat(result, Matchers.is("(11.0,13.0) - 210"));
  }


  @Test
  public void solvePart2() {
  }
}
