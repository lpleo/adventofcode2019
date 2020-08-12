package it.lpleo.adventofcode.y2019.p2.domain.handler;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;

public interface DeprecatedMH {

  boolean shouldHandle(long moveValue);

  void move(VonNeumannMachine vonNeumannMachine);

  long getIndex();
}
