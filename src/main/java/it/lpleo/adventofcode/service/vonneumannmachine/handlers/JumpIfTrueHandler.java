package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.extractFirstParameter;
import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.extractSecondParameter;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;


public class JumpIfTrueHandler implements MoveHandler {

  private static final long MOVE_VALUE = 5;
  public static final int MOVE_PARAMETERS_NUMBER = 3;


  @Override
  public boolean shouldHandle(long moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public VonNeumannMachineOutput move(VonNeumannMachine vonNeumannMachine) {
    long parameter1 = extractFirstParameter(vonNeumannMachine);
    if (parameter1 != 0) {
      long parameter2 = extractSecondParameter(vonNeumannMachine);
      vonNeumannMachine.move(parameter2);
      return VonNeumannMachineOutput.builder().result(1).build();
    }
    vonNeumannMachine.move(vonNeumannMachine.getCursor() + MOVE_PARAMETERS_NUMBER);
    return VonNeumannMachineOutput.builder().result(0).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
