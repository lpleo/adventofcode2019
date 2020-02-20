package it.lpleo.adventofcode.y2019.p2.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class VonNeumannMachine {

  private Map<Long, Long> memory;
  private long cursor = 0;
  private long relativeCursor = 0;
  private Queue<Long> inputValues;
  private Queue<Long> outputValues;

  public VonNeumannMachine(long[] instructions) {
    this.memory = initalizeMemory(instructions);
    this.inputValues = new LinkedList<>();
    this.outputValues = new LinkedList<>();
  }

  public VonNeumannMachine(long[] instructions, Queue<Long> inputValues,
      Queue<Long> outputValues) {
    this.memory = initalizeMemory(instructions);
    this.inputValues = inputValues;
    this.outputValues = outputValues;
  }

  public long getCursor() {
    return this.cursor;
  }

  public long getRelativeCursor() {
    return relativeCursor;
  }

  public long getActualValue() {
    return memory.get(cursor);
  }

  public long getValue(long cursor) {
    if (!memory.containsKey(cursor)) {
      memory.put(cursor, 0L);
    }
    return memory.get(cursor);
  }

  public long getReferencedValue(long cursor) {
    return getValue(getValue(cursor));
  }

  public long getRelativeBaseValue(long cursor) {
    return getValue(relativeCursor + getValue(cursor));
  }

  public void addAtRelativeCursor(long amount) {
    relativeCursor += amount;
  }

  public void write(long cursor, long amount) {
    memory.put(cursor, amount);
  }

  public void move(long cursor) {
    this.cursor = cursor;
  }

  public boolean hasFinished() {
    return this.getActualValue() == 99;
  }

  public boolean hasNotFinished() {
    return this.getActualValue() != 99;
  }

  public void addInputValue(Long inputValue) {
    if (inputValue != null) {
      this.inputValues.add(inputValue);
    }
  }

  public void addOutputValue(long value) {
    this.outputValues.add(value);
  }

  public long getNextInput() {
    if (this.inputValues.size() > 0) {
      return this.inputValues.poll();
    }
    throw new RuntimeException("There are no input left");
  }

  public Long getLastOutputIfExist() {
    if (this.outputValues.size() > 0) {
      return this.outputValues.poll();
    }
    return null;
  }

  public Queue<Long> getOutputValues() {
    return this.outputValues;
  }

  private static Map<Long, Long> initalizeMemory(long[] instructions) {
    Map<Long, Long> memory = new HashMap<>();
    for (int i = 0; i < instructions.length; i++) {
      memory.put((long) i, instructions[i]);
    }
    return memory;
  }
}
