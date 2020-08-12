package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;
import org.hamcrest.Matchers;
import org.junit.Test;

public class JumpIfTrueHandlerTest {

  private JumpIfTrueHandler jumpIfTrueHandler = new JumpIfTrueHandler();

  @Test
  public void moveWithReferencedModeResultTrueTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{5, 6, 5, 15, 99, 4, 1});
    VonNeumannMachineOutput result = jumpIfTrueHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(1.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithImmediateModeResultTrue() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{5, 6, 5, 15, 99, 4, 1});
    VonNeumannMachineOutput result = jumpIfTrueHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(1.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithRelativeModeResultTrue() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1205, 5, 4, 15, 99, 4, 1});
    vonNeumannMachine.addAtRelativeCursor(1L);
    VonNeumannMachineOutput result = jumpIfTrueHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(1.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithReferencedModeResultFalseTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{5, 6, 5, 15, 99, 4, 0});
    VonNeumannMachineOutput result = jumpIfTrueHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(0.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(15L));
  }

  @Test
  public void moveWithImmediateModeResultFalse() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1005, 6, 4, 15, 99, 4, 0});
    VonNeumannMachineOutput result = jumpIfTrueHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(0.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(15L));
  }

  @Test
  public void moveWithRelativeModeResultFalse() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1205, 5, 4, 15, 99, 4, 0});
    vonNeumannMachine.addAtRelativeCursor(1L);
    VonNeumannMachineOutput result = jumpIfTrueHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(0.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(15L));
  }
}
