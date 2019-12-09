package it.lpleo.adventofcode.y2019.p3.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import it.lpleo.adventofcode.y2019.p3.domain.Point;
import it.lpleo.adventofcode.y2019.p3.domain.Segment;
import org.hamcrest.Matchers;
import org.junit.Test;

public class SegmentServiceTest {

  @Test
  public void getCrossingPointTest() {
    Segment segmentA = Segment.builder().a(new Point(8, 5)).b(new Point(3, 5)).build();
    Segment segmentB = Segment.builder().a(new Point(6, 7)).b(new Point(6, 3)).build();
    Point result = SegmentService.getCrossingPoint(segmentA, segmentB);

    assertNotNull(result);
    assertThat(result.getX(), Matchers.is(6));
    assertThat(result.getY(), Matchers.is(5));
  }

  @Test
  public void pointBelongToSegment() {
    Segment segment = Segment.builder().a(new Point(8, 5)).b(new Point(4, 5)).build();
    Point point = new Point(7, 5);
    assertTrue(SegmentService.pointBelongToSegment(segment, point));

    segment = Segment.builder().a(new Point(5, 8)).b(new Point(5, 4)).build();
    point = new Point(5, 8);
    assertTrue(SegmentService.pointBelongToSegment(segment, point));

    segment = Segment.builder().a(new Point(5, 8)).b(new Point(5, 4)).build();
    point = new Point(7, 8);
    assertFalse(SegmentService.pointBelongToSegment(segment, point));
  }

  @Test
  public void getDistanceFromAOfPoint() {
    Segment segment = Segment.builder().a(new Point(8, -10)).b(new Point(8, 5)).build();
    Point point = new Point(8, -1);
    assertThat(SegmentService.getDistanceFromAOfPoint(segment, point), is(9));

    segment = Segment.builder().a(new Point(8, -10)).b(new Point(8, 5)).build();
    point = new Point(8, 1);
    assertThat(SegmentService.getDistanceFromAOfPoint(segment, point), is(11));

    segment = Segment.builder().a(new Point(0, 0)).b(new Point(10, 0)).build();
    point = new Point(6, 0);
    assertThat(SegmentService.getDistanceFromAOfPoint(segment, point), is(6));

    segment = Segment.builder().a(new Point(10, 0)).b(new Point(0, 0)).build();
    point = new Point(6, 0);
    assertThat(SegmentService.getDistanceFromAOfPoint(segment, point), is(4));
  }
}
