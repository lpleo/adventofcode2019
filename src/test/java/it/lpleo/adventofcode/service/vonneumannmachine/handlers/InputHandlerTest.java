package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.service.vonneumannmachine.handlers.InputHandler;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import java.util.LinkedList;
import org.hamcrest.Matchers;
import org.junit.Test;

public class InputHandlerTest {

  InputHandler inputHandler = new InputHandler();

  @Test
  public void moveWithImmediateMode() {
    LinkedList<Long> inputValues = new LinkedList<>();
    inputValues.add(10L);
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{103, 3, 99}, inputValues, new LinkedList<>());
    inputHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(3), Matchers.is(10L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }

  @Test
  public void moveWithRelativeMode() {
    LinkedList<Long> inputValues = new LinkedList<>();

    inputValues.add(10L);
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{203, 2, 99, 0, 0, 3}, inputValues, new LinkedList<>());
    vonNeumannMachine.addAtRelativeCursor(3L);
    inputHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(5), Matchers.is(10L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }
}
