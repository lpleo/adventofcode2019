package it.lpleo.adventofcode.y2019.p7;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService;
import java.util.Comparator;
import java.util.List;

public class StoppableVonNeumannMachineRunner {

  public static HandlerOutput runStoppableMachine(VonNeumannMachine vonNeumannMachine,
      List<MoveHandler> handlers) {

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

  public static void run(VonNeumannMachine vonNeumannMachine, List<MoveHandler> handlers) {
    handlers.sort(Comparator.comparingLong(MoveHandler::getIndex));
    while (vonNeumannMachine.getActualValue() != 99) {
      for (MoveHandler moveHandler : handlers) {
        boolean shouldHandle = moveHandler.shouldHandle(
            VonNeumannMachineService.decodeMoveValue(vonNeumannMachine.getActualValue()));
        if (shouldHandle) {
          moveHandler.move(vonNeumannMachine);
          break;
        }
      }
    }
  }
}
