package it.lpleo.adventofcode.y2019.p5.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;

public class OutputHandler implements MoveHandler {

  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == 4;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    int cursor = vonNeumannMachine.getCursor();
    System.out.println("RESULT TEST: " + vonNeumannMachine.getReferencedValue(cursor + 1));
    vonNeumannMachine.move(cursor + 2);
  }
}
