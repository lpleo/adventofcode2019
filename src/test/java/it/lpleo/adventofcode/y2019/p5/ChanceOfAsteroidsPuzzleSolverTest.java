package it.lpleo.adventofcode.y2019.p5;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachineRunner;
import it.lpleo.adventofcode.y2019.p2.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.InputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.OutputHandler;
import org.junit.Test;

public class ChanceOfAsteroidsPuzzleSolverTest {

  @Test
  public void solvePart1InputOutputTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new int[]{3, 0, 4, 0, 99});
    VonNeumannMachineRunner.run(vonNeumannMachine,
        asList(new InputHandler(), new OutputHandler(), new ErrorHandler()));

    for (int i = 0; i < 5; i++) {
      System.out.println(vonNeumannMachine.getValue(i) + " ");
    }
  }

  @Test
  public void solvePart1ParameterImmediateModeTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new int[]{1002, 4, 3, 4, 33});
    VonNeumannMachineRunner.run(vonNeumannMachine,
        asList(new MultiplicationHandler(), new ErrorHandler()));

    assertThat(vonNeumannMachine.getValue(4), is(99));
  }
  
}
