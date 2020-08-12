package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.extractFirstParameter;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;

public class ChangeRelativeBaseHandler implements MoveHandler {

  public static final long MOVE_VALUE = 9;
  public static final int MOVE_PARAMETERS_NUMBER = 2;


  @Override
  public boolean shouldHandle(long moveValue) {
    return MOVE_VALUE == moveValue;
  }

  @Override
  public VonNeumannMachineOutput move(VonNeumannMachine vonNeumannMachine) {
    long amount = extractFirstParameter(vonNeumannMachine);
    vonNeumannMachine.addAtRelativeCursor(amount);
    vonNeumannMachine.move(vonNeumannMachine.getCursor() + MOVE_PARAMETERS_NUMBER);
    return VonNeumannMachineOutput.builder().result(amount).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
