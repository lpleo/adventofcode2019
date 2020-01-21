package it.lpleo.adventofcode.y2019.p5.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HandlerOutput {
  private boolean wait;
  private long result;
}
