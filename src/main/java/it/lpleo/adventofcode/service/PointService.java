package it.lpleo.adventofcode.service;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import it.lpleo.adventofcode.domain.geometry.IPoint;
import java.util.List;

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

  public boolean pointExist(IPoint iPoint, List<? extends IPoint> points) {
    return extractPoint(iPoint, points) != null;
  }

  public <T extends IPoint> T extractPoint(IPoint iPoint, List<T> points) {
    for (T pointInList : points) {
      if (equalCoordinates(iPoint.getCoordinates(), pointInList.getCoordinates())) {
        return pointInList;
      }
    }
    return null;
  }

  public <T extends IPoint> void sumPoint(T iPointA, T iPointB, T iPointResult) {
    for (int i = 0; i < iPointA.getCoordinates().length; i++) {
      iPointResult.getCoordinates()[i] = iPointA.getCoordinates()[i] + iPointB.getCoordinates()[i];
    }
  }

  private boolean equalCoordinates(double[] coordinatesA, double[] coordinatesB) {
    int size = coordinatesA.length;
    for (int i = 0; i < size; i++) {
      if (coordinatesA[i] != coordinatesB[i]) {
        return false;
      }
    }
    return true;
  }
}
