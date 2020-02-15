package it.lpleo.adventofcode.y2019.p10.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.y2019.p10.domain.Asteroid;
import it.lpleo.adventofcode.y2019.p10.domain.LineOfSight;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AsteroidServiceTest {

  private AsteroidService asteroidService = AsteroidService.getInstance();

  @Test
  public void createAsteroidList() {
    List<Asteroid> result = asteroidService.createAsteroidList(createInput());
    assertThat(result.size(), is(10));
    assertThat(result.get(0).getX(), is(1.0));
    assertThat(result.get(0).getY(), is(0.0));
    assertThat(result.get(9).getX(), is(4.0));
    assertThat(result.get(9).getY(), is(4.0));
  }

  @Test
  public void getLinesOfSightForAsteroid() {
    Asteroid candidateAsteroid = new Asteroid(4L, 4L);
    List<Asteroid> asteroidList = asteroidService.createAsteroidList(createInput());
    List<LineOfSight> result = asteroidService
        .getLineOfSightsForAsteroids(candidateAsteroid, asteroidList);
    assertThat(result.size(), is(7));
  }

  private List<String> createInput() {
    List<String> result = new ArrayList<>();
    result.add(".#..#");
    result.add(".....");
    result.add("#####");
    result.add("....#");
    result.add("...##");
    return result;
  }

}
