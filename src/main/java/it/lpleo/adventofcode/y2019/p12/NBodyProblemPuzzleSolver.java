package it.lpleo.adventofcode.y2019.p12;

import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.service.CombinationService;
import it.lpleo.adventofcode.y2019.p12.domain.Moon;
import it.lpleo.adventofcode.y2019.p12.service.MoonService;
import java.util.List;

public class NBodyProblemPuzzleSolver extends PuzzleSolver {

  public NBodyProblemPuzzleSolver() {
    super(new Puzzle(12, 2019, "NBodyProblem"));
  }

  private final CombinationService combinationService = CombinationService.getIstance();
  private final MoonService moonService = MoonService.getIstance();
  private final NBodyProblemHelper nBodyProblemHelper = NBodyProblemHelper.getIstance();

  @Override
  public String solvePart1(List<String> inputList) {
    int numberOfSteps = Integer.parseInt(inputList.get(0));
    inputList = inputList.subList(1, inputList.size());
    List<Moon> moons = moonService.createMoons(inputList);
    List<String> keys = moonService.extractKeys(moons);
    List<List<String>> combinations = combinationService.getTwoByTwoCombination(keys);

    for (int i = 0; i < numberOfSteps; i++) {
      nBodyProblemHelper.updateMoonVelocities(combinations, moons);
      nBodyProblemHelper.updateMoonsPositions(moons);
    }
    return nBodyProblemHelper.calculateMoonsEnergy(moons) + "";
  }

  @Override
  public String solvePart2(List<String> inputList) {
    return null;
  }
}
