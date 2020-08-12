package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.ChangeRelativeBaseHandler;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ChangeRelativeBaseHandlerTest {

  private ChangeRelativeBaseHandler relativeBaseHandler = new ChangeRelativeBaseHandler();

  @Test
  public void moveWithReferencedModeTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{9, 1, 99});
    relativeBaseHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getRelativeCursor(), Matchers.is(1L));
    assertThat(vonNeumannMachine.getActualValue(),Matchers.is(99L));
  }

  @Test
  public void moveWithImmediateMode() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new long[]{109, 5, 99});
    relativeBaseHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getRelativeCursor(), Matchers.is(5L));
    assertThat(vonNeumannMachine.getActualValue(),Matchers.is(99L));
  }

  @Test
  public void moveWithRelativeMode() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{209, 2, 99, 0, 0, 3});
    vonNeumannMachine.addAtRelativeCursor(3L);
    relativeBaseHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getRelativeCursor(), Matchers.is(6L));
    assertThat(vonNeumannMachine.getActualValue(),Matchers.is(99L));
  }
}
