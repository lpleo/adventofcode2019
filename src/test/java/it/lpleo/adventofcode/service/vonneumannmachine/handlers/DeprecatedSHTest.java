package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.service.vonneumannmachine.handlers.SumHandler;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import org.hamcrest.Matchers;
import org.junit.Test;

public class DeprecatedSHTest {

  private SumHandler sumHandler = new SumHandler();

  @Test
  public void moveWithReferencedModeTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{2, 3, 6, 5, 99, 6, 5});
    sumHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(5), Matchers.is(10L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithImmediateMode() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new long[]{1102, 1, 1, 3, 99});
    sumHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(3), Matchers.is(2L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithRelativeMode() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{202, 0, 5, 3, 99, 12});
    vonNeumannMachine.addAtRelativeCursor(5);
    sumHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(3), Matchers.is(24L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }
}
