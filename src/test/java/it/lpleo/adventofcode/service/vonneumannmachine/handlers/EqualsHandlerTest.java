package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.service.vonneumannmachine.handlers.EqualsHandler;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import org.hamcrest.Matchers;
import org.junit.Test;

public class EqualsHandlerTest {

  private EqualsHandler equalsHandler = new EqualsHandler();

  @Test
  public void moveWithReferencedModeTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{8L, 3L, 6L, 5L, 99L, 6L, 5L});
    equalsHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(5), Matchers.is(1L));
    assertThat(vonNeumannMachine.getActualValue(),Matchers.is(99L));
  }

  @Test
  public void moveWithImmediateMode() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new long[]{1108L, 1L, 1L, 3L, 99L});
    equalsHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(3), Matchers.is(1L));
    assertThat(vonNeumannMachine.getActualValue(),Matchers.is(99L));
  }

  @Test
  public void moveWithRelativeMode() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new long[]{208L, 0L, 5L, 3L, 99L, 12L});
    vonNeumannMachine.addAtRelativeCursor(5L);
    equalsHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(3), Matchers.is(1L));
    assertThat(vonNeumannMachine.getActualValue(),Matchers.is(99L));
  }
}
