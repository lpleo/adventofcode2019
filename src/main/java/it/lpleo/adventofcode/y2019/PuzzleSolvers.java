package it.lpleo.adventofcode.y2019;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.service.FileService;
import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.y2019.p1.RocketEquationPuzzleSolver;
import it.lpleo.adventofcode.y2019.p2.Error1202PuzzleSolver;

import it.lpleo.adventofcode.y2019.p3.CrossedWirePuzzleSolver;
import it.lpleo.adventofcode.y2019.p4.SecureContainerPuzzleSolver;
import it.lpleo.adventofcode.y2019.p5.ChanceOfAsteroidsPuzzleSolver;
import it.lpleo.adventofcode.y2019.p6.UniversalOrbitMapPuzzleSolver;
import it.lpleo.adventofcode.y2019.p7.AmplificationCircuitPuzzleSolver;
import it.lpleo.adventofcode.y2019.p8.SpaceImageFormatPuzzleSolver;
import it.lpleo.adventofcode.y2019.p9.SensorBoostPuzzleSolver;
import java.util.ArrayList;
import java.util.List;

public class PuzzleSolvers {

  public static List<PuzzleSolver> instantiate2019PuzzleSolvers() {
    List<PuzzleSolver> puzzles2019 = new ArrayList<>();
    puzzles2019.add(new RocketEquationPuzzleSolver());
    puzzles2019.add(new Error1202PuzzleSolver());
    puzzles2019.add(new CrossedWirePuzzleSolver());
    puzzles2019.add(new SecureContainerPuzzleSolver());
    puzzles2019.add(new ChanceOfAsteroidsPuzzleSolver());
    puzzles2019.add(new UniversalOrbitMapPuzzleSolver());
    puzzles2019.add(new AmplificationCircuitPuzzleSolver());
    puzzles2019.add(new SpaceImageFormatPuzzleSolver());
    puzzles2019.add(new SensorBoostPuzzleSolver());
    return puzzles2019;
  }

  public static void solvePuzzles(List<PuzzleSolver> puzzleSolvers) {
    FileService fileService = FileService.getInstance();
    for (PuzzleSolver puzzleSolver : puzzleSolvers) {

      Puzzle puzzle = puzzleSolver.getPuzzle();

      List<String> inputList = fileService.readFile(puzzle.getPath());
      String solution1 = puzzleSolver.solvePart1(inputList);
      String solution2 = puzzleSolver.solvePart2(inputList);

      System.out.println(
          "The solution for puzzle [" + puzzle.getYear() + " " + puzzle.getNumber() + ".1 " + puzzle
              .getName() + "] is " + solution1);
      System.out.println(
          "The solution for puzzle [" + puzzle.getYear() + " " + puzzle.getNumber() + ".2 " + puzzle
              .getName() + "] is " + solution2);
    }
  }
}
