package it.lpleo.adventofcode.y2019.p11.domain;

import it.lpleo.adventofcode.domain.geometry.IPoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
public class ColoredPoint implements IPoint {

  public ColoredPoint(IPoint point, Color color) {
    this.x = point.getX();
    this.y = point.getY();
    this.color = color;
  }

  private double x;
  private double y;
  @Setter
  private Color color;
}
