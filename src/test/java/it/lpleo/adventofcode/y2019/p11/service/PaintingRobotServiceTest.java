package it.lpleo.adventofcode.y2019.p11.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.y2019.p11.domain.Color;
import it.lpleo.adventofcode.y2019.p11.domain.Direction;
import it.lpleo.adventofcode.y2019.p11.domain.PaintingRobot;
import org.hamcrest.Matchers;
import org.junit.Test;

public class PaintingRobotServiceTest {

  private PaintingRobotService paintingRobotService = PaintingRobotService.getInstance();

  @Test
  public void moveTo_UP() {
    PaintingRobot paintingRobot = new PaintingRobot(Color.BLACK);
    paintingRobotService.moveTo(paintingRobot, Direction.UP);

    assertThat(paintingRobot.getPosition().getX(), is(0.0));
    assertThat(paintingRobot.getPosition().getY(), is(1.0));
    assertThat(paintingRobot.getPosition().getColor(), is(Color.BLACK));
    assertThat(paintingRobot.getDirection(), is(Direction.UP));
    assertThat(paintingRobot.getColoredPoints(), is(empty()));
  }

  @Test
  public void moveTo_DOWN() {
    PaintingRobot paintingRobot = new PaintingRobot(Color.BLACK);
    paintingRobotService.moveTo(paintingRobot, Direction.DOWN);

    assertThat(paintingRobot.getPosition().getX(), is(0.0));
    assertThat(paintingRobot.getPosition().getY(), is(-1.0));
    assertThat(paintingRobot.getPosition().getColor(), is(Color.BLACK));
    assertThat(paintingRobot.getDirection(), is(Direction.DOWN));
    assertThat(paintingRobot.getColoredPoints(), is(empty()));
  }

  @Test
  public void moveTo_RIGHT() {
    PaintingRobot paintingRobot = new PaintingRobot(Color.BLACK);
    paintingRobotService.moveTo(paintingRobot, Direction.RIGHT);

    assertThat(paintingRobot.getPosition().getX(), is(1.0));
    assertThat(paintingRobot.getPosition().getY(), is(0.0));
    assertThat(paintingRobot.getPosition().getColor(), is(Color.BLACK));
    assertThat(paintingRobot.getDirection(), is(Direction.RIGHT));
    assertThat(paintingRobot.getColoredPoints(), is(empty()));
  }

  @Test
  public void moveTo_LEFT() {
    PaintingRobot paintingRobot = new PaintingRobot(Color.BLACK);
    paintingRobotService.moveTo(paintingRobot, Direction.LEFT);

    assertThat(paintingRobot.getPosition().getX(), is(-1.0));
    assertThat(paintingRobot.getPosition().getY(), is(0.0));
    assertThat(paintingRobot.getPosition().getColor(), is(Color.BLACK));
    assertThat(paintingRobot.getDirection(), is(Direction.LEFT));
    assertThat(paintingRobot.getColoredPoints(), is(empty()));
  }

  @Test
  public void colorPoint() {
    PaintingRobot paintingRobot = new PaintingRobot(Color.BLACK);
    paintingRobotService.colorPoint(paintingRobot, Color.WHITE);

    assertThat(paintingRobot.getPosition().getX(), is(0.0));
    assertThat(paintingRobot.getPosition().getY(), is(0.0));
    assertThat(paintingRobot.getPosition().getColor(), is(Color.WHITE));
    assertThat(paintingRobot.getDirection(), is(Direction.UP));
    assertThat(paintingRobot.getColoredPoints().size(), is(1));
  }
}
