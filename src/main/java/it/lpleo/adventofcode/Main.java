package it.lpleo.adventofcode;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.y2019.PuzzleSolvers;

import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    int specificPuzzle = getNumber(args[0]);
    List<PuzzleSolver> puzzleSolvers = PuzzleSolvers.instantiate2019PuzzleSolvers();
    if (specificPuzzle > 0 && puzzleSolvers.size() > specificPuzzle) {
      puzzleSolvers = Collections.singletonList(puzzleSolvers.get(specificPuzzle));
    }
    PuzzleSolvers.solvePuzzles(puzzleSolvers);
  }

  private static int getNumber(String candidateNumber) {
    if (candidateNumber != null && candidateNumber.length() > 0) {
      try {
        return (Integer.parseInt(candidateNumber) - 1);
      } catch (Exception e) {
        return -1;
      }
    }
    return -1;
  }
}
