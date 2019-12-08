package it.lpleo.adventofcode.y2019;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.file.FileHandler;
import it.lpleo.adventofcode.puzzle.Puzzle;
import it.lpleo.adventofcode.y2019.p1.RocketEquationPuzzleSolver;
import it.lpleo.adventofcode.y2019.p2.Error1202PuzzleSolver;

import java.util.ArrayList;
import java.util.List;

public class PuzzleSolvers {

    public static List<PuzzleSolver> instantiate2019PuzzleSolvers() {
        List<PuzzleSolver> puzzles2019 = new ArrayList<>();
        puzzles2019.add(new RocketEquationPuzzleSolver(getRocketEquationPuzzle()));
        puzzles2019.add(new Error1202PuzzleSolver(getError1202Puzzle()));
        return puzzles2019;
    }

    public static void solvePuzzles(List<PuzzleSolver> puzzleSolvers) {
        FileHandler fileHandler = FileHandler.getInstance();
        for (PuzzleSolver puzzleSolver : puzzleSolvers) {
            
            Puzzle puzzle = puzzleSolver.getPuzzle();
            
            List<String> inputList = fileHandler.readFile(puzzle.getPath());
            String solution1 = puzzleSolver.solvePart1(inputList);
            String solution2 = puzzleSolver.solvePart2(inputList);
            
            System.out.println("The solution for puzzle [" + puzzle.getYear() + " " + puzzle.getNumber() + ".1 " + puzzle.getName() + "] is " + solution1);
            System.out.println("The solution for puzzle [" + puzzle.getYear() + " " + puzzle.getNumber() + ".2 " + puzzle.getName() + "] is " + solution2);
        }
    }


    public static Puzzle getRocketEquationPuzzle() {
        return new Puzzle(1, 2019, "RocketEquation");
    }
    public static Puzzle getError1202Puzzle() {
        return new Puzzle(2, 2019, "Error1202");
    }
}
