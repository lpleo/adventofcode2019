package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.HandlerOutput;

public interface MoveHandler {

  boolean shouldHandle(long moveValue);

  HandlerOutput move(VonNeumannMachine vonNeumannMachine);

  long getIndex();
}
