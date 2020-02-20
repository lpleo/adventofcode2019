package it.lpleo.adventofcode.domain.geometry;

import java.util.Comparator;

public class StraightByMComparator implements Comparator<Straight> {

  @Override
  public int compare(Straight o1, Straight o2) {
    if (o2.getStraightType().equals(StraightType.PARALLELY)) {
      return 1;
    }
    if (o1.getStraightType().equals(StraightType.PARALLELY)) {
      return -1;
    }

    return Double.compare(o1.getM(), o2.getM());
  }
}
