package it.lpleo.adventofcode.y2019.p3.service;

import it.lpleo.adventofcode.y2019.p3.domain.Point;
import it.lpleo.adventofcode.y2019.p3.domain.Segment;
import java.util.ArrayList;
import java.util.List;

public class SegmentService {

  public static List<Segment> getSegments(String line) {
    List<Segment> segments = new ArrayList<>();
    Point startingPoint = Point.builder().x(0).y(0).build();
    for (String directionStep : line.split(",")) {
      Segment segment = getSegment(directionStep, startingPoint);
      segments.add(segment);
      startingPoint = segment.getB();
    }
    return segments;
  }

  public static Segment getSegment(String directionStep, Point startingPoint) {
    char direction = directionStep.charAt(0);
    int length = Integer.parseInt(directionStep.substring(1));

    Point temporaryPoint = PointService.calculatePoint(direction, length);
    Point endpoint = startingPoint.clone();
    endpoint.sum(temporaryPoint);

    return Segment.builder().a(startingPoint).b(endpoint).build();
  }


  public static List<Point> getCrossingPoints(List<Segment> firstLineSegments,
      List<Segment> secondLineSegments) {

    List<Point> crossingPoints = new ArrayList<>();
    for (Segment firstLineSegment : firstLineSegments) {
      for (Segment secondLineSegment : secondLineSegments) {
        if (getCrossingPoint(firstLineSegment, secondLineSegment) != null) {
          crossingPoints.add(getCrossingPoint(firstLineSegment, secondLineSegment));
        }
      }
    }
    return crossingPoints;
  }

  public static Point getCrossingPoint(Segment segment1, Segment segment2) {
    if (!parallelSegments(segment1, segment2)) {
      if (parallelXSegment(segment1)) {
        return calculateIntersection(segment1, segment2);
      } else {
        return calculateIntersection(segment2, segment1);
      }
    }
    return null;
  }

  private static Point calculateIntersection(Segment parrallelXsegment, Segment parallelYSegment) {
    int xa1 = Math.min(parrallelXsegment.getA().getX(), parrallelXsegment.getB().getX());
    int xb1 = Math.max(parrallelXsegment.getA().getX(), parrallelXsegment.getB().getX());
    int x2 = parallelYSegment.getA().getX();

    int ya2 = Math.min(parallelYSegment.getA().getY(), parallelYSegment.getB().getY());
    int yb2 = Math.max(parallelYSegment.getA().getY(), parallelYSegment.getB().getY());
    int y1 = parrallelXsegment.getA().getY();

    boolean betweenX = (xa1 <= x2 && x2 <= xb1);
    boolean betweenY = (ya2 <= y1 && y1 <= yb2);

    if (betweenX && betweenY) {
      return new Point(x2, y1);
    }

    return null;
  }

  private static boolean parallelSegments(Segment segment1, Segment segment2) {
    boolean parallelOnX = parallelXSegment(segment1) && parallelXSegment(segment2);
    boolean parallelOnY = parallelYSegment(segment1) && parallelYSegment(segment2);

    return parallelOnX || parallelOnY;
  }

  private static boolean parallelXSegment(Segment segment) {
    return segment.getA().getY() == segment.getB().getY();
  }

  private static boolean parallelYSegment(Segment segment) {
    return segment.getA().getX() == segment.getB().getX();
  }
}
