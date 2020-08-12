package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.extractFirstParameter;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;

public class OutputHandler implements MoveHandler {

  private static final long MOVE_VALUE = 4;
  public static final int MOVE_PARAMETERS_NUMBER = 2;


  @Override
  public boolean shouldHandle(long moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public VonNeumannMachineOutput move(VonNeumannMachine vonNeumannMachine) {
    long cursor = vonNeumannMachine.getCursor();
    long value = extractFirstParameter(vonNeumannMachine);
    vonNeumannMachine.addOutputValue(value);
    vonNeumannMachine.move(cursor + MOVE_PARAMETERS_NUMBER);
    return VonNeumannMachineOutput.builder().result(value).wait(true).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
