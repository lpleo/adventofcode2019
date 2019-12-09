package it.lpleo.adventofcode.y2019.p4.service;

public class DigitsNeverDecreaseCriteria implements Criteria {

  @Override
  public boolean checkCriteria(int number) {
    String numberAsString = number + "";
    while (numberAsString.length() > 1) {
      if (numberAsString.charAt(1) < numberAsString.charAt(0)) {
        return false;
      }
      numberAsString = numberAsString.substring(1);
    }
    return true;
  }
}
