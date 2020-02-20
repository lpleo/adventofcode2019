package it.lpleo.adventofcode.y2019.p5.domain.handler;

import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.HandlerOutput;
import org.hamcrest.Matchers;
import org.junit.Test;

public class JumpIfFalseHandlerTest {

  private JumpIfFalseHandler jumpIfFalseHandler = new JumpIfFalseHandler();

  @Test
  public void moveWithReferencedModeResultTrueTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{6, 6, 5, 15, 99, 4, 0});
    HandlerOutput result = jumpIfFalseHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(1.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithImmediateModeResultTrue() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1006, 6, 4, 15, 99, 4, 0});
    HandlerOutput result = jumpIfFalseHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(1.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithRelativeModeResultTrue() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1206, 5, 4, 15, 99, 4, 0});
    vonNeumannMachine.addAtRelativeCursor(1L);
    HandlerOutput result = jumpIfFalseHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(1.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithReferencedModeResultFalseTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{6, 6, 5, 15, 99, 4, 1});
    HandlerOutput result = jumpIfFalseHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(0.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(15L));
  }

  @Test
  public void moveWithImmediateModeResultFalse() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{6, 6, 5, 15, 99, 4, 1});
    HandlerOutput result = jumpIfFalseHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(0.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(15L));
  }

  @Test
  public void moveWithRelativeModeResultFalse() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{1206, 5, 4, 15, 99, 4, 1});
    vonNeumannMachine.addAtRelativeCursor(1L);
    HandlerOutput result = jumpIfFalseHandler.move(vonNeumannMachine);
    assertThat(result.getResult(), Matchers.is(0.0));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(15L));
  }
}
