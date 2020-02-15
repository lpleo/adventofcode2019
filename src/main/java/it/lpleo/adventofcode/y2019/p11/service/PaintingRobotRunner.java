package it.lpleo.adventofcode.y2019.p11.domain;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.service.VonNeumannMachineService;
import it.lpleo.adventofcode.y2019.p7.StoppableVonNeumannMachineRunner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PaintingRobotRunner {

  private static PaintingRobotRunner paintingRobotRunner;
  private static StoppableVonNeumannMachineRunner stoppableVonNeumannMachineRunner;
  private static List<MoveHandler> handlers;

  public static PaintingRobotRunner getInstance(
      StoppableVonNeumannMachineRunner vonNeumannMachineRunner) {
    if (paintingRobotRunner == null) {
      paintingRobotRunner = new PaintingRobotRunner();
    }
    return paintingRobotRunner;
  }

  private PaintingRobotRunner() {
  }

  public void run(VonNeumannMachine vonNeumannMachine) {
    handlers.sort(Comparator.comparingLong(MoveHandler::getIndex));
    List<Double> values = new ArrayList<>();
    while (vonNeumannMachine.hasNotFinished()) {
      while (values.size() < 2) {
        HandlerOutput handlerOutput = StoppableVonNeumannMachineRunner
            .runStoppableMachine(vonNeumannMachine, handlers);
        if (handlerOutput.isWait()) {
          values.add(handlerOutput.getResult());
        }
      }

      Color color = Color.byValue(values.get(0));
      
    }
  }

}

