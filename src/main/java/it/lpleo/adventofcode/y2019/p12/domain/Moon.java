package it.lpleo.adventofcode.y2019.p12.domain;

import it.lpleo.adventofcode.domain.geometry.I3DPoint;
import it.lpleo.adventofcode.domain.geometry.ThreeDimensionalPoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Moon {

  private String key;
  private I3DPoint position;
  private I3DPoint velocity;

  private Moon() {
    velocity = new ThreeDimensionalPoint(0, 0, 0);
  }
}
