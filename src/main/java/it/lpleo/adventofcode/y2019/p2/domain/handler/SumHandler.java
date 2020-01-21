package it.lpleo.adventofcode.y2019.p2.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;

public class SumHandler implements MoveHandler {

  private static final long MOVE_VALUE = 1;

  @Override
  public boolean shouldHandle(long moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    long cursor = vonNeumannMachine.getCursor();
    long operand1 = vonNeumannMachine.getReferencedValue(cursor + 1);
    long operand2 = vonNeumannMachine.getReferencedValue(cursor + 2);
    long destination = vonNeumannMachine.getValue(cursor + 3);
    vonNeumannMachine.write(destination, (operand1 + operand2));
    vonNeumannMachine.move(vonNeumannMachine.getCursor() + 4);
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
