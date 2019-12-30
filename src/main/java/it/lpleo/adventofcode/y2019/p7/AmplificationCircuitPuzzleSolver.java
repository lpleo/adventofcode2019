package it.lpleo.adventofcode.y2019.p7;

import static it.lpleo.adventofcode.y2019.p7.AmplificationCircuitPuzzleHelper.runMachinesForPermutationsPT1;
import static it.lpleo.adventofcode.y2019.p7.AmplificationCircuitPuzzleHelper.runMachinesForPermutationsPT2;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.y2019.p7.service.MathService;
import java.util.List;

public class AmplificationCircuitPuzzleSolver extends PuzzleSolver {

  public AmplificationCircuitPuzzleSolver(Puzzle puzzle) {
    super(puzzle);
  }

  @Override
  public String solvePart1(List<String> inputList) {
    List<String> permutations = MathService.permutation("01234");

    int max = -1;
    for (String permutation : permutations) {
      int outputValue = runMachinesForPermutationsPT1(inputList, permutation);
      if (outputValue > max) {
        max = outputValue;
      }
    }
    return max + "";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    List<String> permutations = MathService.permutation("56789");

    int max = -1;
    for (String permutation : permutations) {
      int outputValue = runMachinesForPermutationsPT2(inputList, permutation);
      if (outputValue > max) {
        max = outputValue;
      }
    }
    return max + "";
  }
}
