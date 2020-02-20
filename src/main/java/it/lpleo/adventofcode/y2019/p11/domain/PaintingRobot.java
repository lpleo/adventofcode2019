package it.lpleo.adventofcode.y2019.p11.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class PaintingRobot {

  private List<ColoredPoint> coloredPoints;
  private ColoredPoint position;
  private Direction direction;

  public PaintingRobot(Color color) {
    coloredPoints = new ArrayList<>();
    position = new ColoredPoint(0, 0, color);
    direction = Direction.UP;
  }

  public void setPosition(ColoredPoint actualPoint) {
    this.position = actualPoint;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}
