package it.lpleo.adventofcode.y2019.p2;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.service.InputManipulatorService;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.DeprecatedVNMH;
import it.lpleo.adventofcode.y2019.p2.domain.handler.DeprecatedEH;
import it.lpleo.adventofcode.y2019.p2.domain.handler.DeprecatedMH;
import it.lpleo.adventofcode.y2019.p2.domain.handler.DeprecatedMLH;
import it.lpleo.adventofcode.y2019.p2.domain.handler.DeprecatedSH;
import java.util.ArrayList;
import java.util.List;

public class Error1202PuzzleSolver extends PuzzleSolver {

  private List<DeprecatedMH> handlers;

  public Error1202PuzzleSolver() {
    super(new Puzzle(2, 2019, "Error1202"));
    handlers = asList(new DeprecatedSH(), new DeprecatedMLH(), new DeprecatedEH());
  }

  @Override
  public String solvePart1(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        InputManipulatorService.convertStringListInIntegersArray(inputList));
    DeprecatedVNMH.run(vonNeumannMachine, handlers);
    return vonNeumannMachine.getValue(0) + "";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    int result;
    for (int a = 0; a < 99; a++) {
      for (int b = 0; b < 99; b++) {
        List<String> inputListCopy = new ArrayList<>(inputList);
        inputListCopy.set(1, a + "");
        inputListCopy.set(2, b + "");
        result = parseInt(solvePart1(inputListCopy));
        if (19690720 == result) {
          return (100 * a) + b + "";
        }
      }
    }
    throw new RuntimeException("No result found");
  }

}
