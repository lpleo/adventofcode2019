package it.lpleo.adventofcode.y2019.p4.service;

public class SixDigitsCriteria implements Criteria{

  @Override
  public boolean checkCriteria(int number) {
    return ((number + "").length() == 6);
  }
}
