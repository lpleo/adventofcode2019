package it.lpleo.adventofcode.y2019.p4;

import static java.util.Arrays.asList;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;
import it.lpleo.adventofcode.y2019.p4.service.AlmostTwoAdjacentEqualsDigitsCriteria;
import it.lpleo.adventofcode.y2019.p4.service.Criteria;
import it.lpleo.adventofcode.y2019.p4.service.DigitsNeverDecreaseCriteria;
import it.lpleo.adventofcode.y2019.p4.service.NoLargerGroupOfMatchingDigitsCriteria;
import it.lpleo.adventofcode.y2019.p4.service.SixDigitsCriteria;
import java.util.ArrayList;
import java.util.List;

public class SecureContainerPuzzleSolver extends PuzzleSolver {

  public SecureContainerPuzzleSolver() {
    super(new Puzzle(4, 2019, "SecureContainer"));
  }

  @Override
  public String solvePart1(List<String> inputList) {
    List<Criteria> criteriaList = asList(new SixDigitsCriteria(), new DigitsNeverDecreaseCriteria(),
        new AlmostTwoAdjacentEqualsDigitsCriteria());
    return solveForCriteria(inputList, criteriaList);
  }

  @Override
  public String solvePart2(List<String> inputList) {
    List<Criteria> criteriaList = asList(new SixDigitsCriteria(), new DigitsNeverDecreaseCriteria(),
        new AlmostTwoAdjacentEqualsDigitsCriteria(), new NoLargerGroupOfMatchingDigitsCriteria());
    return solveForCriteria(inputList, criteriaList);
  }

  private String solveForCriteria(List<String> inputList, List<Criteria> criteriaList) {
    int lowerValue = Integer.parseInt(inputList.get(0));
    int higherValue = Integer.parseInt(inputList.get(1));

    List<Integer> integers = new ArrayList<>();
    int candidatePassword;

    for (candidatePassword = lowerValue; candidatePassword <= higherValue; candidatePassword++) {
      if (checkCriteria(candidatePassword, criteriaList)) {
        integers.add(candidatePassword);
      }
    }

    return integers.size() + "";
  }

  private boolean checkCriteria(int number, List<Criteria> criteriaList) {
    boolean check = true;
    for (Criteria criteria : criteriaList) {
      check = check && criteria.checkCriteria(number);
    }
    return check;
  }
}
