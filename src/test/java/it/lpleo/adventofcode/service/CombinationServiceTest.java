package it.lpleo.adventofcode.service;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Test;

public class CombinationServiceTest {

  private CombinationService combinationService = CombinationService.getIstance();

  @Test
  public void getTwoByTwoCombination() {
    List<String> ids = asList("A", "B", "C", "D");
    List<List<String>> result = combinationService.getTwoByTwoCombination(ids);
    assertThat(result.size(), Matchers.is(6));

    assertThat(result.get(0).get(0), is("A"));
    assertThat(result.get(0).get(1), is("B"));

    assertThat(result.get(1).get(0), is("A"));
    assertThat(result.get(1).get(1), is("C"));

    assertThat(result.get(2).get(0), is("A"));
    assertThat(result.get(2).get(1), is("D"));

    assertThat(result.get(3).get(0), is("B"));
    assertThat(result.get(3).get(1), is("C"));

    assertThat(result.get(4).get(0), is("B"));
    assertThat(result.get(4).get(1), is("D"));

    assertThat(result.get(5).get(0), is("C"));
    assertThat(result.get(5).get(1), is("D"));
  }
}
