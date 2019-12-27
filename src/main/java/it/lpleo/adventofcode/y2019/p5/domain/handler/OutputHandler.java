package it.lpleo.adventofcode.y2019.p5.domain.handler;

import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractParameter;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import java.util.List;
import java.util.Queue;

public class OutputHandler implements MoveHandler {

  private static final int MOVE_VALUE = 4;
  private Queue<Integer> fifoQueue;

  public OutputHandler() {
    this.fifoQueue = null;
  }

  public OutputHandler(Queue<Integer> fifoQueue) {
    this.fifoQueue = fifoQueue;
  }

  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    int cursor = vonNeumannMachine.getCursor();
    writeValue(extractParameter(vonNeumannMachine, 0));
    vonNeumannMachine.move(cursor + 2);
  }

  private void writeValue(int value) {
    if (fifoQueue != null) {
      fifoQueue.add(value);
      return;
    }

    System.out.println("RESULT TEST: " + value);
  }

  @Override
  public int getIndex() {
    return MOVE_VALUE;
  }
}
