package it.lpleo.adventofcode.y2019.p7;

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
import java.util.List;

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
    String sequence = "";
    for (String permutation : permutations) {
      int oldOutputValue = 0;
      for (char inputValue : permutation.toCharArray()) {
        List<Integer> results = new ArrayList<>();
        List<MoveHandler> newMoveHandlers = createHandlers(inputValue, oldOutputValue, results);
        List<String> inputCopyList = InputManipulator.copy(inputList);

        VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
            InputManipulator.convertInIntegersArray(inputCopyList));
        VonNeumannMachineRunner.run(vonNeumannMachine, newMoveHandlers);

        oldOutputValue = results.get(0);
      }

      if (oldOutputValue > max) {
        sequence = permutation;
        max = oldOutputValue;
      }
    }
    return max + "";
  }

  private List<MoveHandler> createHandlers(char inputValue, int oldOutput, List<Integer> results) {
    List<MoveHandler> newMoveHandlers = new ArrayList<>(pt1Handlers);
    newMoveHandlers.add(new InputHandler(
        new ByteArrayInputStream(
            (inputValue + "\n" + oldOutput + "").getBytes(StandardCharsets.UTF_8))));
    newMoveHandlers.add(new OutputHandler(results));
    return newMoveHandlers;
  }

  @Override
  public String solvePart2(List<String> inputList) {
    return null;
  }
}
