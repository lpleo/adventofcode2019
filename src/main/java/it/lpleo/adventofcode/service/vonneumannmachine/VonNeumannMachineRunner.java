package it.lpleo.adventofcode.service.vonneumannmachine;

import it.lpleo.adventofcode.domain.vonneumannmachine.HandlerOutput;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.MoveHandler;
import java.util.Comparator;
import java.util.List;

public class VonNeumannMachineRunner {

  public static HandlerOutput run(VonNeumannMachine vonNeumannMachine, List<MoveHandler> handlers) {

    handlers.sort(Comparator.comparingLong(MoveHandler::getIndex));
    HandlerOutput handlerOutput = new HandlerOutput();
    while (vonNeumannMachine.getActualValue() != 99 && !handlerOutput.isWait()) {
      for (MoveHandler moveHandler : handlers) {
        boolean shouldHandle = moveHandler.shouldHandle(
            VonNeumannMachineService.decodeMoveValue(vonNeumannMachine.getActualValue()));
        if (shouldHandle) {
          handlerOutput = moveHandler.move(vonNeumannMachine);
          break;
        }
      }
    }

    return handlerOutput;
  }
}
