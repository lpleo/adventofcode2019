package it.lpleo.adventofcode.y2019.p5.domain.handler;

import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractParameter;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;

public class EqualsHandler implements MoveHandler {

  private static final int MOVE_VALUE = 8;

  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    int parameter1 = extractParameter(vonNeumannMachine, 0);
    int parameter2 = extractParameter(vonNeumannMachine, 1);
    int result = vonNeumannMachine.getValue(vonNeumannMachine.getCursor() + 3);
    vonNeumannMachine.write(result, (parameter1 == parameter2) ? 1 : 0);
    vonNeumannMachine.move(vonNeumannMachine.getCursor() + 4);
  }

  @Override
  public int getIndex() {
    return MOVE_VALUE;
  }
}
