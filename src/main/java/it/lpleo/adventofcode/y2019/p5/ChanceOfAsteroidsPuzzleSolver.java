package it.lpleo.adventofcode.y2019.p5;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.string.InputManipulator;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachineRunner;
import it.lpleo.adventofcode.y2019.p5.domain.handler.EqualsHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfFalseHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfTrueHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.LessThanHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.SumHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.InputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.OutputHandler;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ChanceOfAsteroidsPuzzleSolver extends PuzzleSolver {

  private List<MoveHandler> pt1handlers;
  private List<MoveHandler> pt2handlers;

  public ChanceOfAsteroidsPuzzleSolver(Puzzle puzzle) {
    super(puzzle);
    pt1handlers = asList(
        new SumHandler(),
        new MultiplicationHandler(),
        new InputHandler(new LinkedList<>(singletonList(1))),
        new OutputHandler(),
        new ErrorHandler());
    pt2handlers = asList(new SumHandler(),
        new MultiplicationHandler(),
        new InputHandler(new LinkedList<>(singletonList(5))),
        new OutputHandler(), new EqualsHandler(), new JumpIfFalseHandler(), new JumpIfTrueHandler(),
        new LessThanHandler(), new ErrorHandler());
  }

  @Override
  public String solvePart1(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        InputManipulator.convertInIntegersArray(inputList));
    VonNeumannMachineRunner.run(vonNeumannMachine, pt1handlers);
    return "See over";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        InputManipulator.convertInIntegersArray(inputList));
    VonNeumannMachineRunner.run(vonNeumannMachine, pt2handlers);
    return "See over";
  }
}

  
