package it.lpleo.adventofcode.y2019.p1;

import it.lpleo.adventofcode.domain.PuzzleSolver;
import it.lpleo.adventofcode.domain.Puzzle;

import java.util.List;

import static java.lang.Integer.*;
import static java.lang.Math.floor;

public class RocketEquationPuzzleSolver extends PuzzleSolver {

    public RocketEquationPuzzleSolver() {
        super(new Puzzle(1, 2019, "RocketEquation"));
    }

    public String solvePart1(List<String> inputList) {
        int result = 0;
        for (String input : inputList) {
            result += calculateFuelPerModule(parseInt(input));
        }
        return result + "";
    }

    public String solvePart2(List<String> inputList) {
        int totalResult = 0;
        for (String input : inputList) {
            int fuelAmountWithFuel = calculateFuelPerFuel(calculateFuelPerModule(parseInt(input)));
            totalResult += fuelAmountWithFuel;
        }
        return totalResult + "";
    }

    private int calculateFuelPerFuel(int fuel) {
        int fuelAmountPerFuel = calculateFuelPerModule(fuel);
        while (fuelAmountPerFuel > 0) {
            fuel += fuelAmountPerFuel;
            fuelAmountPerFuel = calculateFuelPerModule(fuelAmountPerFuel);
        }
        return fuel;
    }

    private int calculateFuelPerModule(int input) {
        float mass = (float) input;
        return (int) ((floor(mass / 3)) - 2);
    }
}
