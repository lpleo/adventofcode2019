package it.lpleo.adventofcode.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.domain.Point;
import it.lpleo.adventofcode.y2019.p10.domain.Asteroid;
import org.junit.Test;

public class PointServiceTest {

  @Test
  public void calculateDistance() {
    Point asteroidA = new Point(0.0, 0.0);
    Point asteroidB = new Point(1.0, 1.0);
    double distance = PointService.getInstance().calculateDistance(asteroidA, asteroidB);
    assertThat(distance, is(Math.sqrt(2)));
  }
}
