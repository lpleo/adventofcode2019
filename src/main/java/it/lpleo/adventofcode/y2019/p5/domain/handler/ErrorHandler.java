package it.lpleo.adventofcode.y2019.p5.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;

public class ErrorHandler implements MoveHandler {

  private static final int MOVE_VALUE = Integer.MAX_VALUE;

  @Override
  public boolean shouldHandle(int moveValue) {
    return true;
  }

  @Override
  public HandlerOutput move(VonNeumannMachine vonNeumannMachine) {
    throw new RuntimeException("Should not reach here");
  }

  @Override
  public int getIndex() {
    return MOVE_VALUE;
  }
}
