package it.lpleo.adventofcode.domain;

import java.util.List;
import lombok.Getter;

public abstract class PuzzleSolver {

    @Getter
    private Puzzle puzzle;
    
    public PuzzleSolver(Puzzle puzzle) {
        this.puzzle = puzzle;
    }
    
    public abstract String solvePart1(List<String> inputList);
    public abstract String solvePart2(List<String> inputList);
}
