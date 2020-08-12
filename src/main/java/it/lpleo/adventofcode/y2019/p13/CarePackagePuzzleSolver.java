package it.lpleo.adventofcode.y2019.p13;

import static it.lpleo.adventofcode.service.InputManipulatorService.convertStringListInIntegersArray;
import static it.lpleo.adventofcode.y2019.p13.service.GameBlockService.countBlocks;

import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.service.MatrixService;
import it.lpleo.adventofcode.service.vonneumannmachine.HandlerList;
import it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineRunner;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.MoveHandler;
import it.lpleo.adventofcode.y2019.p13.domain.GameBlock;
import it.lpleo.adventofcode.y2019.p13.service.GameBlockService;
import java.util.ArrayList;
import java.util.List;

public class CarePackagePuzzleSolver extends PuzzleSolver {

  public CarePackagePuzzleSolver() {
    super(new Puzzle(13, 2019, "CarePackage"));
  }

  @Override
  public String solvePart1(List<String> inputList) {
    long[] instructions = convertStringListInIntegersArray(inputList);
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(instructions);
    List<MoveHandler> handlers = HandlerList.getIstance().getHandlers();
    List<GameBlock> gameBlockList = new ArrayList<>();
    while (vonNeumannMachine.hasNotFinished()) {
      VonNeumannMachineOutput xPosition = VonNeumannMachineRunner
          .runAndStopOnOutput(vonNeumannMachine, handlers);
      VonNeumannMachineOutput yPosition = VonNeumannMachineRunner
          .runAndStopOnOutput(vonNeumannMachine, handlers);
      VonNeumannMachineOutput titleId = VonNeumannMachineRunner
          .runAndStopOnOutput(vonNeumannMachine, handlers);
      gameBlockList.add(GameBlock.builder().x(xPosition.getResult()).y(yPosition.getResult())
          .titleId(titleId.getResult()).build());
    }
    Character[][] gameField = GameBlockService.generateGameField(gameBlockList);
    return countBlocks(gameField) + "";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    return null;
  }
}
