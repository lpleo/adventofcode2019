package it.lpleo.adventofcode.y2019.p3.service;

import it.lpleo.adventofcode.y2019.p3.domain.Point;

public class PointService {

  public static Point calculatePoint(char direction, int length) {
    switch (direction) {
      case 'U':
        return Point.builder().x(0).y(length).build();
      case 'D':
        return Point.builder().x(0).y(-length).build();
      case 'L':
        return Point.builder().x(-length).y(0).build();
      case 'R':
        return Point.builder().x(length).y(0).build();
    }
    throw new RuntimeException("Unknow direction " + direction);
  }
}
