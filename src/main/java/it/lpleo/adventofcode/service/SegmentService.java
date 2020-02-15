package it.lpleo.adventofcode.service;

import static java.lang.Math.*;
import static java.lang.Math.max;

import it.lpleo.adventofcode.domain.Point;
import it.lpleo.adventofcode.domain.Segment;
import it.lpleo.adventofcode.y2019.p3.service.PointService;
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

    return Segment.builder().a(startingPoint).b(endpoint).length(length).build();
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

  public static boolean pointBelongToSegment(Segment segment, Point point) {
    Point a = segment.getA();
    Point b = segment.getB();
    if (parallelXSegment(segment)) {
      if (point.getY() == a.getY()) {
        return (max(a.getX(), b.getX()) >= point.getX() && point.getX() >= min(a.getX(), b.getX()));
      }
    }

    if (parallelYSegment(segment)) {
      if (point.getX() == a.getX()) {
        return (max(a.getY(), b.getY()) >= point.getY() && point.getY() >= min(a.getY(), b.getY()));
      }
    }
    return false;
  }

  public static double getDistanceFromAOfPoint(Segment segment, Point point) {
    if (pointBelongToSegment(segment, point)) {
      if (parallelXSegment(segment)) {
        return abs(segment.getA().getX() - point.getX());
      }
      if (parallelYSegment(segment)) {
        return abs(segment.getA().getY() - point.getY());
      }
    }
    throw new RuntimeException("Point does not belong at segment");
  }

  public static double getPathLengthToPoint(List<Segment> pathSegments, Point point) {
    int pathLength = 0;
    for (Segment segment : pathSegments) {
      if (SegmentService.pointBelongToSegment(segment, point)) {
        pathLength += SegmentService.getDistanceFromAOfPoint(segment, point);
        break;
      }
      pathLength += segment.getLength();
    }
    return pathLength;
  }

  private static Point calculateIntersection(Segment parrallelXsegment, Segment parallelYSegment) {
    Point apx = parrallelXsegment.getA();
    Point bpx = parrallelXsegment.getB();
    Point apy = parallelYSegment.getA();
    Point bpy = parallelYSegment.getB();

    double xapx = min(apx.getX(), bpx.getX());
    double xbpx = max(apx.getX(), bpx.getX());
    double xapy = apy.getX();

    double yapy = min(apy.getY(), bpy.getY());
    double ybpy = max(apy.getY(), bpy.getY());
    double yapx = apx.getY();

    boolean betweenX = (xapx <= xapy && xapy <= xbpx);
    boolean betweenY = (yapy <= yapx && yapx <= ybpy);

    if (betweenX && betweenY) {
      return new Point(xapy, yapx);
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
