package it.lpleo.adventofcode.service.vonneumannmachine;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.MoveHandler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VonNeumannMachineRunner {

  public static List<VonNeumannMachineOutput> run(VonNeumannMachine vonNeumannMachine, List<MoveHandler> handlers) {
    List<VonNeumannMachineOutput> vonNeumannMachineOutputList = new ArrayList<>();
    while(vonNeumannMachine.hasNotFinished()) {
      vonNeumannMachineOutputList.add(runAndStopOnOutput(vonNeumannMachine,handlers));
    }
    return vonNeumannMachineOutputList;
  }

  public static VonNeumannMachineOutput runAndStopOnOutput(VonNeumannMachine vonNeumannMachine, List<MoveHandler> handlers) {

    handlers.sort(Comparator.comparingLong(MoveHandler::getIndex));
    VonNeumannMachineOutput vonNeumannMachineOutput = new VonNeumannMachineOutput();
    while (vonNeumannMachine.getActualValue() != 99 && !vonNeumannMachineOutput.isWait()) {
      for (MoveHandler moveHandler : handlers) {
        boolean shouldHandle = moveHandler.shouldHandle(
            VonNeumannMachineService.decodeMoveValue(vonNeumannMachine.getActualValue()));
        if (shouldHandle) {
          vonNeumannMachineOutput = moveHandler.move(vonNeumannMachine);
          break;
        }
      }
    }

    return vonNeumannMachineOutput;
  }
}
