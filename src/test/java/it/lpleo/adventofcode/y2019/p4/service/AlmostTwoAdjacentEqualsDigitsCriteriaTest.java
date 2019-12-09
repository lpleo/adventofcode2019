package it.lpleo.adventofcode.y2019.p4.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlmostTwoAdjacentEqualsDigitsCriteriaTest {

  private AlmostTwoAdjacentEqualsDigitsCriteria criteria = new AlmostTwoAdjacentEqualsDigitsCriteria();
  
  @Test
  public void checkCriteria() {
    assertTrue(criteria.checkCriteria(117914));
    assertTrue(criteria.checkCriteria(456499));
    assertTrue(criteria.checkCriteria(999999));

    assertFalse(criteria.checkCriteria(123456));
    assertFalse(criteria.checkCriteria(101010));
  }
}
