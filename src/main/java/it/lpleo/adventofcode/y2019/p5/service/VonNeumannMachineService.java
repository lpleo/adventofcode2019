package it.lpleo.adventofcode.y2019.p5.service;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;

public class VonNeumannMachineService {

  public static int extractParameter(VonNeumannMachine vonNeumannMachine, int parameterNumber) {
    int parameterMode = InstructionDecoderService
        .getParameterMode(vonNeumannMachine.getActualValue(), parameterNumber);

    if (parameterMode == 0) {
      return vonNeumannMachine
          .getReferencedValue(vonNeumannMachine.getCursor() + parameterNumber + 1);
    }
    return vonNeumannMachine.getValue(vonNeumannMachine.getCursor() + parameterNumber + 1);
  }
}
