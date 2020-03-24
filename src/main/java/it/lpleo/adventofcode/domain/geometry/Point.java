package it.lpleo.adventofcode.domain.geometry;

import lombok.Getter;

@Getter
public class Point implements IPoint {

  private double[] coordinates;

  public Point(double x, double y) {
    this.coordinates = new double[]{x, y};
  }

  private Point() {
    this.coordinates = new double[2];
  }

  public static Point builder() {
    return new Point();
  }

  public Point clone() {
    return new Point(coordinates[0], coordinates[1]);
  }

  @Override
  public double getX() {
    return coordinates[0];
  }

  @Override
  public double getY() {
    return coordinates[1];
  }

  public Point x(double x) {
    coordinates[0] = x;
    return this;
  }

  public Point y(double y) {
    coordinates[1] = y;
    return this;
  }

  @Override
  public double[] getCoordinates() {
    return this.coordinates;
  }

  public Point build() {
    return this;
  }
}
