package it.lpleo.adventofcode.y2019.p13;

import static it.lpleo.adventofcode.service.InputManipulatorService.convertStringListInIntegersArray;
import static it.lpleo.adventofcode.y2019.p13.service.GameBlockService.countBlocks;
import static it.lpleo.adventofcode.y2019.p13.service.GameBlockService.generateGameField;
import static it.lpleo.adventofcode.y2019.p13.service.GameBlockService.updateGameField;

import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;
import it.lpleo.adventofcode.service.MatrixService;
import it.lpleo.adventofcode.service.vonneumannmachine.HandlerList;
import it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineRunner;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.MoveHandler;
import it.lpleo.adventofcode.y2019.p13.domain.GameBlock;
import it.lpleo.adventofcode.y2019.p13.domain.GameBlockTitleId;
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
          .titleId(GameBlockTitleId.byTitleId(titleId.getResult())).build());
    }
    Character[][] gameField = generateGameField(gameBlockList);
    return countBlocks(gameField) + "";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    long[] instructions = convertStringListInIntegersArray(inputList);
    instructions[0] = 2L;

    List<MoveHandler> handlers = HandlerList.getIstance().getHandlers();
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(instructions);

    double actualPoints = 0.0;
    List<GameBlock> gameBlockList = generateField(handlers, vonNeumannMachine);
    MoveInputGenerator moveInputGenerator = new MoveInputGenerator(
        generateGameField(gameBlockList));

    while (vonNeumannMachine.hasNotFinished()) {
      VonNeumannMachineOutput xPosition = VonNeumannMachineRunner
          .runAndStopOnOutput(vonNeumannMachine, handlers, moveInputGenerator);
      VonNeumannMachineOutput yPosition = VonNeumannMachineRunner
          .runAndStopOnOutput(vonNeumannMachine, handlers, moveInputGenerator);
      VonNeumannMachineOutput result = VonNeumannMachineRunner
          .runAndStopOnOutput(vonNeumannMachine, handlers, moveInputGenerator);

      boolean showPoint = xPosition.getResult() == -1.0 && yPosition.getResult() == 0.0;
      if (!showPoint) {
        GameBlock gameBlock = GameBlock.builder().x(xPosition.getResult()).y(yPosition.getResult())
            .titleId(GameBlockTitleId.byTitleId(result.getResult())).build();
        updateGameField(gameBlock, gameBlockList);
        moveInputGenerator = new MoveInputGenerator(generateGameField(gameBlockList));
        //!! for fun => printGame(gameBlockList)
      } else {
        actualPoints = result.getResult();
      }
    }
    return actualPoints + "";
  }

  private List<GameBlock> generateField(List<MoveHandler> handlers,
      VonNeumannMachine vonNeumannMachine) {
    List<GameBlock> gameBlockList = new ArrayList<>();
    boolean showPoint = false;
    while (!showPoint) {
      VonNeumannMachineOutput xPosition = VonNeumannMachineRunner
          .runAndStopOnOutput(vonNeumannMachine, handlers);
      VonNeumannMachineOutput yPosition = VonNeumannMachineRunner
          .runAndStopOnOutput(vonNeumannMachine, handlers);
      VonNeumannMachineOutput titleId = VonNeumannMachineRunner
          .runAndStopOnOutput(vonNeumannMachine, handlers);
      showPoint = xPosition.getResult() == -1.0 && yPosition.getResult() == 0.0;
      if (!showPoint) {
        gameBlockList.add(GameBlock.builder().x(xPosition.getResult()).y(yPosition.getResult())
            .titleId(GameBlockTitleId.byTitleId(titleId.getResult())).build());
      }
    }
    return gameBlockList;
  }

  private void printGame(List<GameBlock> gameBlockList) {
    System.out
        .println(MatrixService.printMatrix(GameBlockService.generateGameField(gameBlockList)));
    try {
      Thread.sleep(400);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
