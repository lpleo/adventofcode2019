package it.lpleo.adventofcode.y2019.p5.domain.handler;

import static it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService.extractParameter;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import java.util.List;

public class OutputHandler implements MoveHandler {

  private static final int MOVE_VALUE = 4;
  private List<Integer> output;

  public OutputHandler() {
    this.output = null;
  }

  public OutputHandler(List<Integer> outputResult) {
    this.output = outputResult;
  }

  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == MOVE_VALUE;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    int cursor = vonNeumannMachine.getCursor();
    if (output != null) {
      output.add(extractParameter(vonNeumannMachine, 0));
    } else {
      System.out.println("RESULT TEST: " + extractParameter(vonNeumannMachine, 0));
    }
    vonNeumannMachine.move(cursor + 2);
  }

  @Override
  public int getIndex() {
    return MOVE_VALUE;
  }
}
