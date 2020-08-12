package it.lpleo.adventofcode.y2019.p7;

import static it.lpleo.adventofcode.service.InputManipulatorService.convertStringListInIntegersArray;
import static java.lang.Character.getNumericValue;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.service.InputManipulatorService;
import it.lpleo.adventofcode.service.vonneumannmachine.HandlerList;
import it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineRunner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AmplificationCircuitPuzzleHelper {

  public static long runMachinesForPermutationsPT1(List<String> inputList, String permutation) {
    long nextInput = 0;
    for (VonNeumannMachine vonNeumannMachine : generateVonNeumannMachines(inputList,
        permutation)) {
      vonNeumannMachine.addInputValue(nextInput);
      VonNeumannMachineRunner
          .run(vonNeumannMachine, HandlerList.getIstance().getHandlers());
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

      VonNeumannMachineRunner
          .run(runningVonNeumannMachine, HandlerList.getIstance().getHandlers());

      lastOutput = runningVonNeumannMachine.getLastOutputIfExist();
      lastValidOutput = (lastOutput != null) ? lastOutput : lastValidOutput;
      runningVonNeumannMachine = selectNextMachine(runningVonNeumannMachine,
          vonNeumannMachineList);
    }

    return lastValidOutput;
  }

  private static boolean lastMachineHasEnded(List<VonNeumannMachine> vonNeumannMachineList) {
    return vonNeumannMachineList.get(vonNeumannMachineList.size() - 1)
        .hasFinished();
  }

  private static List<VonNeumannMachine> generateVonNeumannMachines(List<String> inputList,
      String permutation) {
    List<VonNeumannMachine> vonNeumannMachineList = new ArrayList<>();

    for (char phaseSetting : permutation.toCharArray()) {
      List<String> inputCopyList = InputManipulatorService.copy(inputList);
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
