package it.lpleo.adventofcode.y2019.p4.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class NoLargerGroupOfMatchingDigitsCriteriaTest {

  NoLargerGroupOfMatchingDigitsCriteria criteria = new NoLargerGroupOfMatchingDigitsCriteria();
  
  @Test
  public void checkCriteria() {
    assertTrue(criteria.checkCriteria(112233));
    assertTrue(criteria.checkCriteria(111122));
    assertTrue(criteria.checkCriteria(221111));
    assertTrue(criteria.checkCriteria(1325511));
    
    assertFalse(criteria.checkCriteria(123444));
    assertFalse(criteria.checkCriteria(688889));
  }
}
