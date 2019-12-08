package it.lpleo.adventofcode.y2019.p1;

import org.junit.Test;

import static it.lpleo.adventofcode.y2019.PuzzleSolvers.getRocketEquationPuzzle;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RocketEquationPuzzleSolverTest {

    private RocketEquationPuzzleSolver rocketEquationPuzzle = new RocketEquationPuzzleSolver(getRocketEquationPuzzle());

    @Test
    public void solvePart1Test() {
        String result = rocketEquationPuzzle.solvePart1(singletonList("12"));
        assertThat(result, is("2"));

        result = rocketEquationPuzzle.solvePart1(singletonList("14"));
        assertThat(result, is("2"));

        result = rocketEquationPuzzle.solvePart1(singletonList("1969"));
        assertThat(result, is("654"));

        result = rocketEquationPuzzle.solvePart1(singletonList("100756"));
        assertThat(result, is("33583"));

        result = rocketEquationPuzzle.solvePart1(asList("100756", "1969"));
        assertThat(result, is((33583 + 654) + ""));
    }

    @Test
    public void solvePart2Test() {
        String result = rocketEquationPuzzle.solvePart2(singletonList("14"));
        assertThat(result, is("2"));

        result = rocketEquationPuzzle.solvePart2(singletonList("1969"));
        assertThat(result, is("966"));

        result = rocketEquationPuzzle.solvePart2(singletonList("100756"));
        assertThat(result, is("50346"));

        result = rocketEquationPuzzle.solvePart2(asList("100756", "1969"));
        assertThat(result, is((966 + 50346) + ""));
    }
}
