package it.lpleo.adventofcode.y2019.p8;

import static it.lpleo.adventofcode.y2019.p8.service.LayerService.generateImage;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.service.InputManipulatorService;
import it.lpleo.adventofcode.y2019.p8.service.LayerService;
import java.util.List;

public class SpaceImageFormatPuzzleSolver extends PuzzleSolver {

  public SpaceImageFormatPuzzleSolver() {
    super(new Puzzle(8, 2019, "SpaceImageFormat"));
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
    inputList = InputManipulatorService.convertStringInStringsList(inputList.get(0));
    return LayerService.extractLayer(inputList, 25, 6);
  }
}
