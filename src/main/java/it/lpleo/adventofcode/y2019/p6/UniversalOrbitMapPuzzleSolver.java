package it.lpleo.adventofcode.y2019.p6;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.domain.Node;
import it.lpleo.adventofcode.service.GraphService;
import java.util.ArrayList;
import java.util.List;

public class UniversalOrbitMapPuzzleSolver extends PuzzleSolver {

  public UniversalOrbitMapPuzzleSolver() {
    super(new Puzzle(6, 2019, "UniversalOrbitMap"));
  }

  @Override
  public String solvePart1(List<String> inputList) {
    List<Node> nodes = createTree(inputList);
    Node rootNode = GraphService.findRoot(nodes);
    return "" + GraphService.calculateDistance(rootNode);
  }

  @Override
  public String solvePart2(List<String> inputList) {
    List<Node> nodes = createTree(inputList);
    Node rootNode = GraphService.findRoot(nodes);
    Node you = GraphService.findNode(rootNode, "YOU");
    Node san = GraphService.findNode(rootNode, "SAN");
    Node commonNode = GraphService.findFirstCommonNode(rootNode, you, san);
    int youDistance = GraphService.calculateDistance(commonNode, you);
    int santaDistance = GraphService.calculateDistance(commonNode, san);
    return youDistance + santaDistance
        + "";
  }

  private List<Node> createTree(List<String> inputList) {
    List<Node> nodes = new ArrayList<>();
    for (String input : inputList) {
      String data = input.split("\\)")[1];
      String parent = input.split("\\)")[0];

      GraphService.addNode(nodes, data, parent);
    }
    return nodes;
  }
}
