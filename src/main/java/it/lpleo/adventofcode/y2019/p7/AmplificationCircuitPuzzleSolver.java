package it.lpleo.adventofcode.y2019.p7;

import static it.lpleo.adventofcode.string.InputManipulator.convertInIntegersArray;
import static java.lang.Character.getNumericValue;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.string.InputManipulator;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.EqualsHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.InputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfFalseHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfTrueHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.LessThanHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.OutputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.SumHandler;
import it.lpleo.adventofcode.y2019.p7.domain.InputFromVonNeumannMachineHandler;
import it.lpleo.adventofcode.y2019.p7.domain.OutputFromVonNeumannMachineHandler;
import it.lpleo.adventofcode.y2019.p7.service.MathService;
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
    for (String permutation : permutations) {
      int outputValue = extractOutputValue2(inputList, permutation);
      if (outputValue > max) {
        max = outputValue;
      }
    }
    return max + "";
  }

  private int extractOutputValue(List<String> inputList, String permutation) {
    String amplificatorsInput = "0";
    for (char phaseSetting : permutation.toCharArray()) {
      Queue<Integer> fifoQueue = new LinkedList<>();
      fifoQueue.add(getNumericValue(phaseSetting));
      fifoQueue.add(parseInt(amplificatorsInput.trim()));
      List<MoveHandler> newMoveHandlers = createHandlers(fifoQueue, fifoQueue);
      List<String> inputCopyList = InputManipulator.copy(inputList);

      VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
          convertInIntegersArray(inputCopyList));
      StoppableVonNeumannMachineRunner.run(vonNeumannMachine, newMoveHandlers);

      StringBuilder stringBuilder = new StringBuilder();
      for (Integer result : fifoQueue) {
        stringBuilder.append(result);
        stringBuilder.append("\n");
      }
      amplificatorsInput = stringBuilder.toString();
    }
    return parseInt(amplificatorsInput.trim());
  }

  private int extractOutputValue2(List<String> inputList, String permutation) {
    List<VonNeumannMachine> vonNeumannMachineList = new ArrayList<>();
    List<MoveHandler> newMoveHandlers = new ArrayList<>(pt1Handlers);
    newMoveHandlers.add(new InputFromVonNeumannMachineHandler());
    newMoveHandlers.add(new OutputFromVonNeumannMachineHandler());

    for (char phaseSetting : permutation.toCharArray()) {
      List<String> inputCopyList = InputManipulator.copy(inputList);
      Queue<Integer> inputFifoQueue = new LinkedList<>();
      inputFifoQueue.add(getNumericValue(phaseSetting));
      vonNeumannMachineList.add(new VonNeumannMachine(
          convertInIntegersArray(inputCopyList), inputFifoQueue, new LinkedList<>()));
    }

    VonNeumannMachine runningVonNeumannMachine = vonNeumannMachineList.get(0);
    runningVonNeumannMachine.addInputValue(0);
    Integer lastOutput = 0;
    boolean lastMachineEnd = vonNeumannMachineList.get(vonNeumannMachineList.size() - 1)
        .endProgram();
    while (!lastMachineEnd) {
      StoppableVonNeumannMachineRunner
          .runStoppableMachine(runningVonNeumannMachine, newMoveHandlers);

      lastMachineEnd = vonNeumannMachineList.get(vonNeumannMachineList.size() - 1)
          .endProgram();
      if (!lastMachineEnd) {
        lastOutput = runningVonNeumannMachine.getLastOutputIfExist();
        runningVonNeumannMachine = selectNextMachine(runningVonNeumannMachine,
            vonNeumannMachineList);
        if (lastOutput != null) {
          runningVonNeumannMachine.addInputValue(lastOutput);
        }
      }
    }

    Integer result = 0;

    try {
      result = vonNeumannMachineList.get(0).getNextInput();
    } catch (Exception e) {
      result = vonNeumannMachineList.get(vonNeumannMachineList.size() - 1).getLastOutputIfExist();
    }

    return result;
  }

  private VonNeumannMachine selectNextMachine(VonNeumannMachine runningVonNeumannMachine,
      List<VonNeumannMachine> vonNeumannMachineList) {
    for (int i = 0; i < vonNeumannMachineList.size(); i++) {
      if (vonNeumannMachineList.get(i).equals(runningVonNeumannMachine)) {
        int index = ((i + 1) == vonNeumannMachineList.size()) ? 0 : i + 1;
        return vonNeumannMachineList.get(index);
      }
    }
    throw new RuntimeException("Machine not found");
  }

  private List<MoveHandler> createHandlers(Queue<Integer> fifoQueueInput,
      Queue<Integer> fifoQueueOutput) {
    List<MoveHandler> newMoveHandlers = new ArrayList<>(pt1Handlers);
    newMoveHandlers.add(new InputHandler(fifoQueueInput));
    newMoveHandlers.add(new OutputHandler(fifoQueueOutput));
    return newMoveHandlers;
  }
}
