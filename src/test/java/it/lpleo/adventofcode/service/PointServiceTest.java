package it.lpleo.adventofcode.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.domain.geometry.IPoint;
import it.lpleo.adventofcode.domain.geometry.Point;
import it.lpleo.adventofcode.y2019.p11.domain.Color;
import it.lpleo.adventofcode.y2019.p11.domain.ColoredPoint;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PointServiceTest {

  public static final PointService POINT_SERVICE = PointService.getInstance();

  @Test
  public void calculateDistance() {
    Point asteroidA = new Point(0.0, 0.0);
    Point asteroidB = new Point(1.0, 1.0);
    double distance = POINT_SERVICE.calculateDistance(asteroidA, asteroidB);
    assertThat(distance, is(Math.sqrt(2)));
  }

  @Test
  public void pointExist() {
    Point point = new Point(1, 2);
    List<IPoint> points = createPointList();
    assertTrue(POINT_SERVICE.pointExist(point, points));
  }

  @Test
  public void extractPoint() {
    Point point = new Point(1, 2);
    List<IPoint> points = createPointList();
    IPoint result = POINT_SERVICE.extractPoint(point, points);
    assertThat(result, is(points.get(0)));
  }

  private List<IPoint> createPointList() {
    List<IPoint> points = new ArrayList<>();
    points.add(new ColoredPoint(1, 2, Color.WHITE));
    points.add(new ColoredPoint(2, 1, Color.BLACK));
    return points;
  }
}
