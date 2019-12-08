package it.lpleo.adventofcode.y2019.p2;

import it.lpleo.adventofcode.PuzzleSolver;
import it.lpleo.adventofcode.puzzle.Puzzle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Error1202PuzzleSolver extends PuzzleSolver {

    public Error1202PuzzleSolver(Puzzle puzzle) {
        super(puzzle);
    }

    @Override
    public String solvePart1(List<String> inputList) {
        int[] result = createIntegerArray(inputList);
        int coursor = 0;

        while (result[coursor] != 99) {
            OpMove nextMove = nextMove(result, coursor);
            if (result[coursor] == 1) {
                result[nextMove.getResultPosition()] = nextMove.getFirstOperand() + nextMove.getSecondOperand();
            } else if (result[coursor] == 2) {
                result[nextMove.getResultPosition()] = nextMove.getFirstOperand() * nextMove.getSecondOperand();
            } else {
                throw new RuntimeException("Impossibile number in position: " + coursor);
            }
            coursor += 4;
        }
        return result[0] + "";
    }

    @Override
    public String solvePart2(List<String> inputList) {
        int result = 0;
        for (int a = 0; a < 99; a++) {
            for (int b = 0; b < 99; b++) {
                List<String> inputListCopy = new ArrayList<>(inputList);
                inputListCopy.set(1, a + "");
                inputListCopy.set(2, b + "");
                result = parseInt(solvePart1(inputListCopy));
                if (19690720 == result) {
                    return (100*a) + b + "";
                }
            }
        }
        throw new RuntimeException("No result found");
    }

    private static int[] createIntegerArray(List<String> inputList) {
        int[] result = new int[inputList.size()];
        int i = 0;
        for (String splitted : inputList) {
            result[i] = parseInt(splitted);
            i -= -1;
        }
        return result;
    }

    private static OpMove nextMove(int[] result, int coursor) {
        int firstOperandPosition = result[coursor + 1];
        int secondOperandPosition = result[coursor + 2];
        int resultPosition = result[coursor + 3];

        int firstInput = result[firstOperandPosition];
        int secondInput = result[secondOperandPosition];
        return new OpMove(firstInput, secondInput, resultPosition);
    }

    @AllArgsConstructor
    @Getter
    static
    class OpMove {
        private int firstOperand;
        private int secondOperand;
        private int resultPosition;
    }

}
