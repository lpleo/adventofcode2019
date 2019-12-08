package it.lpleo.adventofcode.y2019.p3;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class CrossedWirePuzzleSolver extends PuzzleSolver {

    public CrossedWirePuzzleSolver(Puzzle puzzle) {
        super(puzzle);
    }

    @Override
    public String solvePart1(List<String> inputList) {
        List<VisitedPoint> visitedPoints = new ArrayList<>();
        VisitedPoint actualPoint = new VisitedPoint(0,0);
        visitedPoints.add(actualPoint);
        int linenumber = 0;
        for(String line : inputList) {
            for(String directionStep : line.split(",")) {
                char direction = directionStep.charAt(0);
                int steps = Integer.parseInt(directionStep.substring(1));
                while(steps >= 0) {
                    actualPoint = calculateNextPoint(actualPoint,getDirectionPoint(direction));
                    actualPoint.setVisited();
                    visitedPoints.add(actualPoint);
                    steps--;
                }
            }
            linenumber++;
        }
    }

    @Override
    public String solvePart2(List<String> inputList) {
        return null;
    }

    private Point getDirectionPoint(char direction) {
        switch (direction) {
            case 'U':
                return new Point(0, 1);
            case 'D':
                return new Point(0, -1);
            case 'L':
                return new Point(-1, 0);
            case 'R':
                return new Point(1, 0);
        }
        throw new RuntimeException("Unknow direction " + direction);
    }
    
    private VisitedPoint calculateNextPoint(VisitedPoint actualPoint, Point nextCoordinate) {
        int coordinateA = actualPoint.getCoordinateA() + nextCoordinate.getCoordinateA();
        int coordinateB = actualPoint.getCoordinateB() + nextCoordinate.getCoordinateB();
        return new VisitedPoint(coordinateA,coordinateB);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Point {
        private int coordinateA;
        private int coordinateB;
    }

    @Data
    @AllArgsConstructor
    private static class VisitedPoint extends Point {
        private boolean[] visited = {false, false};

        public VisitedPoint(int coordinateA, int coordinateB) {
            super(coordinateA, coordinateB);
        }
    }
}
