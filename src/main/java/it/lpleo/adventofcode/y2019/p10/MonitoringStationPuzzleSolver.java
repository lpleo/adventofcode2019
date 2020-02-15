package it.lpleo.adventofcode.y2019.p10;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.y2019.p10.domain.Asteroid;
import it.lpleo.adventofcode.y2019.p10.domain.Base;
import it.lpleo.adventofcode.y2019.p10.domain.LineOfSight;
import it.lpleo.adventofcode.y2019.p10.service.AsteroidEliminationService;
import it.lpleo.adventofcode.y2019.p10.service.AsteroidService;
import java.util.List;

public class MonitoringStationPuzzleSolver extends PuzzleSolver {

  private AsteroidService asteroidService = AsteroidService.getInstance();
  private AsteroidEliminationService asteroidEliminationService = AsteroidEliminationService
      .getInstance();

  public MonitoringStationPuzzleSolver() {
    super(new Puzzle(10, 2019, "MonitoringStation"));
  }

  @Override
  public String solvePart1(List<String> inputList) {
    List<Asteroid> asteroidList = asteroidService.createAsteroidList(inputList);
    Base base = findBase(asteroidList);
    return "(" + base.getAsteroidBase().getX() + "," + base.getAsteroidBase().getY() + ") - "
        + base.getNumberOfVisibleAsteroids();
  }

  @Override
  public String solvePart2(List<String> inputList) {
    List<Asteroid> asteroidList = asteroidService.createAsteroidList(inputList);
    Base base = findBase(asteroidList);
    List<Asteroid> result = asteroidEliminationService.eliminateAsteroids(base);
    return "200th asteroid: (" + result.get(200 - 1).getX() + "," + result.get(200 - 1).getY()
        + ") - result {" + (result.get(200 - 1).getX() * 100 + result.get(200 - 1).getY()) + "}";
  }

  private Base findBase(List<Asteroid> asteroids) {
    Base base = new Base();
    int maxVisibleAsteroids = 0;
    for (Asteroid candidateAsteroid : asteroids) {
      List<LineOfSight> lineOfSights = asteroidService
          .getLineOfSightsForAsteroids(candidateAsteroid, asteroids);
      int visibleAsteroids = 0;
      for (LineOfSight entry : lineOfSights) {
        visibleAsteroids += asteroidService.calculateAsteroidInSights(candidateAsteroid, entry);
      }
      if (visibleAsteroids > maxVisibleAsteroids) {
        maxVisibleAsteroids = visibleAsteroids;
        base = new Base(candidateAsteroid, lineOfSights, maxVisibleAsteroids);
      }
    }
    return base;
  }
}
