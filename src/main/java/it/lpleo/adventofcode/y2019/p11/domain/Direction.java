package it.lpleo.adventofcode.y2019.p11.domain;

import static java.util.Arrays.stream;

public enum Direction {
  UP(0), RIGHT(1), DOWN(2), LEFT(3);

  private final double value;

  Direction(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  public static Direction byValue(double value) {
    return stream(Direction.values()).filter(direction -> direction.getValue() == value).findFirst()
        .orElseThrow(() -> new RuntimeException("Unrecognized direction value [" + value + "]"));
  }
  
  public static double getMaxValue() {
    Direction maxValueDirection = Direction.UP;
    for(Direction direction : Direction.values()) {
      if(direction.getValue() > maxValueDirection.getValue()) {
        maxValueDirection = direction;
      }
    }
    return maxValueDirection.getValue();
  }
  
  public static double getMinValue() {
    Direction minValueDirection = Direction.UP;
    for(Direction direction : Direction.values()) {
      if(direction.getValue() < minValueDirection.getValue()) {
        minValueDirection = direction;
      }
    }
    return minValueDirection.getValue();
  }
}
