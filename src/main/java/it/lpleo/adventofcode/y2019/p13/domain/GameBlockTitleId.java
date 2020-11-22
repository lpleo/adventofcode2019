package it.lpleo.adventofcode.y2019.p13.domain;

public enum GameBlockTitleId {
  VOID(0.0), UNBREAKABLE(1.0), BREAKABLE(2.0), PAD(3.0), BALL(4.0);

  private final double titleId;

  GameBlockTitleId(double titleId) {
    this.titleId = titleId;
  }

  public double getValue() {
    return this.titleId;
  }

  public static GameBlockTitleId byTitleId(double titleId) {
    for (GameBlockTitleId gameBlockTitleId : GameBlockTitleId.values()) {
      if (gameBlockTitleId.titleId == titleId) {
        return gameBlockTitleId;
      }
    }
    throw new RuntimeException("Unrecognized game block with titleId [" + titleId + "]");
  }

  public static boolean isBall(double titleId) {
    return titleId == BALL.getValue();
  }

  public static boolean isPad(double titleId) {
    return titleId == PAD.getValue();
  }
}
