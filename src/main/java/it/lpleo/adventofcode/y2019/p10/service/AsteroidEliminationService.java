package it.lpleo.adventofcode.y2019.p10.service;

import it.lpleo.adventofcode.service.PointService;
import it.lpleo.adventofcode.y2019.p10.domain.Asteroid;
import it.lpleo.adventofcode.y2019.p10.domain.Base;
import it.lpleo.adventofcode.y2019.p10.domain.LineOfSight;
import it.lpleo.adventofcode.y2019.p10.domain.LineOfSightComparator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AsteroidEliminationService {

  private static AsteroidEliminationService istance;
  private static PointService pointService;

  public static AsteroidEliminationService getInstance() {
    if (istance == null) {
      istance = new AsteroidEliminationService();
      pointService = PointService.getInstance();
    }
    return istance;
  }

  private AsteroidEliminationService() {
  }

  public List<Asteroid> eliminateAsteroids(Base base) {
    List<Asteroid> terminatedAsteroids = new ArrayList<>();
    List<LineOfSight> baseLineOfSights = orderByAngularCoefficents(base.getVisibleAsteroids());
    while (thereAreAsteroids(baseLineOfSights)) {
      for (LineOfSight lineOfSight : baseLineOfSights) {
        Asteroid terminated = terminateNearestPositiveXAsteroid(base.getAsteroidBase(),
            lineOfSight);
        if (terminated != null) {
          terminatedAsteroids.add(terminated);
        }
      }
      for (LineOfSight lineOfSight : baseLineOfSights) {
        Asteroid terminated = terminateNearestNegativeXAsteroid(base.getAsteroidBase(),
            lineOfSight);
        if (terminated != null) {
          terminatedAsteroids.add(terminated);
        }
      }
    }
    return terminatedAsteroids;
  }

  public boolean thereAreAsteroids(List<LineOfSight> lineOfSights) {
    for (LineOfSight lineOfSight : lineOfSights) {
      if (lineOfSight.getAsteroidsInSight().size() > 0) {
        return true;
      }
    }
    return false;
  }

  public Asteroid terminateNearestPositiveXAsteroid(
      Asteroid asteroidBase, LineOfSight lineOfSight) {
    Asteroid positiveXAsteroid = extractNearestPositiveXAsteroid(asteroidBase, lineOfSight);
    if (positiveXAsteroid != null) {
      lineOfSight.getAsteroidsInSight().remove(positiveXAsteroid);
      return positiveXAsteroid;
    }
    return null;
  }

  public Asteroid terminateNearestNegativeXAsteroid(
      Asteroid asteroidBase, LineOfSight lineOfSight) {
    Asteroid negativeXAsteroid = extractNearestNegativeXAsteroid(asteroidBase, lineOfSight);
    if (negativeXAsteroid != null) {
      lineOfSight.getAsteroidsInSight().remove(negativeXAsteroid);
      return negativeXAsteroid;
    }
    return null;
  }

  public List<LineOfSight> orderByAngularCoefficents(List<LineOfSight> linesOfSight) {
    return linesOfSight.stream().sorted(new LineOfSightComparator()).collect(Collectors.toList());
  }

  private Asteroid extractNearestPositiveXAsteroid(
      Asteroid asteroidBase, LineOfSight lineOfSight) {
    List<Asteroid> asteroids = lineOfSight.getAsteroidsInSight();
    Asteroid candidateAsteroid = null;
    double nearestDistance = Double.MAX_VALUE;
    for (Asteroid asteroid : asteroids) {
      double relativeX = asteroid.getX() - asteroidBase.getX();
      double relativeY = asteroid.getY() - asteroidBase.getY();
      double distance = pointService.calculateDistance(asteroid, asteroidBase);
      if (relativeX >= 0 && distance < nearestDistance) {
        if (relativeX == 0 && relativeY >= 0) {
          continue;
        }
        nearestDistance = distance;
        candidateAsteroid = asteroid;
      }
    }
    return candidateAsteroid;
  }

  private Asteroid extractNearestNegativeXAsteroid(
      Asteroid asteroidBase, LineOfSight lineOfSight) {
    List<Asteroid> asteroids = lineOfSight.getAsteroidsInSight();
    Asteroid candidateAsteroid = null;
    double nearestDistance = Double.MAX_VALUE;
    for (Asteroid asteroid : asteroids) {
      double relativeX = asteroid.getX() - asteroidBase.getX();
      double relativeY = asteroid.getY() - asteroidBase.getY();
      double distance = pointService.calculateDistance(asteroid, asteroidBase);
      if (relativeX <= 0 && distance < nearestDistance) {
        if (relativeX == 0 && relativeY <= 0) {
          continue;
        }
        nearestDistance = distance;
        candidateAsteroid = asteroid;
      }
    }
    return candidateAsteroid;
  }
}
