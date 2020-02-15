package it.lpleo.adventofcode.y2019.p3;

import static java.lang.Math.abs;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.domain.Point;
import it.lpleo.adventofcode.domain.Segment;
import it.lpleo.adventofcode.service.SegmentService;
import java.util.List;

public class CrossedWirePuzzleSolver extends PuzzleSolver {

  public CrossedWirePuzzleSolver() {
    super(new Puzzle(3, 2019, "CrossedWire"));
  }

  @Override
  public String solvePart1(List<String> inputList) {
    List<Segment> firstLineSegments = SegmentService.getSegments(inputList.get(0));
    List<Segment> secondLineSegments = SegmentService.getSegments(inputList.get(1));

    List<Point> crossingPoints = SegmentService
        .getCrossingPoints(firstLineSegments, secondLineSegments);
    crossingPoints = crossingPoints.subList(1, crossingPoints.size());

    return getLowerDistanceFromOrigin(crossingPoints) + "";
  }

  @Override
  public String solvePart2(List<String> inputList) {

    List<Segment> firstLineSegments = SegmentService.getSegments(inputList.get(0));
    List<Segment> secondLineSegments = SegmentService.getSegments(inputList.get(1));

    List<Point> crossingPoints = SegmentService
        .getCrossingPoints(firstLineSegments, secondLineSegments);
    crossingPoints = crossingPoints.subList(1, crossingPoints.size());

    double lowerPath = -1;
    for (Point crossPoint : crossingPoints) {
      double pathLength1 = SegmentService.getPathLengthToPoint(firstLineSegments, crossPoint);
      double pathLength2 = SegmentService.getPathLengthToPoint(secondLineSegments, crossPoint);
      double totalPath = pathLength1 + pathLength2;
      if (totalPath < lowerPath || lowerPath == -1) {
        lowerPath = totalPath;
      }
    }

    return lowerPath + "";
  }

  private String getLowerDistanceFromOrigin(List<Point> crossPoints) {
    Point nearestCandidate = crossPoints.get(0);
    for (Point crossPoint : crossPoints) {
      double oldDistance = abs(nearestCandidate.getX()) + abs(nearestCandidate.getY());
      double newDistance = abs(crossPoint.getX()) + abs(crossPoint.getY());
      if (newDistance < oldDistance) {
        nearestCandidate = crossPoint;
      }
    }
    return abs(nearestCandidate.getX()) + abs(nearestCandidate.getY()) + "";
  }
}
