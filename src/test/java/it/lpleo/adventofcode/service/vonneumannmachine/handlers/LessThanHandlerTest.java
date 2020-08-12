package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;
import org.hamcrest.Matchers;
import org.junit.Test;

public class LessThanHandlerTest {

  private LessThanHandler lessThanHandler = new LessThanHandler();

  @Test
  public void moveWithReferencedModeResultTrueTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{7, 5, 6, 7, 99, 1, 4, 25});
    lessThanHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(7), is(1L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithImmediateModeResultTrue() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1007, 6, 2, 5, 99, 4, 1});
    lessThanHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(5), is(1L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithRelativeModeResultTrue() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1207, 5, 4, 6, 99, 4, 2});
    vonNeumannMachine.addAtRelativeCursor(1L);
    VonNeumannMachineOutput result = lessThanHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(6), is(1L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithReferencedModeResultFalseTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{7, 5, 6, 7, 99, 4, 1, 25});
    VonNeumannMachineOutput result = lessThanHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(7), is(0L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithImmediateModeResultFalse() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1007, 6, 1, 5, 99, 4, 2});
    VonNeumannMachineOutput result = lessThanHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(7), is(0L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithRelativeModeResultFalse() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1207, 5, 1, 6, 99, 4, 2});
    vonNeumannMachine.addAtRelativeCursor(1L);
    VonNeumannMachineOutput result = lessThanHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(6), is(0L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }
}
