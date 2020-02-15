package it.lpleo.adventofcode.y2019.p10.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Base {

  private Asteroid asteroidBase;
  private List<LineOfSight> visibleAsteroids;
  private int numberOfVisibleAsteroids;
  
}
