package it.lpleo.adventofcode.y2019.p12;

import it.lpleo.adventofcode.y2019.p12.domain.Moon;
import it.lpleo.adventofcode.y2019.p12.service.MoonService;
import java.util.List;

public class NBodyProblemHelper {

  private static NBodyProblemHelper nBodyProblemHelper;
  private static MoonService moonService;

  public static NBodyProblemHelper getIstance() {
    if (nBodyProblemHelper == null) {
      nBodyProblemHelper = new NBodyProblemHelper();
      moonService = MoonService.getIstance();
    }
    return nBodyProblemHelper;
  }

  public void updateMoonsPositions(List<Moon> moons) {
    for(Moon moon : moons) {
      moonService.updatePosition(moon);
    }
  }

  public void updateMoonVelocities(List<List<String>> combinations, List<Moon> moons) {
    for (List<String> candidatekeys : combinations) {
      Moon moonA = moonService.findByKey(candidatekeys.get(0), moons);
      Moon moonB = moonService.findByKey(candidatekeys.get(1), moons);
      moonService.updateVelocity(moonA, moonB);
    }
  }

  public double calculateMoonsEnergy(List<Moon> moons) {
    double energy = 0;
    for(Moon moon : moons) {
      energy += moonService.calcolateEnergy(moon);
    }
    return energy;
  }
}
