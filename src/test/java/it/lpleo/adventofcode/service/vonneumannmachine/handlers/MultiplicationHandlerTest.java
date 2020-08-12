package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.service.vonneumannmachine.handlers.MultiplicationHandler;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import org.hamcrest.Matchers;
import org.junit.Test;

public class MultiplicationHandlerTest {

  private MultiplicationHandler multiplicationHandler = new MultiplicationHandler();

  @Test
  public void moveWithReferencedModeTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{2, 3, 6, 5, 99, 6, 5});
    multiplicationHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(5), Matchers.is(25L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithImmediateMode() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new long[]{1102, 1, 1, 3, 99});
    multiplicationHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(3), Matchers.is(1L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithRelativeMode() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{202, 0, 5, 3, 99, 12});
    vonNeumannMachine.addAtRelativeCursor(5);
    multiplicationHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(3), Matchers.is(144L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

}
