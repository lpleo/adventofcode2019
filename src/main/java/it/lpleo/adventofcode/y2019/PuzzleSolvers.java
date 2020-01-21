package it.lpleo.adventofcode.y2019;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.file.FileHandler;
import it.lpleo.adventofcode.puzzle.Puzzle;
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
    /*puzzles2019.add(new RocketEquationPuzzleSolver(getRocketEquationPuzzle()));
    puzzles2019.add(new Error1202PuzzleSolver(getError1202Puzzle()));
    puzzles2019.add(new CrossedWirePuzzleSolver(getCrossedWirePuzzle()));
    puzzles2019.add(new SecureContainerPuzzleSolver(getSecureContainerPuzzle()));
    puzzles2019.add(new ChanceOfAsteroidsPuzzleSolver(getChanceOfAsteroidsPuzzle()));
    puzzles2019.add(new UniversalOrbitMapPuzzleSolver(getUniversalOrbitMapPuzzle()));
    puzzles2019.add(new AmplificationCircuitPuzzleSolver(getAmplificationCircuitPuzzle()));
    puzzles2019.add(new SpaceImageFormatPuzzleSolver(getSpaceImageFormatPuzzle()));*/
    puzzles2019.add(new SensorBoostPuzzleSolver(getSensorBoostPuzzle()));
    return puzzles2019;
  }

  public static void solvePuzzles(List<PuzzleSolver> puzzleSolvers) {
    FileHandler fileHandler = FileHandler.getInstance();
    for (PuzzleSolver puzzleSolver : puzzleSolvers) {

      Puzzle puzzle = puzzleSolver.getPuzzle();

      List<String> inputList = fileHandler.readFile(puzzle.getPath());
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


  public static Puzzle getRocketEquationPuzzle() {
    return new Puzzle(1, 2019, "RocketEquation");
  }

  public static Puzzle getError1202Puzzle() {
    return new Puzzle(2, 2019, "Error1202");
  }

  public static Puzzle getCrossedWirePuzzle() {
    return new Puzzle(3, 2019, "CrossedWire");
  }

  public static Puzzle getSecureContainerPuzzle() {
    return new Puzzle(4, 2019, "SecureContainer");
  }

  public static Puzzle getChanceOfAsteroidsPuzzle() {
    return new Puzzle(5, 2019, "ChanceOfAsteroids");
  }

  public static Puzzle getUniversalOrbitMapPuzzle() {
    return new Puzzle(6, 2019, "UniversalOrbitMap");
  }

  public static Puzzle getAmplificationCircuitPuzzle() {
    return new Puzzle(7, 2019, "AmplificationCircuit");
  }

  public static Puzzle getSpaceImageFormatPuzzle() {
    return new Puzzle(8, 2019, "SpaceImageFormat");
  }

  private static Puzzle getSensorBoostPuzzle() {
    return new Puzzle(9, 2019, "SensorBoostPuzzle");
  }
}
