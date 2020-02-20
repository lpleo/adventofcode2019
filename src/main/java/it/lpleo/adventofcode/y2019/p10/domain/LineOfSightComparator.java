package it.lpleo.adventofcode.y2019.p10.domain;

import it.lpleo.adventofcode.domain.geometry.StraightByMComparator;

public class LineOfSightComparator implements
    java.util.Comparator<LineOfSight> {

  private StraightByMComparator straightByMComparator = new StraightByMComparator();

  @Override
  public int compare(LineOfSight o1, LineOfSight o2) {
    return straightByMComparator.compare(o1.getStraight(), o2.getStraight());
  }
}
