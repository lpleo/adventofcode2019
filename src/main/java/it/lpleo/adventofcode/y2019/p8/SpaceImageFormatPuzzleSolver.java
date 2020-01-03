package it.lpleo.adventofcode.y2019.p8;

import static it.lpleo.adventofcode.y2019.p8.service.LayerService.generateImage;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.string.InputManipulator;
import it.lpleo.adventofcode.y2019.p8.service.LayerService;
import java.util.List;

public class SpaceImageFormatPuzzleSolver extends PuzzleSolver {

  public SpaceImageFormatPuzzleSolver(Puzzle puzzle) {
    super(puzzle);
  }

  @Override
  public String solvePart1(List<String> inputList) {
    String layer = LayerService.findLayerWithLess0(generateLayers(inputList));
    return layer.chars().filter(c -> c == '1').count() * layer.chars().filter(c -> c == '2').count()
        + "";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    return generateImage(generateLayers(inputList), 25, 6);
  }

  private List<String> generateLayers(List<String> inputList) {
    inputList = InputManipulator.convertStringInStringsList(inputList.get(0));
    return LayerService.extractLayer(inputList, 25, 6);
  }
}
