package it.lpleo.adventofcode.y2019.p11;

import static it.lpleo.adventofcode.service.InputManipulatorService.convertStringListInIntegersArray;

import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.y2019.p11.domain.Color;
import it.lpleo.adventofcode.y2019.p11.domain.PaintingRobot;
import it.lpleo.adventofcode.y2019.p11.service.DirectionService;
import it.lpleo.adventofcode.y2019.p11.service.PaintingRobotRunner;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import java.util.List;

public class SpacePolicePuzzleSolver extends PuzzleSolver {

  private DirectionService directionService = DirectionService.getIstance();

  public SpacePolicePuzzleSolver() {
    super(new Puzzle(11, 2019, "SpacePolice"));
  }

  @Override
  public String solvePart1(List<String> inputList) {

    PaintingRobotRunner paintingRobotRunner = PaintingRobotRunner.getInstance();
    long[] instructions = convertStringListInIntegersArray(inputList);
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(instructions);
    PaintingRobot paintingRobot = new PaintingRobot(Color.BLACK);
    return paintingRobotRunner.run(vonNeumannMachine, paintingRobot) + "";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    PaintingRobotRunner paintingRobotRunner = PaintingRobotRunner.getInstance();
    long[] instructions = convertStringListInIntegersArray(inputList);
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(instructions);
    PaintingRobot paintingRobot = new PaintingRobot(Color.WHITE);
    paintingRobotRunner.run(vonNeumannMachine, paintingRobot);
    return "\n" + paintingRobotRunner.draw(paintingRobot);
  }
}
