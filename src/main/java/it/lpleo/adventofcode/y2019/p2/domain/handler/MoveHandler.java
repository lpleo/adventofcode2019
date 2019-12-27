package it.lpleo.adventofcode.y2019.p2.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;

public interface MoveHandler {

  boolean shouldHandle(int moveValue);

  void move(VonNeumannMachine vonNeumannMachine);

  int getIndex();
}
