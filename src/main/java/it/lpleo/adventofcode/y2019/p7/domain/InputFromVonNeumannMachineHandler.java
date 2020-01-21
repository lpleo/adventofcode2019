package it.lpleo.adventofcode.y2019.p7.domain;

import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.getParameterMode;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;

public class InputFromVonNeumannMachineHandler implements MoveHandler {

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
