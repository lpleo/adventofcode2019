package it.lpleo.adventofcode.y2019.p5.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import java.util.Queue;
import java.util.Scanner;

public class InputHandler implements MoveHandler {

  private static final long MOVE_VALUE = 3;
  private Scanner scanner;
  private Queue<Long> fifoQueue;

  public InputHandler() {
    this.scanner = new Scanner(System.in);
  }

  public InputHandler(Queue<Long> fifoQueue) {
    this.fifoQueue = fifoQueue;
  }

  @Override
  public boolean shouldHandle(long moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public HandlerOutput move(VonNeumannMachine vonNeumannMachine) {
    long cursor = vonNeumannMachine.getCursor();
    long position = vonNeumannMachine.getValue(cursor + 1);

    long value = extractValue();
    vonNeumannMachine.write(position, value);
    vonNeumannMachine.move(cursor + 2);
    return HandlerOutput.builder().result(value).build();
  }

  @Override
  public long getIndex() {
    return MOVE_VALUE;
  }

  private long extractValue() {
    if (fifoQueue != null) {
      return fifoQueue.poll();
    }

    System.out.println("Insert value: ");
    return scanner.nextInt();
  }
}
