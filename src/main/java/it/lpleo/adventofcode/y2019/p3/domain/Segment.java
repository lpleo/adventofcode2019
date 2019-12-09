package it.lpleo.adventofcode.y2019.p3.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Segment {

  private Point a;
  private Point b;
  private int length;
}
