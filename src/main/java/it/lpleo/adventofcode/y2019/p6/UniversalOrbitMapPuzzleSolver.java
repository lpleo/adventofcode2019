package it.lpleo.adventofcode.y2019.p6;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.y2019.p6.domain.Node;
import it.lpleo.adventofcode.y2019.p6.service.GraphService;
import java.util.ArrayList;
import java.util.List;

public class UniversalOrbitMapPuzzleSolver extends PuzzleSolver {

  public UniversalOrbitMapPuzzleSolver(Puzzle puzzle) {
    super(puzzle);
  }

  @Override
  public String solvePart1(List<String> inputList) {

    List<Node> nodes = new ArrayList<>();

    for (String input : inputList) {
      String data = input.split("\\)")[1];
      String parent = input.split("\\)")[0];

      GraphService.addNode(nodes, data, parent);
    }

    Node rootNode = GraphService.findRoot(nodes);
    return "" + GraphService.calculateDistance(rootNode);
  }

  @Override
  public String solvePart2(List<String> inputList) {
    return null;
  }
}
