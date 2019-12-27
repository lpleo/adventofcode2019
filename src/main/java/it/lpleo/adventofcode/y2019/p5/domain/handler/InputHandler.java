package it.lpleo.adventofcode.y2019.p5.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import java.io.InputStream;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class InputHandler implements MoveHandler {

  private static final int MOVE_VALUE = 3;
  private Scanner scanner;
  private Queue<Integer> fifoQueue;

  public InputHandler() {
    this.scanner = new Scanner(System.in);
  }

  public InputHandler(Queue<Integer> fifoQueue) {
    this.fifoQueue = fifoQueue;
  }

  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    int cursor = vonNeumannMachine.getCursor();
    int position = vonNeumannMachine.getValue(cursor + 1);

    vonNeumannMachine.write(position, extractValue());
    vonNeumannMachine.move(cursor + 2);
  }

  @Override
  public int getIndex() {
    return MOVE_VALUE;
  }

  private int extractValue() {
    if (fifoQueue != null) {
      return fifoQueue.poll();
    }

    System.out.println("Insert value: ");
    return scanner.nextInt();
  }
}
