package it.lpleo.adventofcode.y2019.p13;

import it.lpleo.adventofcode.domain.geometry.Point;
import it.lpleo.adventofcode.service.vonneumannmachine.generator.InputGenerator;
import it.lpleo.adventofcode.y2019.p13.service.GameBlockService;

public class MoveInputGenerator implements InputGenerator {

  private final Character[][] gameField;

  public MoveInputGenerator(Character[][] gameField) {
    this.gameField = gameField;
  }

  @Override
  public long generate() {
    Point ballCoordinates = GameBlockService.findBall(gameField);
    Point horizontalPaddleCoordinates = GameBlockService.findPaddle(gameField);
    return GameBlockService.movePaddle(ballCoordinates, horizontalPaddleCoordinates);
  }
}
