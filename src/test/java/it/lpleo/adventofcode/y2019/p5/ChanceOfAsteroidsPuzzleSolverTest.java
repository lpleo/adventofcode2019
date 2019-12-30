package it.lpleo.adventofcode.y2019.p5;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p5.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.EqualsHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.InputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfFalseHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfTrueHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.LessThanHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.OutputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.SumHandler;
import it.lpleo.adventofcode.y2019.p7.StoppableVonNeumannMachineRunner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChanceOfAsteroidsPuzzleSolverTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  public void solvePart1InputOutputTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new int[]{3, 0, 4, 0, 99});
    LinkedList<Integer> fifoQueue = new LinkedList<>(singletonList(6));
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine,
        asList(new InputHandler(fifoQueue), new OutputHandler(fifoQueue), new ErrorHandler()));

    assertThat(fifoQueue.poll(), is(6));
  }

  @Test
  public void solvePart1ParameterImmediateModeTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new int[]{1002, 4, 3, 4, 33});
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine,
        asList(new MultiplicationHandler(), new ErrorHandler()));

    assertThat(vonNeumannMachine.getValue(4), is(99));
  }

  @Test
  public void solvePart2IfEqualsTo8PositionModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new int[]{3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8});

    LinkedList<Integer> fifoQueue = new LinkedList<>(singletonList(8));
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine, getPT2Handlers(fifoQueue));

    assertThat(fifoQueue.poll(), is(1));
  }

  @Test
  public void solvePart2IfLessThan8PositionModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new int[]{3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8});

    LinkedList<Integer> fifoQueue = new LinkedList<>(singletonList(5));
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine, getPT2Handlers(fifoQueue));

    assertThat(fifoQueue.poll(), is(1));
  }

  @Test
  public void solvePart2IfEqualTo8ImmediateModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new int[]{3, 3, 1108, -1, 8, 3, 4, 3, 99});

    LinkedList<Integer> fifoQueue = new LinkedList<>(singletonList(8));
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine, getPT2Handlers(fifoQueue));

    assertThat(fifoQueue.poll(), is(1));
  }

  @Test
  public void solvePart2IfEqualsTo8ImmediateModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new int[]{3, 3, 1107, -1, 8, 3, 4, 3, 99});

    LinkedList<Integer> fifoQueue = new LinkedList<>(singletonList(9));
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine, getPT2Handlers(fifoQueue));

    assertThat(fifoQueue.poll(), is(0));
  }

  @Test
  public void solvePart2ComplexExample() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new int[]{3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31,
            1106, 0, 36, 98, 0, 0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104,
            999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99});

    LinkedList<Integer> fifoQueue = new LinkedList<>(singletonList(7));
    StoppableVonNeumannMachineRunner.run(vonNeumannMachine, getPT2Handlers(fifoQueue));

    assertThat(fifoQueue.poll(), is(999));
  }


  private List<MoveHandler> getPT2Handlers(LinkedList<Integer> fifoqueue) {
    return asList(new SumHandler(),
        new MultiplicationHandler(),
        new InputHandler(fifoqueue),
        new OutputHandler(fifoqueue), new EqualsHandler(), new JumpIfFalseHandler(),
        new JumpIfTrueHandler(),
        new LessThanHandler(), new ErrorHandler());
  }

}
