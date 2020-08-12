package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.extractCursorFromData;
import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.extractFirstParameter;
import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.extractSecondParameter;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;

public class EqualsHandler implements MoveHandler {

  private static final long MOVE_VALUE = 8;
  public static final int MOVE_PARAMETERS_NUMBER = 4;


  @Override
  public boolean shouldHandle(long moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public VonNeumannMachineOutput move(VonNeumannMachine vonNeumannMachine) {
    long parameter1 = extractFirstParameter(vonNeumannMachine);
    long parameter2 = extractSecondParameter(vonNeumannMachine);
    long result = extractCursorFromData(vonNeumannMachine,2);
    vonNeumannMachine.write(result, (parameter1 == parameter2) ? 1L : 0L);
    vonNeumannMachine.move(vonNeumannMachine.getCursor() + MOVE_PARAMETERS_NUMBER);
    return VonNeumannMachineOutput.builder().result((parameter1 == parameter2) ? 1 : 0).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
