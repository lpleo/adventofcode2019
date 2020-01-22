package it.lpleo.adventofcode.y2019.p5.domain.handler;

import static it.lpleo.adventofcode.y2019.p5.domain.HandlerConstant.INSTRUCTION_LENGTH;
import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractFirstParameter;
import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractSecondParameter;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;


public class JumpIfFalseHandler implements MoveHandler {

  private static final long MOVE_VALUE = 6;
  public static final int MOVE_PARAMETERS_NUMBER = 3;
  

  @Override
  public boolean shouldHandle(long moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public HandlerOutput move(VonNeumannMachine vonNeumannMachine) {
    long parameter1 = extractFirstParameter(vonNeumannMachine);
    if (parameter1 == 0) {
      long parameter2 = extractSecondParameter(vonNeumannMachine);
      vonNeumannMachine.move(parameter2);
      return HandlerOutput.builder().result(1).build();
    } 
    vonNeumannMachine.move(vonNeumannMachine.getCursor() + MOVE_PARAMETERS_NUMBER);
    return HandlerOutput.builder().result(0).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
