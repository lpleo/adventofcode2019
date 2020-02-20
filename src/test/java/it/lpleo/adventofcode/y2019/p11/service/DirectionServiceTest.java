package it.lpleo.adventofcode.y2019.p11.service;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.y2019.p11.domain.Direction;
import org.hamcrest.Matchers;
import org.junit.Test;

public class DirectionServiceTest {

  private DirectionService directionService = DirectionService.getIstance();

  @Test
  public void turnRight() {
    assertThat(directionService.turnRight(Direction.UP), Matchers.is(Direction.RIGHT));
    assertThat(directionService.turnRight(Direction.LEFT), Matchers.is(Direction.UP));
    assertThat(directionService.turnRight(Direction.RIGHT), Matchers.is(Direction.DOWN));
    assertThat(directionService.turnRight(Direction.DOWN), Matchers.is(Direction.LEFT));
  }

  @Test
  public void turnLeft() {
    assertThat(directionService.turnLeft(Direction.UP), Matchers.is(Direction.LEFT));
    assertThat(directionService.turnLeft(Direction.LEFT), Matchers.is(Direction.DOWN));
    assertThat(directionService.turnLeft(Direction.RIGHT), Matchers.is(Direction.UP));
    assertThat(directionService.turnLeft(Direction.DOWN), Matchers.is(Direction.RIGHT));
  }
}
