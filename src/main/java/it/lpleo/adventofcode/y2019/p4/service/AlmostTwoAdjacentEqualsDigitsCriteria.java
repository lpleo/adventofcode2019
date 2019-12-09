package it.lpleo.adventofcode.y2019.p4.service;

public class AlmostTwoAdjacentEqualsDigitsCriteria implements Criteria{

  @Override
  public boolean checkCriteria(int number) {
    String numberAsString = number + "";
    for (int i = 0; i < numberAsString.length() - 1; i++) {
      if (numberAsString.charAt(i) == numberAsString.charAt(i + 1)) {
        return true;
      }
    }
    return false;
  }
}
