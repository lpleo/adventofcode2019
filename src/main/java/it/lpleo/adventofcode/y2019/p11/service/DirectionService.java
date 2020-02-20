package it.lpleo.adventofcode.y2019.p11.service;

import static it.lpleo.adventofcode.y2019.p11.domain.Direction.getMaxValue;
import static it.lpleo.adventofcode.y2019.p11.domain.Direction.getMinValue;

import it.lpleo.adventofcode.y2019.p11.domain.Direction;

public class DirectionService {

  private static DirectionService istance;

  public static DirectionService getIstance() {
    if (istance == null) {
      istance = new DirectionService();
    }
    return istance;
  }

  private DirectionService() {
  }

  public Direction turnRight(Direction actualDirection) {
    boolean isOverScale = actualDirection.getValue() + 1 > getMaxValue();
    return isOverScale
        ? Direction.byValue(getMinValue())
        : Direction.byValue(actualDirection.getValue() + 1);
  }

  public Direction turnLeft(Direction actualDirection) {
    boolean isOverScale = actualDirection.getValue() - 1 < getMinValue();
    return isOverScale
        ? Direction.byValue(getMaxValue())
        : Direction.byValue(actualDirection.getValue() - 1);
  }
}
