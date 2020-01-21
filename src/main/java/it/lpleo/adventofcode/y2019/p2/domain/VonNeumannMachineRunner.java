package it.lpleo.adventofcode.y2019.p2.domain;

import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService;
import java.util.Comparator;
import java.util.List;

public class VonNeumannMachineRunner {

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
