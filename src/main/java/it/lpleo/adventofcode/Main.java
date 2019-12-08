package it.lpleo.adventofcode;

import it.lpleo.adventofcode.y2019.PuzzleSolvers;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PuzzleSolver> puzzleSolvers = PuzzleSolvers.instantiate2019PuzzleSolvers();
        PuzzleSolvers.solvePuzzles(puzzleSolvers);
    }
}
