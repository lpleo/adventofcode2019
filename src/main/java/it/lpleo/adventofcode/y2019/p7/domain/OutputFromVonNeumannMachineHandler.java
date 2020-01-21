package it.lpleo.adventofcode.y2019.p7.domain;

import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractFirstParameter;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;

public class OutputFromVonNeumannMachineHandler implements MoveHandler {

  private static final long MOVE_VALUE = 4;
  public static final int MOVE_PARAMETERS_NUMBER = 2;
  

  @Override
  public boolean shouldHandle(long moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public HandlerOutput move(VonNeumannMachine vonNeumannMachine) {
    long cursor = vonNeumannMachine.getCursor();
    long value = extractFirstParameter(vonNeumannMachine);
    vonNeumannMachine.addOutputValue(value);
    vonNeumannMachine.move(cursor + MOVE_PARAMETERS_NUMBER);
    return HandlerOutput.builder().result(value).wait(true).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
