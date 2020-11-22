package it.lpleo.adventofcode.y2019.p13.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.domain.geometry.Point;
import it.lpleo.adventofcode.y2019.p13.domain.GameBlock;
import it.lpleo.adventofcode.y2019.p13.domain.GameBlockTitleId;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GameBlockServiceTest {

  @Test
  public void generateGameField() {
    Character[][] gameField = GameBlockService.generateGameField(createGameBlockList());
    assertThat(gameField[0][0], is('I'));
    assertThat(gameField[3][3], is('I'));
    assertThat(gameField[2][5], is('I'));
  }

  @Test
  public void generateGameFieldExample1() {
    Character[][] gameField = GameBlockService.generateGameField(createGameBlockListExample1());
    assertThat(gameField[2][1], is('_'));
    assertThat(gameField[5][6], is('0'));
  }

  @Test
  public void countBlocks() {
    Character[][] gameField = new Character[][]{{'0', 'B', '0'}, {'0', 'B', 'B'}};
    int numberOfBlocks = GameBlockService.countBlocks(gameField);
    assertThat(numberOfBlocks, is(3));
  }

  @Test
  public void findBall() {
    Character[][] gameField = new Character[][]{{'C', 'B', 'C'}, {'A', 'B', '0'}};
    Point ball = GameBlockService.findBall(gameField);
    assertThat(ball.getX(), is(2.0));
    assertThat(ball.getY(), is(1.0));
  }

  @Test
  public void findPaddle() {
    Character[][] gameField = new Character[][]{{'C', 'B', 'C'}, {'A', '_', '0'}};
    Point ball = GameBlockService.findPaddle(gameField);
    assertThat(ball.getX(), is(1.0));
    assertThat(ball.getY(), is(1.0));
  }

  @Test
  public void movePaddle() {
    Point ball = new Point(1, 0);
    Point pad = new Point(2, 1);
    Long moveDirection = GameBlockService.movePaddle(ball, pad);
    assertThat(moveDirection, is(-1L));
  }

  private List<GameBlock> createGameBlockListExample1() {
    ArrayList<GameBlock> gameBlocks = new ArrayList<>();
    gameBlocks.add(GameBlock.builder().x(1).y(2).titleId(GameBlockTitleId.byTitleId(3)).build());
    gameBlocks.add(GameBlock.builder().x(6).y(5).titleId(GameBlockTitleId.byTitleId(4)).build());
    return gameBlocks;
  }

  private List<GameBlock> createGameBlockList() {
    ArrayList<GameBlock> gameBlocks = new ArrayList<>();
    gameBlocks.add(GameBlock.builder().x(0).y(0).titleId(GameBlockTitleId.byTitleId(1)).build());
    gameBlocks.add(GameBlock.builder().x(3).y(3).titleId(GameBlockTitleId.byTitleId(1)).build());
    gameBlocks.add(GameBlock.builder().x(5).y(2).titleId(GameBlockTitleId.byTitleId(1)).build());
    return gameBlocks;
  }
}