package it.lpleo.adventofcode.y2019.p7;

import static it.lpleo.adventofcode.y2019.p7.AmplificationCircuitPuzzleHelper.runMachinesForPermutationsPT1;
import static it.lpleo.adventofcode.y2019.p7.AmplificationCircuitPuzzleHelper.runMachinesForPermutationsPT2;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.y2019.p7.service.MathService;
import java.util.List;

public class AmplificationCircuitPuzzleSolver extends PuzzleSolver {

  public AmplificationCircuitPuzzleSolver() {
    super(new Puzzle(7, 2019, "AmplificationCircuit"));
  }

  @Override
  public String solvePart1(List<String> inputList) {
    List<String> permutations = MathService.permutation("01234");

    long max = -1;
    for (String permutation : permutations) {
      long outputValue = runMachinesForPermutationsPT1(inputList, permutation);
      if (outputValue > max) {
        max = outputValue;
      }
    }
    return max + "";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    List<String> permutations = MathService.permutation("56789");

    long max = -1;
    for (String permutation : permutations) {
      long outputValue = runMachinesForPermutationsPT2(inputList, permutation);
      if (outputValue > max) {
        max = outputValue;
      }
    }
    return max + "";
  }
}
