package it.lpleo.adventofcode.service.vonneumannmachine.handlers;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.service.vonneumannmachine.handlers.OutputHandler;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import java.util.LinkedList;
import org.hamcrest.Matchers;
import org.junit.Test;

public class OutputHandlerTest {

  private OutputHandler outputHandler = new OutputHandler();

  @Test
  public void moveWithReferencedModeTest() {
    LinkedList<Long> outputValues = new LinkedList<>();
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{4, 3, 99, 5}, new LinkedList<>(), outputValues);
    outputHandler.move(vonNeumannMachine);
    assertThat(outputValues.get(0), Matchers.is(5L));
    assertThat(vonNeumannMachine.getActualValue(),Matchers.is(99L));
  }


  @Test
  public void moveWithImmediateMode() {
    LinkedList<Long> outputValues = new LinkedList<>();
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{104, 3, 99}, new LinkedList<>(), outputValues);
    outputHandler.move(vonNeumannMachine);
    assertThat(outputValues.get(0), Matchers.is(3L));
    assertThat(vonNeumannMachine.getActualValue(),Matchers.is(99L));
  }

  @Test
  public void moveWithRelativeMode() {
    LinkedList<Long> outputValues = new LinkedList<>();
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{204, 2, 99, 0, 0, 3}, new LinkedList<>(), outputValues);
    vonNeumannMachine.addAtRelativeCursor(3L);
    outputHandler.move(vonNeumannMachine);
    assertThat(outputValues.get(0), Matchers.is(3L));
    assertThat(vonNeumannMachine.getActualValue(),Matchers.is(99L));
  }
}
