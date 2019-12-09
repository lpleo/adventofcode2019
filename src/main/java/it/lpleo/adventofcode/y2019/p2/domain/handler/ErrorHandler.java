package it.lpleo.adventofcode.y2019.p2.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;

public class ErrorHandler implements MoveHandler {

  @Override
  public boolean shouldHandle(int moveValue) {
    return true;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    throw new RuntimeException("Should not reach here");
  }
}
