package it.lpleo.adventofcode.y2019.p9;

import static it.lpleo.adventofcode.service.InputManipulatorService.convertStringCollectionInString;
import static it.lpleo.adventofcode.service.InputManipulatorService.convertStringListInIntegersArray;
import static java.util.Arrays.asList;

import it.lpleo.adventofcode.domain.HandlerList;
import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;
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

  public SensorBoostPuzzleSolver() {
    super(new Puzzle(9, 2019, "SensorBoostPuzzle"));
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
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine, HandlerList.getIstance().getHandlers());
    return convertStringCollectionInString(vonNeumannMachine.getOutputValues(), ',');
  }
}
