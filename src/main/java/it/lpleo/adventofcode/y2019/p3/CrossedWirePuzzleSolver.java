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

    List<Point> crossPoint = SegmentService
        .getCrossingPoints(firstLineSegments, secondLineSegments);
    return getLowerDistanceFromOrigin(crossPoint) + "";
  }

  private String getLowerDistanceFromOrigin(List<Point> crossPoints) {
    crossPoints = crossPoints.subList(1, crossPoints.size());
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


  @Override
  public String solvePart2(List<String> inputList) {
    return null;
  }
}
