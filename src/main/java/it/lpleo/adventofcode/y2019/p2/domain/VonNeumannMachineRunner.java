package it.lpleo.adventofcode.y2019.p2.domain;

import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.service.InstructionDecoderService;
import java.util.List;

public class VonNeumannMachineRunner {

  public static void run(VonNeumannMachine vonNeumannMachine, List<MoveHandler> handlers) {
    while (vonNeumannMachine.getActualValue() != 99) {
      for (MoveHandler moveHandler : handlers) {
        boolean shouldHandle = moveHandler.shouldHandle(
            InstructionDecoderService.getMoveValue(vonNeumannMachine.getActualValue()));
        if (shouldHandle) {
          moveHandler.move(vonNeumannMachine);
          break;
        }
      }
    }
  }
}
