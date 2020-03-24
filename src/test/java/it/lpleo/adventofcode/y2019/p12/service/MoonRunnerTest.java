package it.lpleo.adventofcode.y2019.p12.service;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.domain.geometry.ThreeDimensionalPoint;
import it.lpleo.adventofcode.y2019.p12.domain.Moon;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MoonRunnerTest {

  private MoonRunner moonRunner = MoonRunner.getIstance();

  @Test
  public void moveMoons() {

    List<Moon> moonList = createMoonList();
    for (int i = 0; i < 10; i++) {
      moonRunner.moveMoons(moonList);
    }

    assertThat(moonList.get(0).getPosition().getX(), is(2));
    assertThat(moonList.get(0).getPosition().getY(), is(1));
    assertThat(moonList.get(0).getPosition().getZ(), is(-3));

    assertThat(moonList.get(0).getVelocity().getX(), is(-3));
    assertThat(moonList.get(0).getVelocity().getY(), is(-2));
    assertThat(moonList.get(0).getVelocity().getZ(), is(1));

    assertThat(moonList.get(1).getPosition().getX(), is(1));
    assertThat(moonList.get(1).getPosition().getY(), is(-8));
    assertThat(moonList.get(1).getPosition().getZ(), is(0));

    assertThat(moonList.get(1).getVelocity().getX(), is(-1));
    assertThat(moonList.get(1).getVelocity().getY(), is(1));
    assertThat(moonList.get(1).getVelocity().getZ(), is(3));

    assertThat(moonList.get(2).getPosition().getX(), is(3));
    assertThat(moonList.get(2).getPosition().getY(), is(-6));
    assertThat(moonList.get(2).getPosition().getZ(), is(1));

    assertThat(moonList.get(2).getVelocity().getX(), is(3));
    assertThat(moonList.get(2).getVelocity().getY(), is(2));
    assertThat(moonList.get(2).getVelocity().getZ(), is(-3));

    assertThat(moonList.get(3).getPosition().getX(), is(2));
    assertThat(moonList.get(3).getPosition().getY(), is(0));
    assertThat(moonList.get(3).getPosition().getZ(), is(4));

    assertThat(moonList.get(3).getVelocity().getX(), is(1));
    assertThat(moonList.get(3).getVelocity().getY(), is(-1));
    assertThat(moonList.get(3).getVelocity().getZ(), is(-1));
  }

  private List<Moon> createMoonList() {
    return asList(Moon.builder().position(new ThreeDimensionalPoint(-1, 0, 2)).build(),
        Moon.builder().position(new ThreeDimensionalPoint(2, -10, -7)).build(),
        Moon.builder().position(new ThreeDimensionalPoint(4, -8, 8)).build(),
        Moon.builder().position(new ThreeDimensionalPoint(3, 5, -1)).build());
  }
}
