package it.lpleo.adventofcode.y2019.p13.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class GameBlock {

  private final double x;
  private final double y;
  @Setter
  private GameBlockTitleId titleId;
}
