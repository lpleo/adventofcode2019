package it.lpleo.adventofcode.y2019.p11.service;

import it.lpleo.adventofcode.service.vonneumannmachine.HandlerList;
import it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineRunner;
import it.lpleo.adventofcode.y2019.p11.domain.Color;
import it.lpleo.adventofcode.y2019.p11.domain.ColoredPoint;
import it.lpleo.adventofcode.y2019.p11.domain.Direction;
import it.lpleo.adventofcode.y2019.p11.domain.PaintingRobot;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.HandlerOutput;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.MoveHandler;
import java.util.Comparator;
import java.util.List;

public class PaintingRobotRunner {

  private static PaintingRobotRunner paintingRobotRunner;
  private static PaintingRobotService paintingRobotService;
  private static DirectionService directionService;
  private static List<MoveHandler> handlers;

  public static PaintingRobotRunner getInstance() {
    if (paintingRobotRunner == null) {
      paintingRobotRunner = new PaintingRobotRunner();
    }
    return paintingRobotRunner;
  }

  private PaintingRobotRunner() {
    PaintingRobotRunner.directionService = DirectionService.getIstance();
    PaintingRobotRunner.handlers = HandlerList.getIstance().getHandlers();
    PaintingRobotRunner.paintingRobotService = PaintingRobotService.getInstance();
  }

  public int run(VonNeumannMachine vonNeumannMachine, PaintingRobot paintingRobot) {
    while (vonNeumannMachine.hasNotFinished()) {
      vonNeumannMachine.addInputValue((long) paintingRobot.getPosition().getColor().getValue());

      HandlerOutput colorHandler = VonNeumannMachineRunner.run(vonNeumannMachine, handlers);
      HandlerOutput directionHandler = VonNeumannMachineRunner.run(vonNeumannMachine, handlers);

      paintingRobotService.colorPoint(paintingRobot, Color.byValue(colorHandler.getResult()));
      paintingRobotService.moveTo(paintingRobot,
          calculateDirection(directionHandler, paintingRobot.getDirection()));
    }
    return paintingRobot.getColoredPoints().size() - 1;
  }

  public String draw(PaintingRobot paintingRobot) {
    List<ColoredPoint> coloredPoints = paintingRobot.getColoredPoints();
    coloredPoints.sort(Comparator.comparingDouble(ColoredPoint::getX));
    double minX = coloredPoints.get(0).getX();
    double maxX = coloredPoints.get(coloredPoints.size() - 1).getX();
    coloredPoints.sort(Comparator.comparingDouble(ColoredPoint::getY));
    double minY = coloredPoints.get(0).getY();
    double maxY = coloredPoints.get(coloredPoints.size() - 1).getY();

    StringBuilder stringBuilder = new StringBuilder();

    for (double y = maxY; y >= minY; y--) {
      for (double x = minX; x <= maxX; x++) {
        boolean pointFound = false;
        for (ColoredPoint coloredPoint : coloredPoints) {
          if (coloredPoint.getX() == x && coloredPoint.getY() == y) {
            pointFound = true;
            stringBuilder.append(coloredPoint.getColor().equals(Color.WHITE) ? "#" : " ");
          }
        }
        if(!pointFound) {
          stringBuilder.append(" ");
        }
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }

  private Direction calculateDirection(HandlerOutput directionHandler, Direction oldDirection) {
    return directionHandler.getResult() == 0
        ? directionService.turnLeft(oldDirection)
        : directionService.turnRight(oldDirection);
  }

}

