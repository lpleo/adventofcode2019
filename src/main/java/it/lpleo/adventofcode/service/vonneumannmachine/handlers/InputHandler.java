package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.getParameterMode;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.HandlerOutput;

public class InputHandler implements MoveHandler {

  private static final long MOVE_VALUE = 3;
  public static final int MOVE_PARAMETERS_NUMBER = 2;

  @Override
  public boolean shouldHandle(long moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public HandlerOutput move(VonNeumannMachine vonNeumannMachine) {
    long cursor = vonNeumannMachine.getCursor();
    long position = vonNeumannMachine.getValue(cursor + 1);
    if (getParameterMode(vonNeumannMachine.getActualValue(), 0) == 2) {
      position += vonNeumannMachine.getRelativeCursor();
    }

    long value = vonNeumannMachine.getNextInput();
    vonNeumannMachine.write(position, value);
    vonNeumannMachine.move(cursor + MOVE_PARAMETERS_NUMBER);
    return HandlerOutput.builder().result(value).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
