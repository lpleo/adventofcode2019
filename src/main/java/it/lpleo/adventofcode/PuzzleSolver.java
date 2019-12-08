package it.lpleo.adventofcode;

import it.lpleo.adventofcode.puzzle.Puzzle;
import lombok.Getter;

import java.util.List;

public abstract class PuzzleSolver {

    @Getter
    private Puzzle puzzle;
    
    public PuzzleSolver(Puzzle puzzle) {
        this.puzzle = puzzle;
    }
    
    public abstract String solvePart1(List<String> inputList);
    public abstract String solvePart2(List<String> inputList);
}
