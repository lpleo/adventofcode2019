package it.lpleo.adventofcode.y2019.p12.service;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.domain.geometry.ThreeDimensionalPoint;
import it.lpleo.adventofcode.y2019.p12.domain.Moon;
import java.util.List;
import org.junit.Test;

public class MoonServiceTest {

  private MoonService moonService = MoonService.getIstance();

  @Test
  public void updateVelocity() {

    Moon ganymede = Moon.builder().position(createPoint(3, 0, 6)).velocity(createPoint(0, 0, 0))
        .build();
    Moon callisto = Moon.builder().position(createPoint(5, 0, 3)).velocity(createPoint(0, 0, 0))
        .build();

    moonService.updateVelocity(ganymede, callisto);

    assertThat(ganymede.getVelocity().getX(), is(1.0));
    assertThat(callisto.getVelocity().getX(), is(-1.0));

    assertThat(ganymede.getVelocity().getY(), is(0.0));
    assertThat(callisto.getVelocity().getY(), is(0.0));

    assertThat(ganymede.getVelocity().getZ(), is(-1.0));
    assertThat(callisto.getVelocity().getZ(), is(1.0));
  }

  @Test
  public void updatePosition() {
    Moon ganymede = Moon.builder().position(createPoint(3, 0, 6)).velocity(createPoint(0, -1, +1))
        .build();

    moonService.updatePosition(ganymede);
    assertThat(ganymede.getPosition().getX(), is(3.0));
    assertThat(ganymede.getPosition().getY(), is(-1.0));
    assertThat(ganymede.getPosition().getZ(), is(7.0));
  }

  @Test
  public void calcolateEnergy() {
    Moon moon = Moon.builder().position(createPoint(3, -3, 3)).velocity(createPoint(-2, -2, 2))
        .build();

    double energy = moonService.calcolateEnergy(moon);
    assertThat(energy, is((3.0 * 3.0) + (2.0 * 3.0)));
  }

  @Test
  public void createMoons() {
    List<String> inputList = asList("1,2,3", "4,5,6");
    List<Moon> result = moonService.createMoons(inputList);

    assertThat(result.get(0).getPosition().getX(), is(1.0));
    assertThat(result.get(0).getPosition().getY(), is(2.0));
    assertThat(result.get(0).getPosition().getZ(), is(3.0));

    assertThat(result.get(0).getVelocity().getX(), is(0.0));
    assertThat(result.get(0).getVelocity().getY(), is(0.0));
    assertThat(result.get(0).getVelocity().getZ(), is(0.0));

    assertThat(result.get(1).getPosition().getX(), is(4.0));
    assertThat(result.get(1).getPosition().getY(), is(5.0));
    assertThat(result.get(1).getPosition().getZ(), is(6.0));
  }

  @Test
  public void extractKeys() {
    Moon moonA = Moon.builder().key("A").build();
    Moon moonB = Moon.builder().key("B").build();

    List<String> keys = moonService.extractKeys(asList(moonA, moonB));

    assertThat(keys.get(0), is("A"));
    assertThat(keys.get(1), is("B"));
  }

  @Test
  public void findByKey() {
    Moon moonA = Moon.builder().key("A").build();
    Moon moonB = Moon.builder().key("B").build();
    Moon moonC = Moon.builder().key("C").build();

    Moon result = moonService.findByKey("B", asList(moonA, moonB, moonC));

    assertThat(result.getKey(), is("B"));
  }

  private ThreeDimensionalPoint createPoint(double x, double y, double z) {
    return new ThreeDimensionalPoint(x, y, z);
  }
}
