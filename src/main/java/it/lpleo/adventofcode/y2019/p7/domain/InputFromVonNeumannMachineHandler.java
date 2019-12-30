package it.lpleo.adventofcode.y2019.p7.domain;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import java.util.Queue;
import java.util.Scanner;

public class InputFromVonNeumannMachineHandler implements MoveHandler {

  private static final int MOVE_VALUE = 3;
  
  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public HandlerOutput move(VonNeumannMachine vonNeumannMachine) {
    int cursor = vonNeumannMachine.getCursor();
    int position = vonNeumannMachine.getValue(cursor + 1);

    int value = vonNeumannMachine.getNextInput();
    vonNeumannMachine.write(position, value);
    vonNeumannMachine.move(cursor + 2);
    return HandlerOutput.builder().result(value).build();
  }

  @Override
  public int getIndex() {
    return MOVE_VALUE;
  }
}
