package it.lpleo.adventofcode.y2019.p5.domain.handler;

import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractFirstParameter;
import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractCursorFromData;
import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractSecondParameter;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;


public class LessThanHandler implements MoveHandler {

  private static final long MOVE_VALUE = 7;
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
    vonNeumannMachine.write(result, (parameter1 < parameter2) ? 1L : 0L);
    vonNeumannMachine.move(vonNeumannMachine.getCursor() + MOVE_PARAMETERS_NUMBER);
    return HandlerOutput.builder().result((parameter1 < parameter2) ? 1 : 0).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
