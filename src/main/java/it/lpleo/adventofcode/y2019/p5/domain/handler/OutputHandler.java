package it.lpleo.adventofcode.y2019.p5.domain.handler;

import static it.lpleo.adventofcode.y2019.p5.domain.HandlerConstant.INSTRUCTION_LENGTH;
import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractFirstParameter;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;

import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import java.util.Queue;

public class OutputHandler implements MoveHandler {

  private static final long MOVE_VALUE = 4;
  public static final int MOVE_PARAMETERS_NUMBER = 2;
  
  private Queue<Long> fifoQueue;

  public OutputHandler() {
    this.fifoQueue = null;
  }

  public OutputHandler(Queue<Long> fifoQueue) {
    this.fifoQueue = fifoQueue;
  }

  @Override
  public boolean shouldHandle(long moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public HandlerOutput move(VonNeumannMachine vonNeumannMachine) {
    long cursor = vonNeumannMachine.getCursor();
    long value = extractFirstParameter(vonNeumannMachine);
    writeValue(value);
    vonNeumannMachine.move(cursor + MOVE_PARAMETERS_NUMBER);
    return HandlerOutput.builder().result(value).wait(true).build();
  }

  private void writeValue(long value) {
    if (fifoQueue != null) {
      fifoQueue.add(value);
      return;
    }

    System.out.println("RESULT TEST: " + value);
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }
}
