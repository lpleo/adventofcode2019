package it.lpleo.adventofcode.y2019.p5.service;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import org.hamcrest.Matchers;
import org.junit.Test;

public class InstructionDecoderServiceTest {

  @Test
  public void getFirstParameterMode() {
    assertThat(InstructionDecoderService.getFirstParameterMode(1002), Matchers.is(0));
  }

  @Test
  public void getSecondParameterMode() {
    assertThat(InstructionDecoderService.getSecondParameterMode(1002), Matchers.is(1));
  }

  @Test
  public void getThirdParameterMode() {
    assertThat(InstructionDecoderService.getThirdParameterMode(1002), Matchers.is(0));
  }
}
