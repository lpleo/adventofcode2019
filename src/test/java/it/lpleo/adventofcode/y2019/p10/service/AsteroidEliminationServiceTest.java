package it.lpleo.adventofcode.y2019.p10.service;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.domain.Straight;
import it.lpleo.adventofcode.domain.StraightType;
import it.lpleo.adventofcode.y2019.p10.domain.Asteroid;
import it.lpleo.adventofcode.y2019.p10.domain.Base;
import it.lpleo.adventofcode.y2019.p10.domain.LineOfSight;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AsteroidEliminationServiceTest {

  private AsteroidService asteroidService = AsteroidService.getInstance();
  private AsteroidEliminationService asteroidEliminationService = AsteroidEliminationService
      .getInstance();

  @Test
  public void eliminateAsteroids_1() {
    Asteroid baseAsteroid = new Asteroid(8.0, 3.0);
    List<Asteroid> asteroidList = asteroidService.createAsteroidList(createInput_1());
    List<LineOfSight> lineOfSights = asteroidService
        .getLineOfSightsForAsteroids(baseAsteroid, asteroidList);
    Base base = new Base(baseAsteroid, lineOfSights, 0);

    List<Asteroid> eliminatedAsteroid = asteroidEliminationService.eliminateAsteroids(base);

    assertSameAsteroids(eliminatedAsteroid.get(0), new Asteroid(8, 1));
    assertSameAsteroids(eliminatedAsteroid.get(1), new Asteroid(9, 0));
    assertSameAsteroids(eliminatedAsteroid.get(2), new Asteroid(9, 1));
    assertSameAsteroids(eliminatedAsteroid.get(3), new Asteroid(10, 0));
    assertSameAsteroids(eliminatedAsteroid.get(4), new Asteroid(9, 2));
    assertSameAsteroids(eliminatedAsteroid.get(5), new Asteroid(11, 1));
    assertSameAsteroids(eliminatedAsteroid.get(6), new Asteroid(12, 1));
    assertSameAsteroids(eliminatedAsteroid.get(7), new Asteroid(11, 2));
    assertSameAsteroids(eliminatedAsteroid.get(8), new Asteroid(15, 1));

    assertSameAsteroids(eliminatedAsteroid.get(9), new Asteroid(12, 2));
    assertSameAsteroids(eliminatedAsteroid.get(10), new Asteroid(13, 2));
    assertSameAsteroids(eliminatedAsteroid.get(11), new Asteroid(14, 2));
    assertSameAsteroids(eliminatedAsteroid.get(12), new Asteroid(15, 2));
    assertSameAsteroids(eliminatedAsteroid.get(13), new Asteroid(12, 3));
    assertSameAsteroids(eliminatedAsteroid.get(14), new Asteroid(16, 4));
    assertSameAsteroids(eliminatedAsteroid.get(15), new Asteroid(15, 4));
    assertSameAsteroids(eliminatedAsteroid.get(16), new Asteroid(10, 4));
    assertSameAsteroids(eliminatedAsteroid.get(17), new Asteroid(4, 4));

    assertSameAsteroids(eliminatedAsteroid.get(18), new Asteroid(2, 4));
    assertSameAsteroids(eliminatedAsteroid.get(19), new Asteroid(2, 3));
    assertSameAsteroids(eliminatedAsteroid.get(20), new Asteroid(0, 2));
    assertSameAsteroids(eliminatedAsteroid.get(21), new Asteroid(1, 2));
    assertSameAsteroids(eliminatedAsteroid.get(22), new Asteroid(0, 1));
    assertSameAsteroids(eliminatedAsteroid.get(23), new Asteroid(1, 1));
    assertSameAsteroids(eliminatedAsteroid.get(24), new Asteroid(5, 2));
    assertSameAsteroids(eliminatedAsteroid.get(25), new Asteroid(1, 0));
    assertSameAsteroids(eliminatedAsteroid.get(26), new Asteroid(5, 1));

    assertSameAsteroids(eliminatedAsteroid.get(27), new Asteroid(6, 1));
    assertSameAsteroids(eliminatedAsteroid.get(28), new Asteroid(6, 0));
    assertSameAsteroids(eliminatedAsteroid.get(29), new Asteroid(7, 0));
    assertSameAsteroids(eliminatedAsteroid.get(30), new Asteroid(8, 0));
    assertSameAsteroids(eliminatedAsteroid.get(31), new Asteroid(10, 1));
    assertSameAsteroids(eliminatedAsteroid.get(32), new Asteroid(14, 0));
    assertSameAsteroids(eliminatedAsteroid.get(33), new Asteroid(16, 1));
    assertSameAsteroids(eliminatedAsteroid.get(34), new Asteroid(13, 3));
    assertSameAsteroids(eliminatedAsteroid.get(35), new Asteroid(14, 3));
  }

  @Test
  public void eliminateAsteroids_2() {
    String inputString = createInput_2();
    List<String> input = asList(inputString.split("\n"));
    Asteroid baseAsteroid = new Asteroid(11, 13);
    List<Asteroid> asteroidList = asteroidService.createAsteroidList(input);
    List<LineOfSight> lineOfSights = asteroidService
        .getLineOfSightsForAsteroids(baseAsteroid, asteroidList);
    Base base = new Base(baseAsteroid, lineOfSights, 0);

    List<Asteroid> eliminatedAsteroid = asteroidEliminationService.eliminateAsteroids(base);

    assertSameAsteroids(eliminatedAsteroid.get(1 - 1), new Asteroid(11, 12));
    assertSameAsteroids(eliminatedAsteroid.get(2 - 1), new Asteroid(12, 1));
    assertSameAsteroids(eliminatedAsteroid.get(3 - 1), new Asteroid(12, 2));
    assertSameAsteroids(eliminatedAsteroid.get(10 - 1), new Asteroid(12, 8));
    assertSameAsteroids(eliminatedAsteroid.get(20 - 1), new Asteroid(16, 0));
    assertSameAsteroids(eliminatedAsteroid.get(50 - 1), new Asteroid(16, 9));
    printDebug(eliminatedAsteroid, baseAsteroid, 20, 20);
    assertSameAsteroids(eliminatedAsteroid.get(100 - 1), new Asteroid(10, 16));
    assertSameAsteroids(eliminatedAsteroid.get(199 - 1), new Asteroid(9, 6));
    assertSameAsteroids(eliminatedAsteroid.get(200 - 1), new Asteroid(8, 2));
    assertSameAsteroids(eliminatedAsteroid.get(201 - 1), new Asteroid(10, 9));
    assertSameAsteroids(eliminatedAsteroid.get(299 - 1), new Asteroid(11, 1));
  }


  @Test
  public void orderByAngularCoefficents() {
    List<LineOfSight> linesOfSight = new ArrayList<>();
    linesOfSight.add(new LineOfSight(new Straight(StraightType.NORMAL, -2.0, 0.0)));
    linesOfSight.add(new LineOfSight(new Straight(StraightType.PARALLELY, 0.0, 0.0)));
    linesOfSight.add(new LineOfSight(new Straight(StraightType.PARALLELX, 0.0, 0.0)));
    linesOfSight.add(new LineOfSight(new Straight(StraightType.NORMAL, -0.5, 0.0)));
    linesOfSight.add(new LineOfSight(new Straight(StraightType.NORMAL, 0.5, 0.0)));
    linesOfSight.add(new LineOfSight(new Straight(StraightType.NORMAL, 2.0, 0.0)));

    List<LineOfSight> result = asteroidEliminationService.orderByAngularCoefficents(linesOfSight);
    assertThat(result.get(0).getStraight().getStraightType(), is(StraightType.PARALLELY));
    assertThat(result.get(1).getStraight().getM(), is(-2.0));
    assertThat(result.get(2).getStraight().getM(), is(-0.5));
    assertThat(result.get(3).getStraight().getStraightType(), is(StraightType.PARALLELX));
    assertThat(result.get(4).getStraight().getM(), is(0.5));
    assertThat(result.get(5).getStraight().getM(), is(2.0));

  }

  private void assertSameAsteroids(Asteroid a, Asteroid b) {
    assertThat(a.getX(), is(b.getX()));
    assertThat(a.getY(), is(b.getY()));
  }

  private List<String> createInput_1() {
    List<String> result = new ArrayList<>();
    result.add(".#....#####...#..");
    result.add("##...##.#####..##");
    result.add("##...#...#.#####.");
    result.add("..#.....#...###..");
    result.add("..#.#.....#....##");
    return result;
  }

  private String createInput_2() {
    return ".#..##.###...#######\n"
        + "##.############..##.\n"
        + ".#.######.########.#\n"
        + ".###.#######.####.#.\n"
        + "#####.##.#.##.###.##\n"
        + "..#####..#.#########\n"
        + "####################\n"
        + "#.####....###.#.#.##\n"
        + "##.#################\n"
        + "#####.##.###..####..\n"
        + "..######..##.#######\n"
        + "####.##.####...##..#\n"
        + ".#####..#.######.###\n"
        + "##...#.##########...\n"
        + "#.##########.#######\n"
        + ".####.#.###.###.#.##\n"
        + "....##.##.###..#####\n"
        + ".#.#.###########.###\n"
        + "#.#.#.#####.####.###\n"
        + "###.##.####.##.#..##";
  }

  private void printDebug(List<Asteroid> asteroids, Asteroid base, int xsize, int ysize) {
    for (int y = 0; y < ysize; y++) {
      for (int x = 0; x < xsize; x++) {
        String daStampare = ".";
        for (int i = 0; i < asteroids.size(); i++) {
          if (asteroids.get(i).getX() == x && asteroids.get(i).getY() == y) {
            daStampare = (i + 1) + "";
          }
        }
        if (base.getX() == x && base.getY() == y) {
          daStampare = "BAS";
        }
        stampa(daStampare);
      }
      System.out.println("");
    }
  }

  private void stampa(String string) {
    if (string.length() < 3) {
      while (string.length() != 3) {
        string += " ";
      }
    }
    System.out.print(string + "|");
  }
}
