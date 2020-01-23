package it.lpleo.adventofcode.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

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
