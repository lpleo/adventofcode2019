package it.lpleo.adventofcode.y2019.p7;

import static it.lpleo.adventofcode.string.InputManipulator.convertStringListInIntegersArray;
import static java.lang.Character.getNumericValue;
import static java.util.Arrays.asList;

import it.lpleo.adventofcode.string.InputManipulator;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.handler.EqualsHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfFalseHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfTrueHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.LessThanHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.SumHandler;
import it.lpleo.adventofcode.y2019.p7.domain.InputFromVonNeumannMachineHandler;
import it.lpleo.adventofcode.y2019.p7.domain.OutputFromVonNeumannMachineHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AmplificationCircuitPuzzleHelper {

  private static List<MoveHandler> handlers = asList(new SumHandler(),
      new MultiplicationHandler(), new EqualsHandler(), new LessThanHandler(),
      new JumpIfFalseHandler(), new JumpIfTrueHandler(), new InputFromVonNeumannMachineHandler(),
      new OutputFromVonNeumannMachineHandler(), new ErrorHandler());

  public static long runMachinesForPermutationsPT1(List<String> inputList, String permutation) {
    long nextInput = 0;
    for (VonNeumannMachine vonNeumannMachine : generateVonNeumannMachines(inputList,
        permutation)) {
      vonNeumannMachine.addInputValue(nextInput);
      StoppableVonNeumannMachineRunner.run(vonNeumannMachine, handlers);
      nextInput = vonNeumannMachine.getLastOutputIfExist();
    }

    return nextInput;
  }


  public static Long runMachinesForPermutationsPT2(List<String> inputList, String permutation) {
    List<VonNeumannMachine> vonNeumannMachineList = generateVonNeumannMachines(inputList,
        permutation);
    VonNeumannMachine runningVonNeumannMachine = vonNeumannMachineList.get(0);
    Long lastOutput = 0L;
    Long lastValidOutput = null;
    while (!lastMachineHasEnded(vonNeumannMachineList)) {
      runningVonNeumannMachine.addInputValue(lastOutput);

      StoppableVonNeumannMachineRunner
          .runStoppableMachine(runningVonNeumannMachine, handlers);

      lastOutput = runningVonNeumannMachine.getLastOutputIfExist();
      lastValidOutput = (lastOutput != null) ? lastOutput : lastValidOutput;
      runningVonNeumannMachine = selectNextMachine(runningVonNeumannMachine,
          vonNeumannMachineList);
    }

    return lastValidOutput;
  }

  private static boolean lastMachineHasEnded(List<VonNeumannMachine> vonNeumannMachineList) {
    return vonNeumannMachineList.get(vonNeumannMachineList.size() - 1)
        .endProgram();
  }

  private static List<VonNeumannMachine> generateVonNeumannMachines(List<String> inputList,
      String permutation) {
    List<VonNeumannMachine> vonNeumannMachineList = new ArrayList<>();

    for (char phaseSetting : permutation.toCharArray()) {
      List<String> inputCopyList = InputManipulator.copy(inputList);
      Queue<Long> inputFifoQueue = new LinkedList<>();
      inputFifoQueue.add((long) getNumericValue(phaseSetting));
      vonNeumannMachineList.add(new VonNeumannMachine(
          convertStringListInIntegersArray(inputCopyList), inputFifoQueue, new LinkedList<>()));
    }
    return vonNeumannMachineList;
  }

  private static VonNeumannMachine selectNextMachine(VonNeumannMachine runningVonNeumannMachine,
      List<VonNeumannMachine> vonNeumannMachineList) {
    for (int i = 0; i < vonNeumannMachineList.size(); i++) {
      if (vonNeumannMachineList.get(i).equals(runningVonNeumannMachine)) {
        int index = ((i + 1) == vonNeumannMachineList.size()) ? 0 : i + 1;
        return vonNeumannMachineList.get(index);
      }
    }
    throw new RuntimeException("Machine not found");
  }

}
