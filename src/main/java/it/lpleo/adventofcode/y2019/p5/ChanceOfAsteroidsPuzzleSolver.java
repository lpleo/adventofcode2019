package it.lpleo.adventofcode.y2019.p5;

import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.vonneumannmachine.HandlerOutput;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.service.InputManipulatorService;
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
    HandlerOutput handlerOutput = null;
    while(vonNeumannMachine.hasNotFinished()) {
      handlerOutput = VonNeumannMachineRunner
          .run(vonNeumannMachine, istance.getHandlers());
    }
    return handlerOutput != null ? handlerOutput.getResult() + "" : "Error";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        InputManipulatorService.convertStringListInIntegersArray(inputList));
    HandlerList istance = HandlerList.getIstance();
    vonNeumannMachine.addInputValue(5L);
    HandlerOutput handlerOutput = null;
    while(vonNeumannMachine.hasNotFinished()) {
      handlerOutput = VonNeumannMachineRunner
          .run(vonNeumannMachine, istance.getHandlers());
    }
    return handlerOutput != null ? handlerOutput.getResult() + "" : "Error";
  }
}


