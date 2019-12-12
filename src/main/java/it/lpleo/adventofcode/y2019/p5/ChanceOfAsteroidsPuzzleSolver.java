package it.lpleo.adventofcode.y2019.p5;

import static java.util.Arrays.asList;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.string.InputManipulator;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachineRunner;
import it.lpleo.adventofcode.y2019.p5.domain.handler.EqualsHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfFalseHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfTrueHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.LessThanHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.SumHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.InputHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.OutputHandler;
import java.util.ArrayList;
import java.util.List;

public class ChanceOfAsteroidsPuzzleSolver extends PuzzleSolver {

  private List<MoveHandler> pt1handlers;
  private List<MoveHandler> pt2handlers;

  public ChanceOfAsteroidsPuzzleSolver(Puzzle puzzle) {
    super(puzzle);
    pt1handlers = asList(
        new SumHandler(),
        new MultiplicationHandler(),
        new InputHandler(),
        new OutputHandler(),
        new ErrorHandler());
    pt2handlers = asList(new SumHandler(),
        new MultiplicationHandler(),
        new InputHandler(),
        new OutputHandler(), new EqualsHandler(), new JumpIfFalseHandler(), new JumpIfTrueHandler(),
        new LessThanHandler(), new ErrorHandler());
  }

  @Override
  public String solvePart1(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        InputManipulator.convertInIntegersArray(inputList));
    VonNeumannMachineRunner.run(vonNeumannMachine, pt1handlers);
    return "See over";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    VonNeumannMachine vonNeumannMachine = new VonNeumannMachine(
        InputManipulator.convertInIntegersArray(inputList));
    VonNeumannMachineRunner.run(vonNeumannMachine, pt2handlers);
    return "See over";
  }

  /*public static void main(String[] args) {
    new ChanceOfAsteroidsPuzzleSolver(new Puzzle(1, 1, ""))
        .solvePart2(asList("3", "9", "8", "9", "10", "9", "4", "9", "99", "-1", "8"));
  }*/

  /*public static void main(String[] args) {
    new ChanceOfAsteroidsPuzzleSolver(new Puzzle(1, 1, ""))
        .solvePart2(asList("3", "9", "7", "9", "10", "9", "4", "9", "99", "-1", "8"));
  }*/

  /*public static void main(String[] args) {
    new ChanceOfAsteroidsPuzzleSolver(new Puzzle(1, 1, ""))
        .solvePart2(getStringList(asList(3, 3, 1108, -1, 8, 3, 4, 3, 997)));
  }*/

  /*public static void main(String[] args) {
    new ChanceOfAsteroidsPuzzleSolver(new Puzzle(1, 1, ""))
        .solvePart2(getStringList(asList(3, 3, 1107, -1, 8, 3, 4, 3, 99)));
  }*/
  
  /*public static void main(String[] args) {
    new ChanceOfAsteroidsPuzzleSolver(new Puzzle(1, 1, ""))
        .solvePart2(getStringList(asList(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
            1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
            999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99)));
  }

  private static List<String> getStringList(List<Integer> input) {
    List<String> result = new ArrayList<>();
    for (Integer i : input) {
      result.add(i.toString());
    }
    return result;
  }*/
}

  
