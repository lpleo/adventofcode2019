package it.lpleo.adventofcode.y2019.p12.service;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;

import com.sun.deploy.util.StringUtils;
import it.lpleo.adventofcode.domain.geometry.I3DPoint;
import it.lpleo.adventofcode.domain.geometry.ThreeDimensionalPoint;
import it.lpleo.adventofcode.y2019.p12.domain.Moon;
import it.lpleo.adventofcode.y2019.p12.domain.Moon.MoonBuilder;
import java.util.ArrayList;
import java.util.List;

public class MoonService {

  private static MoonService istance;

  public static MoonService getIstance() {
    if (istance == null) {
      istance = new MoonService();
    }
    return istance;
  }

  public void updateVelocity(Moon moonA, Moon moonB) {

    I3DPoint positionA = moonA.getPosition();
    I3DPoint positionB = moonB.getPosition();
    I3DPoint velocityA = moonA.getVelocity();
    I3DPoint velocityB = moonB.getVelocity();

    for (int pos = 0; pos < positionA.getCoordinates().length; pos++) {
      double coordinateA = positionA.getCoordinates()[pos];
      double coordinateB = positionB.getCoordinates()[pos];
      velocityA.getCoordinates()[pos] -= doubleComparator(coordinateA, coordinateB);
      velocityB.getCoordinates()[pos] += doubleComparator(coordinateA, coordinateB);
    }

  }

  public void updatePosition(Moon moon) {
    double[] posCoordinates = moon.getPosition().getCoordinates();
    double[] velCoordinates = moon.getVelocity().getCoordinates();

    for (int pos = 0; pos < posCoordinates.length; pos++) {
      posCoordinates[pos] = posCoordinates[pos] + velCoordinates[pos];
    }
  }

  public double calcolateEnergy(Moon moon) {
    return calculateKineticEnergy(moon) * calculatePotentialEnergy(moon);
  }

  public List<Moon> createMoons(List<String> inputList) {
    List<Moon> moons = new ArrayList<>();
    for (int i = 0; i < inputList.size(); i++) {
      String[] split = inputList.get(i).split(",");
      ThreeDimensionalPoint position = new ThreeDimensionalPoint(parseDouble(split[0]),
          parseDouble(split[1]), parseDouble(split[2]));
      MoonBuilder moonBuilder = Moon.builder().key(i + "")
          .velocity(new ThreeDimensionalPoint(new double[3]));
      moons.add(moonBuilder.position(position).build());
    }
    return moons;
  }

  public List<String> extractKeys(List<Moon> moons) {
    List<String> keys = new ArrayList<>();
    for (Moon moon : moons) {
      keys.add(moon.getKey());
    }
    return keys;
  }

  public Moon findByKey(String key, List<Moon> moons) {
    return moons.stream().filter(moon -> moon.getKey().equals(key)).findFirst()
        .orElseThrow(RuntimeException::new);
  }

  private double doubleComparator(double d1, double d2) {
    int result = Double.compare(d1, d2);
    if (result == 0) {
      return 0.0;
    }

    return result > 0 ? 1.0 : -1.0;
  }

  private double calculateKineticEnergy(Moon moon) {
    double[] coordinates = moon.getVelocity().getCoordinates();
    double result = 0;
    for (double coordinate : coordinates) {
      result += abs(coordinate);
    }
    return result;
  }

  private double calculatePotentialEnergy(Moon moon) {
    double[] coordinates = moon.getPosition().getCoordinates();
    double result = 0;
    for (double coordinate : coordinates) {
      result += abs(coordinate);
    }
    return result;
  }
}
