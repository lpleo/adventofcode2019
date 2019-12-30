package it.lpleo.adventofcode.y2019.p7.domain;

import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractParameter;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import java.util.Queue;

public class OutputFromVonNeumannMachineHandler implements MoveHandler {

  private static final int MOVE_VALUE = 4;

  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public HandlerOutput move(VonNeumannMachine vonNeumannMachine) {
    int cursor = vonNeumannMachine.getCursor();
    int value = extractParameter(vonNeumannMachine, 0);
    vonNeumannMachine.addOutputValue(value);
    vonNeumannMachine.move(cursor + 2);
    return HandlerOutput.builder().result(value).wait(true).build();
  }

  @Override
  public int getIndex() {
    return MOVE_VALUE;
  }
}
