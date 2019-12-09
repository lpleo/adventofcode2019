package it.lpleo.adventofcode.y2019.p2;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.y2019.p2.domain.OpMove;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p2.domain.handler.SumHandler;
import java.util.ArrayList;
import java.util.List;

public class Error1202PuzzleSolver extends PuzzleSolver {

  private List<MoveHandler> handlers;

  public Error1202PuzzleSolver(Puzzle puzzle) {
    super(puzzle);
    handlers = asList(new SumHandler(), new MultiplicationHandler(), new ErrorHandler());
  }

  @Override
  public String solvePart1(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(createIntegerArray(inputList));

    while (vonNeumannMachine.getActualValue() != 99) {
      for (MoveHandler moveHandler : handlers) {
        if (moveHandler.shouldHandle(vonNeumannMachine.getActualValue())) {
          moveHandler.move(vonNeumannMachine);
          break;
        }
      }
    }
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

  private static int[] createIntegerArray(List<String> inputList) {
    int[] result = new int[inputList.size()];
    int i = 0;
    for (String splitted : inputList) {
      result[i] = parseInt(splitted);
      i -= -1;
    }
    return result;
  }

}
