package it.lpleo.adventofcode.y2019.p10.service;

import it.lpleo.adventofcode.domain.Straight;
import it.lpleo.adventofcode.domain.StraightType;
import it.lpleo.adventofcode.service.StraightService;
import it.lpleo.adventofcode.y2019.p10.domain.Asteroid;
import it.lpleo.adventofcode.y2019.p10.domain.LineOfSight;
import java.util.ArrayList;
import java.util.List;

public class AsteroidService {

  private static AsteroidService asteroidService;
  private static StraightService straightService;

  public static AsteroidService getInstance() {
    if (asteroidService == null) {
      asteroidService = new AsteroidService();
      straightService = StraightService.getInstance();
    }
    return asteroidService;
  }

  private AsteroidService() {
  }

  public List<Asteroid> createAsteroidList(List<String> lines) {
    List<Asteroid> asteroids = new ArrayList<>();
    for (double y = 0; y < lines.size(); y++) {
      char[] lineChars = lines.get((int) y).toCharArray();
      for (double x = 0; x < lineChars.length; x++) {
        if (lineChars[(int) x] == '#') {
          asteroids.add(new Asteroid(x, y));
        }
      }
    }
    return asteroids;
  }

  public List<LineOfSight> getLineOfSightsForAsteroids(Asteroid candidateAsteroid,
      List<Asteroid> asteroidList) {

    List<LineOfSight> linesOfSight = new ArrayList<>();
    for (Asteroid otherAsteroid : asteroidList) {
      if (!candidateAsteroid.equals(otherAsteroid)) {
        Straight straight = straightService.getStraight(candidateAsteroid, otherAsteroid);
        LineOfSight lineOfSight = extractLineOfSight(linesOfSight, straight);
        if (lineOfSight == null) {
          lineOfSight = new LineOfSight(straight);
          linesOfSight.add(lineOfSight);
        }
        lineOfSight.getAsteroidsInSight().add(otherAsteroid);
      }
    }

    return linesOfSight;
  }

  public int calculateAsteroidInSights(Asteroid candidateAsteroid, LineOfSight entry) {
    int asteroidInSights = 0;
    List<Asteroid> asteroids = entry.getAsteroidsInSight();
    if (entry.getStraight().getStraightType() == StraightType.PARALLELY) {
      asteroidInSights +=
          asteroids.stream().anyMatch(asteroid -> asteroid.getY() < candidateAsteroid.getY()) ? 1
              : 0;
      asteroidInSights +=
          asteroids.stream().anyMatch(asteroid -> asteroid.getY() > candidateAsteroid.getY()) ? 1
              : 0;
      return asteroidInSights;
    }

    asteroidInSights +=
        asteroids.stream().anyMatch(asteroid -> asteroid.getX() < candidateAsteroid.getX()) ? 1 : 0;
    asteroidInSights +=
        asteroids.stream().anyMatch(asteroid -> asteroid.getX() > candidateAsteroid.getX()) ? 1 : 0;
    return asteroidInSights;
  }

  private LineOfSight extractLineOfSight(List<LineOfSight> linesOfSight, Straight straight) {
    for (LineOfSight lineOfSight : linesOfSight) {
      if (lineOfSight.getStraight().equals(straight)) {
        return lineOfSight;
      }
    }
    return null;
  }
}
