package it.lpleo.adventofcode.y2019.p2.domain;

import java.util.LinkedList;
import java.util.Queue;

public class VonNeumannMachine {

  private int[] instructions;
  private int cursor = 0;
  private Queue<Integer> inputValues;
  private Queue<Integer> outputValues;

  public VonNeumannMachine(int[] instructions) {
    this.instructions = instructions;
    this.inputValues = new LinkedList<>();
    this.outputValues = new LinkedList<>();
  }

  public VonNeumannMachine(int[] instructions, Queue<Integer> inputValues,
      Queue<Integer> outputValues) {
    this.instructions = instructions;
    this.inputValues = inputValues;
    this.outputValues = outputValues;
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

  public boolean endProgram() {
    return this.getActualValue() == 99;
  }

  public void addInputValue(int inputValue) {
    this.inputValues.add(inputValue);
  }

  public void addOutputValue(int value) {
    this.outputValues.add(value);
  }

  public int getNextInput() {
    return this.inputValues.poll();
  }

  public Integer getLastOutputIfExist() {
    if (this.outputValues.size() > 0) {
      return this.outputValues.poll();
    }
    return null;
  }
}
