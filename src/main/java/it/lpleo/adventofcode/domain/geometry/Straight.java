package it.lpleo.adventofcode.domain.geometry;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Straight {

  private StraightType straightType;
  private double m;
  private double q;
}

