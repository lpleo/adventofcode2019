package it.lpleo.adventofcode.y2019.p5.service;

import static java.lang.Integer.parseInt;

public class InstructionDecoderService {

  public static final int MOVE_DIMENSION = 2;

  public static int getMoveValue(int encodedInstruction) {
    String instruction = encodedInstruction + "";
    if (instruction.length() == 1) {
      return parseInt(instruction);
    }
    return parseInt(instruction.substring(instruction.length() - MOVE_DIMENSION));
  }

  public static int getFirstParameterMode(int encodedInstruction) {
    return getParameterMode(encodedInstruction, 0);
  }

  public static int getSecondParameterMode(int encodedInstruction) {
    return getParameterMode(encodedInstruction, 1);
  }

  public static int getThirdParameterMode(int encodedInstruction) {
    return getParameterMode(encodedInstruction, 2);
  }

  public static int getParameterMode(int encodedInstruction, int position) {
    String instruction = encodedInstruction + "";
    if (instruction.length() > (position + MOVE_DIMENSION)) {
      return parseInt(
          instruction.charAt(instruction.length() - MOVE_DIMENSION - position - 1) + "");
    }
    return 0;
  }
}
 
