package it.lpleo.adventofcode.y2019.p5.service;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import org.hamcrest.Matchers;
import org.junit.Test;

public class VonNeumannMachineServiceTest {

  @Test
  public void extractReferencedParameter() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{208, 6, 0, 1, 99, 9, 10});
    long parameter = VonNeumannMachineService.extractParameter(vonNeumannMachine, 0);
    assertThat(parameter, Matchers.is(10L));
  }

  @Test
  public void extractImmediateParameter() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1108, 13, 5, 1, 99, 9, 10});
    long parameter = VonNeumannMachineService.extractParameter(vonNeumannMachine, 1);
    assertThat(parameter, Matchers.is(5L));
  }

  @Test
  public void extractRelativeParameter() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{2008, 4, 0, 1, 99, 9, 10});
    vonNeumannMachine.addAtRelativeCursor(5);
    long parameter = VonNeumannMachineService.extractParameter(vonNeumannMachine, 1);
    assertThat(parameter, Matchers.is(9L));
  }
}
