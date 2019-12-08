package it.lpleo.adventofcode.puzzle;

import it.lpleo.adventofcode.file.FileHandler;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Puzzle {
    private int number;
    private int year;
    private String name;

    public String getPath() {
        return "/y" + year + "/p" + number + ".txt";
    }
}
