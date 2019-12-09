package it.lpleo.adventofcode.y2019.p2.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;

public class SumHandler implements MoveHandler {

  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == 1;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    int cursor = vonNeumannMachine.getCursor();
    int operand1 = vonNeumannMachine.getReferencedValue(cursor + 1);
    int operand2 = vonNeumannMachine.getReferencedValue(cursor + 2);
    int destination = vonNeumannMachine.getValue(cursor + 3);
    vonNeumannMachine.write(destination, (operand1 + operand2));
    vonNeumannMachine.move(cursor+4);
  }
}
