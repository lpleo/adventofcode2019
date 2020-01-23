package it.lpleo.adventofcode.y2019.p5;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.service.InputManipulatorService;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.EqualsHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.InputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfFalseHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfTrueHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.LessThanHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.OutputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.SumHandler;
import it.lpleo.adventofcode.y2019.p7.StoppableVonNeumannMachineRunner;
import java.util.LinkedList;
import java.util.List;

public class ChanceOfAsteroidsPuzzleSolver extends PuzzleSolver {

  private List<MoveHandler> pt1handlers;
  private List<MoveHandler> pt2handlers;

  public ChanceOfAsteroidsPuzzleSolver() {
    super(new Puzzle(5, 2019, "ChanceOfAsteroids"));
    pt1handlers = asList(
        new SumHandler(),
        new MultiplicationHandler(),
        new InputHandler(new LinkedList<>(singletonList(1L))),
        new OutputHandler(),
        new ErrorHandler());
    pt2handlers = asList(new SumHandler(),
        new MultiplicationHandler(),
        new InputHandler(new LinkedList<>(singletonList(5L))),
        new OutputHandler(), new EqualsHandler(), new JumpIfFalseHandler(), new JumpIfTrueHandler(),
        new LessThanHandler(), new ErrorHandler());
  }

  @Override
  public String solvePart1(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        InputManipulatorService.convertStringListInIntegersArray(inputList));
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine, pt1handlers);
    return "See over";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        InputManipulatorService.convertStringListInIntegersArray(inputList));
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine, pt2handlers);
    return "See over";
  }
}

  
