package it.lpleo.adventofcode.y2019.p2.domain;

public class VonNeumannMachine {

  int[] instructions;
  int cursor = 0;

  public VonNeumannMachine(int[] instructions) {
    this.instructions = instructions;
  }

  public int getCursor() {
    return this.cursor;
  }

  public int getActualValue() {
    return instructions[cursor];
  }

  public int getValue(int cursor) {
    return instructions[cursor];
  }
  
  public int getReferencedValue(int cursor) {
    return instructions[instructions[cursor]];
  }

  public void write(int cursor, int amount) {
    instructions[cursor] = amount;
  }

  public void move(int cursor) {
    this.cursor = cursor;
  }
}
