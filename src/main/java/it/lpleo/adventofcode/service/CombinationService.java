package it.lpleo.adventofcode.service;

import java.util.ArrayList;
import java.util.List;

public class CombinationService {

  private static CombinationService combinationService;

  public static CombinationService getIstance() {
    if (combinationService == null) {
      combinationService = new CombinationService();
    }
    return combinationService;
  }

  public List<List<String>> getTwoByTwoCombination(List<String> ids) {
    List<List<String>> result = new ArrayList<>();
    for (int i = 0; i < ids.size(); i++) {
      for (int j = i + 1; j < ids.size(); j++) {
        List<String> combination = new ArrayList<>();
        combination.add(ids.get(i));
        combination.add(ids.get(j));
        result.add(combination);
      }
    }
    return result;
  }
}
