package it.lpleo.adventofcode.y2019.p13.service;

import static java.util.Comparator.comparingDouble;

import it.lpleo.adventofcode.service.MatrixService;
import it.lpleo.adventofcode.y2019.p13.domain.GameBlock;
import java.util.Arrays;
import java.util.List;

public class GameBlockService {

  public static Character[][] generateGameField(List<GameBlock> gameBlockList) {
    int xMax = (int) gameBlockList.stream().max(comparingDouble(GameBlock::getX))
        .orElseThrow(RuntimeException::new).getX();
    int yMax = (int) gameBlockList.stream().max(comparingDouble(GameBlock::getY))
        .orElseThrow(RuntimeException::new).getY();

    xMax += 1;
    yMax += 1;
    Character[][] gamefield = new Character[yMax][xMax];
    MatrixService.initializeMatrix(gamefield, ' ');

    gameBlockList.forEach(
        gameBlock -> gamefield[(int) gameBlock.getY()][(int) gameBlock.getX()] = mapLetter(
            gameBlock.getTitleId()));
    return gamefield;
  }

  public static int countBlocks(Character[][] gameField) {
    int counter = 0;
    for (Character[] line : gameField) {
      counter += Arrays.stream(line).filter(gameItem -> gameItem == 'B').count();
    }
    return counter;
  }

  private static char mapLetter(double titleId) {
    if (titleId == 1.0) {
      return 'I';
    }
    if (titleId == 2.0) {
      return 'B';
    }
    if (titleId == 3.0) {
      return '_';
    }
    if (titleId == 4.0) {
      return '0';
    }
    return ' ';
  }
}
