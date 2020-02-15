package it.lpleo.adventofcode.service;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import it.lpleo.adventofcode.domain.IPoint;

public class PointService {

  private static PointService pointService;

  public static PointService getInstance() {
    if (pointService == null) {
      pointService = new PointService();
    }
    return pointService;
  }

  private PointService() {
    
  }

  public double calculateDistance(IPoint pointA, IPoint pointB) {
    double xdiff = pointB.getX() - pointA.getX();
    double ydiff = pointB.getY() - pointA.getY();
    return sqrt(pow(xdiff, 2.0) + pow(ydiff, 2.0));
  }

}
