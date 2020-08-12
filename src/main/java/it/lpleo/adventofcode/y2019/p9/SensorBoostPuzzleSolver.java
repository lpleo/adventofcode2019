package it.lpleo.adventofcode.y2019.p9;

import static it.lpleo.adventofcode.service.InputManipulatorService.convertStringCollectionInString;
import static it.lpleo.adventofcode.service.InputManipulatorService.convertStringListInIntegersArray;

import it.lpleo.adventofcode.service.vonneumannmachine.HandlerList;
import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineRunner;
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
    VonNeumannMachineRunner.run(vonNeumannMachine, HandlerList.getIstance().getHandlers());
    return convertStringCollectionInString(vonNeumannMachine.getOutputValues(), ',');
  }
}
