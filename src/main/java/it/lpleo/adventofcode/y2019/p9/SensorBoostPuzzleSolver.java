package it.lpleo.adventofcode.y2019.p9;

import static it.lpleo.adventofcode.string.InputManipulator.convertStringCollectionInString;
import static it.lpleo.adventofcode.string.InputManipulator.convertStringListInIntegersArray;
import static java.util.Arrays.asList;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.handler.EqualsHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfFalseHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfTrueHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.LessThanHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.SumHandler;
import it.lpleo.adventofcode.y2019.p7.StoppableVonNeumannMachineRunner;
import it.lpleo.adventofcode.y2019.p7.domain.InputFromVonNeumannMachineHandler;
import it.lpleo.adventofcode.y2019.p7.domain.OutputFromVonNeumannMachineHandler;
import it.lpleo.adventofcode.y2019.p9.domain.handler.ChangeRelativeBaseHandler;
import java.util.LinkedList;
import java.util.List;

public class SensorBoostPuzzleSolver extends PuzzleSolver {

  private static List<MoveHandler> handlers = asList(new SumHandler(),
      new MultiplicationHandler(), new EqualsHandler(), new LessThanHandler(),
      new JumpIfFalseHandler(), new JumpIfTrueHandler(), new InputFromVonNeumannMachineHandler(),
      new OutputFromVonNeumannMachineHandler(), new ChangeRelativeBaseHandler(),
      new ErrorHandler());

  public SensorBoostPuzzleSolver(Puzzle puzzle) {
    super(puzzle);
  }

  @Override
  public String solvePart1(List<String> inputList) {
    LinkedList<Long> inputValues = new LinkedList<>();
    inputValues.add(1L);
    return solvePart(inputList, inputValues);
  }

  @Override
  public String solvePart2(List<String> inputList) {
    LinkedList<Long> inputValues = new LinkedList<>();
    inputValues.add(2L);
    return solvePart(inputList, inputValues);
  }

  private String solvePart(List<String> inputList, LinkedList<Long> inputValues) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        convertStringListInIntegersArray(inputList), inputValues, new LinkedList<>());
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine, handlers);
    return convertStringCollectionInString(vonNeumannMachine.getOutputValues(), ',');
  }
}
