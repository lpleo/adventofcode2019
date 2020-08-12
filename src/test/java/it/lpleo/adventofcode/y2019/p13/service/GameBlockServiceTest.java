package it.lpleo.adventofcode.y2019.p13.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.y2019.p13.domain.GameBlock;
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

  private List<GameBlock> createGameBlockListExample1() {
    ArrayList<GameBlock> gameBlocks = new ArrayList<>();
    gameBlocks.add(GameBlock.builder().x(1).y(2).titleId(3).build());
    gameBlocks.add(GameBlock.builder().x(6).y(5).titleId(4).build());
    return gameBlocks;
  }

  private List<GameBlock> createGameBlockList() {
    ArrayList<GameBlock> gameBlocks = new ArrayList<>();
    gameBlocks.add(GameBlock.builder().x(0).y(0).titleId(1).build());
    gameBlocks.add(GameBlock.builder().x(3).y(3).titleId(1).build());
    gameBlocks.add(GameBlock.builder().x(5).y(2).titleId(1).build());
    return gameBlocks;
  }

  @Test
  public void countBlocks() {

  }
}