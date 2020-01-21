package it.lpleo.adventofcode.y2019.p2.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;

public interface MoveHandler {

  boolean shouldHandle(long moveValue);

  void move(VonNeumannMachine vonNeumannMachine);

  long getIndex();
}
