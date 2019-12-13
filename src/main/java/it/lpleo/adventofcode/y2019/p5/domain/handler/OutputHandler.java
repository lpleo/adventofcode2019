package it.lpleo.adventofcode.y2019.p5.domain.handler;

import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractParameter;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;

public class OutputHandler implements MoveHandler {

  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == 4;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    int cursor = vonNeumannMachine.getCursor();
    System.out.println("RESULT TEST: " + extractParameter(vonNeumannMachine, 0));
    vonNeumannMachine.move(cursor + 2);
  }
}
