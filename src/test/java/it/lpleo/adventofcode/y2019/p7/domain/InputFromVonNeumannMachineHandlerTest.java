package it.lpleo.adventofcode.y2019.p7.domain;

import static org.junit.Assert.*;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import java.util.LinkedList;
import org.hamcrest.Matchers;
import org.junit.Test;

public class InputFromVonNeumannMachineHandlerTest {

  InputFromVonNeumannMachineHandler inputFromVonNeumannMachineHandler = new InputFromVonNeumannMachineHandler();

  @Test
  public void moveWithImmediateMode() {
    LinkedList<Long> inputValues = new LinkedList<>();
    inputValues.add(10L);
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{103, 3, 99}, inputValues, new LinkedList<>());
    inputFromVonNeumannMachineHandler.move(vonNeumannMachine);
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
    inputFromVonNeumannMachineHandler.move(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(5), Matchers.is(10L));
    assertThat(vonNeumannMachine.getActualValue(), Matchers.is(99L));
  }
}
