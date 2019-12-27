package it.lpleo.adventofcode.y2019.p7;

import static it.lpleo.adventofcode.string.InputManipulator.convertInIntegersArray;
import static java.lang.Character.getNumericValue;
import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.*;
import static java.util.Arrays.asList;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.string.InputManipulator;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachineRunner;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.EqualsHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.InputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfFalseHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfTrueHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.LessThanHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.OutputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.SumHandler;
import it.lpleo.adventofcode.y2019.p7.service.MathService;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AmplificationCircuitPuzzleSolver extends PuzzleSolver {

  private List<MoveHandler> pt1Handlers = asList(new SumHandler(),
      new MultiplicationHandler(), new EqualsHandler(), new JumpIfFalseHandler(),
      new JumpIfTrueHandler(),
      new LessThanHandler(), new ErrorHandler());

  public AmplificationCircuitPuzzleSolver(Puzzle puzzle) {
    super(puzzle);
  }

  @Override
  public String solvePart1(List<String> inputList) {
    List<String> permutations = MathService.permutation("01234");

    int max = -1;
    for (String permutation : permutations) {
      int outputValue = extractOutputValue(inputList, permutation);
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
    String rperm = "";
    for (String permutation : permutations) {
      int outputValue = extractOutputValue(inputList, permutation);
      if (outputValue > max) {
        rperm = permutation;
        max = outputValue;
      }
    }
    System.out.println(rperm);
    return max + "";
  }

  private int extractOutputValue(List<String> inputList, String permutation) {
    String amplificatorsInput = "0";
    for (char phaseSetting : permutation.toCharArray()) {
      Queue<Integer> fifoQueue = new LinkedList<>();
      fifoQueue.add(getNumericValue(phaseSetting));
      fifoQueue.add(parseInt(amplificatorsInput.trim()));
      List<MoveHandler> newMoveHandlers = createHandlers(fifoQueue);
      List<String> inputCopyList = InputManipulator.copy(inputList);

      VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
          convertInIntegersArray(inputCopyList));
      VonNeumannMachineRunner.run(vonNeumannMachine, newMoveHandlers);

      StringBuilder stringBuilder = new StringBuilder();
      for (Integer result : fifoQueue) {
        stringBuilder.append(result);
        stringBuilder.append("\n");
      }
      amplificatorsInput = stringBuilder.toString();
    }
    return parseInt(amplificatorsInput.trim());
  }

  private List<MoveHandler> createHandlers(Queue<Integer> fifoQueue) {
    List<MoveHandler> newMoveHandlers = new ArrayList<>(pt1Handlers);
    newMoveHandlers.add(new InputHandler(fifoQueue));
    newMoveHandlers.add(new OutputHandler(fifoQueue));
    return newMoveHandlers;
  }
}
