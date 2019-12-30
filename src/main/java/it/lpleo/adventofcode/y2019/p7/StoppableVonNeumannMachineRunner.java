package it.lpleo.adventofcode.y2019.p7;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.service.InstructionDecoderService;
import java.util.Comparator;
import java.util.List;

public class StoppableVonNeumannMachineRunner {

  public static boolean runStoppableMachine(VonNeumannMachine vonNeumannMachine,
      List<MoveHandler> handlers) {

    handlers.sort(Comparator.comparingInt(MoveHandler::getIndex));
    HandlerOutput handlerOutput = new HandlerOutput();
    while (vonNeumannMachine.getActualValue() != 99 && !handlerOutput.isWait()) {
      for (MoveHandler moveHandler : handlers) {
        boolean shouldHandle = moveHandler.shouldHandle(
            InstructionDecoderService.getMoveValue(vonNeumannMachine.getActualValue()));
        if (shouldHandle) {
          handlerOutput = moveHandler.move(vonNeumannMachine);
          break;
        }
      }
    }

    return vonNeumannMachine.getActualValue() == 99;
  }

  public static void run(VonNeumannMachine vonNeumannMachine, List<MoveHandler> handlers) {
    handlers.sort(Comparator.comparingInt(MoveHandler::getIndex));
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
