package it.lpleo.adventofcode.y2019.p4.service;

public class NoLargerGroupOfMatchingDigitsCriteria implements Criteria {

  @Override
  public boolean checkCriteria(int number) {
    return existDuplets(number);
  }

  private boolean existDuplets(int number) {
    String numberAsString = number + "";
    for (int i = 0; i < numberAsString.length() - 1; i++) {
      boolean nextTwoDigitAreEquals = numberAsString.charAt(i) == numberAsString.charAt(i + 1);
      boolean nextThreeDigitsAreDifferent = (i + 2 == numberAsString.length()) ||
          (numberAsString.charAt(i + 1) != numberAsString.charAt(i + 2));

      if (nextTwoDigitAreEquals && nextThreeDigitsAreDifferent) {
        return true;
      }
      
      i = skipGroupOfEqualsLetters(i, numberAsString);

    }
    return false;
  }

  private int skipGroupOfEqualsLetters(int i, String numberAsString) {
    while (i < numberAsString.length() - 1 && numberAsString.charAt(i) == numberAsString
        .charAt(i + 1)) {
      i++;
    }
    return i;
  }

}
