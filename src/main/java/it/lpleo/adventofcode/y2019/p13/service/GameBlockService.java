package it.lpleo.adventofcode.y2019.p13.service;

import static java.util.Comparator.comparingDouble;

import it.lpleo.adventofcode.domain.geometry.Point;
import it.lpleo.adventofcode.service.MatrixService;
import it.lpleo.adventofcode.y2019.p13.domain.GameBlock;
import it.lpleo.adventofcode.y2019.p13.domain.GameBlockTitleId;
import java.util.Arrays;
import java.util.List;

public class GameBlockService {

  public static final Character UNBREAKABLE_BLOCK = 'I';
  public static final Character BREAKABLE_BLOCK = 'B';
  public static final Character PAD_BLOCK = '_';
  public static final Character BALL_BLOCK = '0';

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

  public static Point findBall(Character[][] gameField) {
    return findCharacterInMatrix(gameField, BALL_BLOCK);
  }

  public static Point findPaddle(Character[][] gameBlockList) {
    return findCharacterInMatrix(gameBlockList, PAD_BLOCK);
  }

  public static Long movePaddle(Point ballCoordinates, Point horizontalPaddleCoordinates) {
    final long left = -1L;
    final long right = 1L;
    final long stay = 0L;

    if (ballCoordinates.getX() < horizontalPaddleCoordinates.getX()) {
      return left;
    }
    if (ballCoordinates.getX() > horizontalPaddleCoordinates.getX()) {
      return right;
    }
    return stay;
  }

  private static char mapLetter(GameBlockTitleId titleId) {
    if (titleId.getValue() == GameBlockTitleId.UNBREAKABLE.getValue()) {
      return UNBREAKABLE_BLOCK;
    }
    if (titleId.getValue() == 2.0) {
      return BREAKABLE_BLOCK;
    }
    if (titleId.getValue() == 3.0) {
      return PAD_BLOCK;
    }
    if (titleId.getValue() == 4.0) {
      return BALL_BLOCK;
    }
    return ' ';
  }

  private static Point findCharacterInMatrix(Character[][] matrix, Character character) {
    for (int x = 0; x < MatrixService.getLength(matrix); x++) {
      for (int y = 0; y < MatrixService.getHeight(matrix); y++) {
        if (matrix[y][x].charValue() == character.charValue()) {
          return Point.builder().x(x).y(y).build();
        }
      }
    }
    throw new RuntimeException("Can not find [" + character + "] in matrix");
  }
}
