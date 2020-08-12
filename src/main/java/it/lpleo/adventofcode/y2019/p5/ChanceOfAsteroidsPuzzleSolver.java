package it.lpleo.adventofcode.y2019.p5;

import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.service.InputManipulatorService;
import it.lpleo.adventofcode.service.ListService;
import it.lpleo.adventofcode.service.vonneumannmachine.HandlerList;
import it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineRunner;
import java.util.List;

public class ChanceOfAsteroidsPuzzleSolver extends PuzzleSolver {

  public ChanceOfAsteroidsPuzzleSolver() {
    super(new Puzzle(5, 2019, "ChanceOfAsteroids"));
  }

  @Override
  public String solvePart1(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        InputManipulatorService.convertStringListInIntegersArray(inputList));
    HandlerList istance = HandlerList.getIstance();
    vonNeumannMachine.addInputValue(1L);
    List<VonNeumannMachineOutput> vonNeumannMachineOutputList = VonNeumannMachineRunner
        .run(vonNeumannMachine, istance.getHandlers());
    VonNeumannMachineOutput vonNeumannMachineOutput = ListService.getLast(
        vonNeumannMachineOutputList);
    return vonNeumannMachineOutput != null ? vonNeumannMachineOutput.getResult() + "" : "Error";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        InputManipulatorService.convertStringListInIntegersArray(inputList));
    HandlerList istance = HandlerList.getIstance();
    vonNeumannMachine.addInputValue(5L);
    VonNeumannMachineRunner.run(vonNeumannMachine, istance.getHandlers());
    Long lastOutput = vonNeumannMachine.getFirstOutputIfExist();
    return lastOutput != null ? lastOutput + "" : "Error";
  }
}


