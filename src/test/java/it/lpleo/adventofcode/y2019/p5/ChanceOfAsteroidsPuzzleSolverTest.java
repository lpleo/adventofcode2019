package it.lpleo.adventofcode.y2019.p5;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachineRunner;
import it.lpleo.adventofcode.y2019.p2.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.EqualsHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.InputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfFalseHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfTrueHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.LessThanHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.OutputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.SumHandler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
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
    InputStream stream = new ByteArrayInputStream("6".getBytes(StandardCharsets.UTF_8));
    VonNeumannMachineRunner.run(vonNeumannMachine,
        asList(new InputHandler(stream), new OutputHandler(), new ErrorHandler()));

    assertThat(outContent.toString().split("\n")[1].trim(), is("RESULT TEST: 6"));
  }

  @Test
  public void solvePart1ParameterImmediateModeTest() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(new int[]{1002, 4, 3, 4, 33});
    VonNeumannMachineRunner.run(vonNeumannMachine,
        asList(new MultiplicationHandler(), new ErrorHandler()));

    assertThat(vonNeumannMachine.getValue(4), is(99));
  }

  @Test
  public void solvePart2IfEqualsTo8PositionModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new int[]{3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8});

    InputStream stream = new ByteArrayInputStream("8".getBytes(StandardCharsets.UTF_8));
    VonNeumannMachineRunner.run(vonNeumannMachine, getPT2Handlers(stream));

    assertThat(outContent.toString().split("\n")[1].trim(), is("RESULT TEST: 1"));
  }

  @Test
  public void solvePart2IfLessThan8PositionModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new int[]{3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8});

    InputStream stream = new ByteArrayInputStream("5".getBytes(StandardCharsets.UTF_8));
    VonNeumannMachineRunner.run(vonNeumannMachine, getPT2Handlers(stream));

    assertThat(outContent.toString().split("\n")[1].trim(), is("RESULT TEST: 1"));
  }

  @Test
  public void solvePart2IfEqualTo8ImmediateModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new int[]{3, 3, 1108, -1, 8, 3, 4, 3, 99});

    InputStream stream = new ByteArrayInputStream("8".getBytes(StandardCharsets.UTF_8));
    VonNeumannMachineRunner.run(vonNeumannMachine, getPT2Handlers(stream));

    assertThat(outContent.toString().split("\n")[1].trim(), is("RESULT TEST: 1"));
  }

  @Test
  public void solvePart2IfEqualsTo8ImmediateModeOutput1() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new int[]{3, 3, 1107, -1, 8, 3, 4, 3, 99});

    InputStream stream = new ByteArrayInputStream("9".getBytes(StandardCharsets.UTF_8));
    VonNeumannMachineRunner.run(vonNeumannMachine, getPT2Handlers(stream));

    assertThat(outContent.toString().split("\n")[1].trim(), is("RESULT TEST: 0"));
  }

  @Test
  public void solvePart2ComplexExample() {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        new int[]{3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31,
            1106, 0, 36, 98, 0, 0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104,
            999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99});

    InputStream stream = new ByteArrayInputStream("7".getBytes(StandardCharsets.UTF_8));
    VonNeumannMachineRunner.run(vonNeumannMachine, getPT2Handlers(stream));

    assertThat(outContent.toString().split("\n")[1].trim(), is("RESULT TEST: 999"));
  }


  private List<MoveHandler> getPT2Handlers(InputStream inputStream) {
    return asList(new SumHandler(),
        new MultiplicationHandler(),
        new InputHandler(inputStream),
        new OutputHandler(), new EqualsHandler(), new JumpIfFalseHandler(), new JumpIfTrueHandler(),
        new LessThanHandler(), new ErrorHandler());
  }

}
