package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;

public class ErrorHandler implements MoveHandler {

  private static final long MOVE_VALUE = Integer.MAX_VALUE;

  @Override
  public boolean shouldHandle(long moveValue) {
    return true;
  }

  @Override
  public VonNeumannMachineOutput move(VonNeumannMachine vonNeumannMachine) {
    throw new RuntimeException("Should not reach here");
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
