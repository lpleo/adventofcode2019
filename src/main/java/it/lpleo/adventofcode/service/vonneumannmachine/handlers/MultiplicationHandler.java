package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.extractFirstParameter;
import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.extractCursorFromData;
import static it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineService.extractSecondParameter;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.HandlerOutput;


public class  MultiplicationHandler implements MoveHandler {

  private static final long MOVE_VALUE = 2;
  public static final int MOVE_PARAMETERS_NUMBER = 4;


  @Override
  public boolean shouldHandle(long moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public HandlerOutput move(VonNeumannMachine vonNeumannMachine) {
    long parameter1 = extractFirstParameter(vonNeumannMachine);
    long parameter2 = extractSecondParameter(vonNeumannMachine);
    long result = extractCursorFromData(vonNeumannMachine,2);
    vonNeumannMachine.write(result, parameter1 * parameter2);
    vonNeumannMachine.move(vonNeumannMachine.getCursor() + MOVE_PARAMETERS_NUMBER);
    return HandlerOutput.builder().result(parameter1 * parameter2).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
