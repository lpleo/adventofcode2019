package it.lpleo.adventofcode.domain.geometry;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ThreeDimensionalPoint implements I3DPoint {

  double[] coordinates;

  public ThreeDimensionalPoint(double x, double y, double z) {
    this.coordinates = new double[]{x, y, z};
  }

  @Override
  public double getZ() {
    return coordinates[2];
  }

  @Override
  public double getX() {
    return coordinates[0];
  }

  @Override
  public double getY() {
    return coordinates[1];
  }

  @Override
  public double[] getCoordinates() {
    return coordinates;
  }
}
