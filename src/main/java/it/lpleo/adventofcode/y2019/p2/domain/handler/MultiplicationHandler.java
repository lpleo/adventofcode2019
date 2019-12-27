package it.lpleo.adventofcode.y2019.p2.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;

public class MultiplicationHandler implements MoveHandler {

  private static final int MOVE_VALUE = 2;

  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    int cursor = vonNeumannMachine.getCursor();
    int operand1 = vonNeumannMachine.getReferencedValue(cursor + 1);
    int operand2 = vonNeumannMachine.getReferencedValue(cursor + 2);
    int destination = vonNeumannMachine.getValue(cursor + 3);
    vonNeumannMachine.write(destination, (operand1 * operand2));
    vonNeumannMachine.move(cursor + 4);
  }

  @Override
  public int getIndex() {
    return MOVE_VALUE;
  }
}
