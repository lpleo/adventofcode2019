package it.lpleo.adventofcode.y2019.p3.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.y2019.p3.domain.Point;
import it.lpleo.adventofcode.y2019.p3.domain.Segment;
import org.hamcrest.Matchers;
import org.junit.Test;

public class SegmentServiceTest {

  @Test
  public void getCrossingPointTest() {
    Segment segmentA = new Segment(new Point(8,5),new Point(3,5));
    Segment segmentB = new Segment(new Point(6,7),new Point(6,3));
    Point result = SegmentService.getCrossingPoint(segmentA,segmentB);

    assertNotNull(result);
    assertThat(result.getX(), Matchers.is(6));
    assertThat(result.getY(), Matchers.is(5));
  }
}
