package it.lpleo.adventofcode.y2019.p5;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachineOutput;
import it.lpleo.adventofcode.domain.vonneumannmachine.VonNeumannMachine;
import it.lpleo.adventofcode.service.vonneumannmachine.HandlerList;
import it.lpleo.adventofcode.service.vonneumannmachine.VonNeumannMachineRunner;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ChanceOfAsteroidsPuzzleSolverTest {

  @Test
  public void solvePart1InputOutputTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new long[]{3, 0, 4, 0, 99});
    vonNeumannMachine.addInputValue(6L);
    VonNeumannMachineOutput vonNeumannMachineOutput = runMachine(vonNeumannMachine).get(0);
    assertThat(vonNeumannMachineOutput.getResult(), is(6.0));
  }

  @Test
  public void solvePart1ParameterImmediateModeTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new long[]{1002, 4, 3, 4, 33});
    runMachine(vonNeumannMachine);
    assertThat(vonNeumannMachine.getValue(4), is(99L));
  }

  @Test
  public void solvePart2IfEqualsTo8PositionModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8});

    vonNeumannMachine.addInputValue(8L);
    VonNeumannMachineOutput vonNeumannMachineOutput = runMachine(vonNeumannMachine).get(0);
    assertThat(vonNeumannMachineOutput.getResult(), is(1.0));
  }

  @Test
  public void solvePart2IfLessThan8PositionModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8});

    vonNeumannMachine.addInputValue(5L);
    VonNeumannMachineOutput vonNeumannMachineOutput = runMachine(vonNeumannMachine).get(0);
    assertThat(vonNeumannMachineOutput.getResult(), is(1.0));
  }

  @Test
  public void solvePart2IfEqualTo8ImmediateModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{3, 3, 1108, -1, 8, 3, 4, 3, 99});

    vonNeumannMachine.addInputValue(8L);
    VonNeumannMachineOutput vonNeumannMachineOutput = runMachine(vonNeumannMachine).get(0);
    assertThat(vonNeumannMachineOutput.getResult(), is(1.0));
  }

  @Test
  public void solvePart2IfEqualsTo8ImmediateModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{3, 3, 1107, -1, 8, 3, 4, 3, 99});

    vonNeumannMachine.addInputValue(9L);
    VonNeumannMachineOutput vonNeumannMachineOutput = runMachine(vonNeumannMachine).get(0);
    assertThat(vonNeumannMachineOutput.getResult(), is(0.0));
  }

  @Test
  public void solvePart2ComplexExample() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new long[]{3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31,
            1106, 0, 36, 98, 0, 0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104,
            999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99});

    vonNeumannMachine.addInputValue(7L);
    VonNeumannMachineOutput vonNeumannMachineOutput = runMachine(vonNeumannMachine).get(0);
    assertThat(vonNeumannMachineOutput.getResult(), is(999.0));
  }


  private List<VonNeumannMachineOutput> runMachine(VonNeumannMachine vonNeumannMachine) {
    List<VonNeumannMachineOutput> vonNeumannMachineOutputList = new ArrayList<>();
    while (vonNeumannMachine.hasNotFinished()) {
      VonNeumannMachineOutput vonNeumannMachineOutput = VonNeumannMachineRunner
          .runAndStopOnOutput(vonNeumannMachine, HandlerList.getIstance().getHandlers());
      vonNeumannMachineOutputList.add(vonNeumannMachineOutput);
    }
    return vonNeumannMachineOutputList;
  }
}
