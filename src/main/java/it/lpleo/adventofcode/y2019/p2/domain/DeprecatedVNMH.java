package it.lpleo.adventofcode.y2019.p2.domain;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.handler.DeprecatedMH;
import it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService;
import java.util.Comparator;
import java.util.List;

public class DeprecatedVNMH {

  public static void run(VonNeumannMachine vonNeumannMachine, List<DeprecatedMH> handlers) {
    handlers.sort(Comparator.comparingLong(DeprecatedMH::getIndex));
    while (vonNeumannMachine.getActualValue() != 99) {
      for (DeprecatedMH moveHandler : handlers) {
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
