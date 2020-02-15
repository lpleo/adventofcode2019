package it.lpleo.adventofcode.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Point implements IPoint {

  private double x;
  private double y;

  public void sum(Point point) {
    this.x += point.getX();
    this.y += point.getY();
  }

  public Point clone() {
    return new Point(x, y);
  }
}
