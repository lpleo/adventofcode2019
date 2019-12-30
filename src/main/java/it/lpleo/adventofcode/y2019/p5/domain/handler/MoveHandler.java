package it.lpleo.adventofcode.y2019.p5.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;

public interface MoveHandler {

  boolean shouldHandle(int moveValue);

  HandlerOutput move(VonNeumannMachine vonNeumannMachine);

  int getIndex();
}
