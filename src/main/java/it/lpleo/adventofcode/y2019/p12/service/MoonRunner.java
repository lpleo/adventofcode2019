package it.lpleo.adventofcode.y2019.p12.service;

import it.lpleo.adventofcode.y2019.p12.domain.Moon;
import java.util.List;

public class MoonRunner {

  private static MoonRunner moonRunner;
  private static MoonService moonService;

  public static MoonRunner getIstance() {
    if (moonRunner == null) {
      moonRunner = new MoonRunner();
      moonService = MoonService.getIstance();
    }
    return moonRunner;
  }

  public void moveMoons(List<Moon> moonList) {
    for (int i = 1; i < moonList.size(); i++) {
      Moon moonA = moonList.get(i - 1);
      Moon moonB = moonList.get(i);
    }
  }
}
