package it.lpleo.adventofcode.y2019.p3;

import static java.lang.Math.abs;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.y2019.p3.domain.Point;
import it.lpleo.adventofcode.y2019.p3.domain.Segment;
import it.lpleo.adventofcode.y2019.p3.service.SegmentService;
import java.util.List;

public class CrossedWirePuzzleSolver extends PuzzleSolver {

  public CrossedWirePuzzleSolver(Puzzle puzzle) {
    super(puzzle);
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
    
    int lowerPath = -1;
    for (Point crossPoint : crossingPoints) {
      int pathLength1 = SegmentService.getPathLengthToPoint(firstLineSegments, crossPoint);
      int pathLength2 = SegmentService.getPathLengthToPoint(secondLineSegments, crossPoint);
      int totalPath = pathLength1 + pathLength2;
      if (totalPath < lowerPath || lowerPath == -1) {
        lowerPath = totalPath;
      }
    }

    return lowerPath + "";
  }

  private String getLowerDistanceFromOrigin(List<Point> crossPoints) {
    Point nearestCandidate = crossPoints.get(0);
    for (Point crossPoint : crossPoints) {
      int oldDistance = abs(nearestCandidate.getX()) + abs(nearestCandidate.getY());
      int newDistance = abs(crossPoint.getX()) + abs(crossPoint.getY());
      if (newDistance < oldDistance) {
        nearestCandidate = crossPoint;
      }
    }
    return abs(nearestCandidate.getX()) + abs(nearestCandidate.getY()) + "";
  }
}
