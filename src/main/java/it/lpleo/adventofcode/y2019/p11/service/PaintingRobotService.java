package it.lpleo.adventofcode.y2019.p11.service;

import it.lpleo.adventofcode.domain.IPoint;
import it.lpleo.adventofcode.domain.Point;
import it.lpleo.adventofcode.service.PointService;
import it.lpleo.adventofcode.y2019.p11.domain.Color;
import it.lpleo.adventofcode.y2019.p11.domain.ColoredPoint;
import it.lpleo.adventofcode.y2019.p11.domain.Direction;
import it.lpleo.adventofcode.y2019.p11.domain.PaintingRobot;

public class PaintingRobotService {

  private static PaintingRobotService instance;
  private static PointService pointService;

  public static PaintingRobotService getInstance() {
    if (instance == null) {
      instance = new PaintingRobotService();
      pointService = PointService.getInstance();
    }
    return instance;
  }

  public void moveTo(PaintingRobot paintingRobot, Direction direction) {
    paintingRobot.setDirection(direction);
    IPoint point = calculateNextPoint(paintingRobot.getPosition(), paintingRobot.getDirection());
    ColoredPoint extractedPoint = pointService
        .extractPoint(point, paintingRobot.getColoredPoints());
    if (extractedPoint == null) {
      extractedPoint = new ColoredPoint(point.getX(), point.getY(), Color.BLACK);
    }
    paintingRobot.setPosition(extractedPoint);
  }

  public void colorPoint(PaintingRobot paintingRobot, Color color) {
    paintingRobot.getPosition().setColor(color);
    if (!pointService.pointExist(paintingRobot.getPosition(), paintingRobot.getColoredPoints())) {
      paintingRobot.getColoredPoints().add(paintingRobot.getPosition());
    }
  }

  private Point calculateNextPoint(IPoint startingPoint, Direction direction) {
    switch (direction) {
      case UP:
        return new Point(startingPoint.getX(), startingPoint.getY() + 1);
      case RIGHT:
        return new Point(startingPoint.getX() + 1, startingPoint.getY());
      case DOWN:
        return new Point(startingPoint.getX(), startingPoint.getY() - 1);
      case LEFT:
        return new Point(startingPoint.getX() - 1, startingPoint.getY());
      default:
        throw new RuntimeException("Unrecognized direction [" + direction + "]");
    }
  }
}
