package it.lpleo.adventofcode.service;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.domain.Point;
import it.lpleo.adventofcode.domain.Straight;
import it.lpleo.adventofcode.domain.StraightType;
import it.lpleo.adventofcode.y2019.p10.domain.Asteroid;
import org.hamcrest.Matchers;
import org.junit.Test;

public class StraightServiceTest {

  @Test
  public void getStraight() {
    Point a = new Point(0,0);
    Point b = new Point(1,2);
    Straight result = StraightService.getInstance().getStraight(a,b);
    assertThat(result.getM(), Matchers.is(2.0));
    assertThat(result.getQ(), Matchers.is(0.0));
    assertThat(result.getStraightType(), Matchers.is(StraightType.NORMAL));
  }
}
