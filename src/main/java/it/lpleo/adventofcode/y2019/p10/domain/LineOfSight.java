package it.lpleo.adventofcode.y2019.p10.domain;

import it.lpleo.adventofcode.domain.geometry.Straight;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LineOfSight {

  public LineOfSight(Straight straight) {
    this.straight = straight;
    this.asteroidsInSight = new ArrayList<>();
  }

  private Straight straight;
  private List<Asteroid> asteroidsInSight;
}
