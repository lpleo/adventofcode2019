package it.lpleo.adventofcode.y2019.p9.domain.handler;

import static it.lpleo.adventofcode.y2019.p5.domain.HandlerConstant.INSTRUCTION_LENGTH;
import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractFirstParameter;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;

public class ChangeRelativeBaseHandler implements MoveHandler {

  public static final long MOVE_VALUE = 9;
  public static final int MOVE_PARAMETERS_NUMBER = 2;
  

  @Override
  public boolean shouldHandle(long moveValue) {
    return MOVE_VALUE == moveValue;
  }

  @Override
  public HandlerOutput move(VonNeumannMachine vonNeumannMachine) {
    long amount = extractFirstParameter(vonNeumannMachine);
    vonNeumannMachine.addAtRelativeCursor(amount);
    vonNeumannMachine.move(vonNeumannMachine.getCursor() + MOVE_PARAMETERS_NUMBER);
    return HandlerOutput.builder().result(amount).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
