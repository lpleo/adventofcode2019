package it.lpleo.adventofcode.y2019.p4.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsNeverDecreaseCriteriaTest {

  private DigitsNeverDecreaseCriteria digitsNeverDecrease = new DigitsNeverDecreaseCriteria();
  
  @Test
  public void checkCriteria() {
    assertTrue(digitsNeverDecrease.checkCriteria(111111));
    assertTrue(digitsNeverDecrease.checkCriteria(111119));
    assertTrue(digitsNeverDecrease.checkCriteria(123456));

    assertFalse(digitsNeverDecrease.checkCriteria(111110));
    assertFalse(digitsNeverDecrease.checkCriteria(100000));
    assertFalse(digitsNeverDecrease.checkCriteria(123476));
  }
}
