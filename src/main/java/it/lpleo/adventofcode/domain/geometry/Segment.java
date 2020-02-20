package it.lpleo.adventofcode.domain.geometry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Segment {

  private Point a;
  private Point b;
  private double length;
}
