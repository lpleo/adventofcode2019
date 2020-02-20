package it.lpleo.adventofcode.y2019.p10.domain;

import it.lpleo.adventofcode.domain.geometry.IPoint;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asteroid implements IPoint {

  private double x;
  private double y;
}
