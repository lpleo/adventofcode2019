package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;

public interface MoveHandler {

  boolean shouldHandle(long moveValue);

  VonNeumannMachineOutput move(VonNeumannMachine vonNeumannMachine);

  long getIndex();
}
