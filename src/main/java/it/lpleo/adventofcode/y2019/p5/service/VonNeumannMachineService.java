package it.lpleo.adventofcode.y2019.p5.service;

import static it.lpleo.adventofcode.y2019.p5.domain.HandlerConstant.INSTRUCTION_LENGTH;
import static java.lang.Integer.parseInt;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;

public class VonNeumannMachineService {

  public static final int MOVE_CODE_DIMENSION = 2;
  public static final int REFERENCED_MODE = 0;
  public static final int IMMEDIATE_MODE = 1;
  public static final int RELATIVE_MODE = 2;

  public static long extractFirstParameter(VonNeumannMachine vonNeumannMachine) {
    return extractParameter(vonNeumannMachine, 0);
  }

  public static long extractSecondParameter(VonNeumannMachine vonNeumannMachine) {
    return extractParameter(vonNeumannMachine, 1);
  }

  public static long extractThirdParameter(VonNeumannMachine vonNeumannMachine) {
    return extractParameter(vonNeumannMachine, 2);
  }

  public static long extractParameter(VonNeumannMachine vonNeumannMachine, int parameterNumber) {
    long cursor = vonNeumannMachine.getCursor() + parameterNumber + 1;
    switch (getParameterMode(vonNeumannMachine.getActualValue(), parameterNumber)) {
      case REFERENCED_MODE:
        return vonNeumannMachine.getReferencedValue(cursor);
      case IMMEDIATE_MODE:
        return vonNeumannMachine.getValue(cursor);
      case RELATIVE_MODE:
        return vonNeumannMachine.getRelativeBaseValue(cursor);
    }
    throw new RuntimeException(
        "Unknow parameter " + getParameterMode(vonNeumannMachine.getActualValue(),
            parameterNumber));
  }

  public static long extractCursorFromData(VonNeumannMachine vonNeumannMachine, int parameterNumber) {
    long targetCursor = vonNeumannMachine.getValue(vonNeumannMachine.getCursor() + parameterNumber + 1);
    if (getParameterMode(vonNeumannMachine.getActualValue(), parameterNumber) == RELATIVE_MODE) {
      targetCursor += vonNeumannMachine.getRelativeCursor();
    }
    return targetCursor;
  }

  public static long decodeMoveValue(long encodedInstruction) {
    String instruction = encodedInstruction + "";
    if (instruction.length() == 1) {
      return parseInt(instruction);
    }
    return parseInt(instruction.substring(instruction.length() - MOVE_CODE_DIMENSION));
  }

  public static int getParameterMode(long encodedInstruction, long parameterPosition) {
    StringBuilder instruction = new StringBuilder(encodedInstruction + "");
    while (instruction.length() < INSTRUCTION_LENGTH) {
      instruction.insert(0, "0");
    }
    int intPosition = Math
        .toIntExact(instruction.length() - MOVE_CODE_DIMENSION - parameterPosition - 1);
    return parseInt(instruction.toString().charAt(intPosition) + "");
  }
}
