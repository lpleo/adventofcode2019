package it.lpleo.adventofcode.y2019.p11.domain;

public enum Color {
  WHITE(1), BLACK(0);

  private final double value;

  Color(double value) {
    this.value = value;
  }

  public double getValue() {
    return this.value;
  }

  public static Color byValue(double value) {
    for (Color color : Color.values()) {
      if (color.value == value) {
        return color;
      }
    }
    throw new RuntimeException("Unrecognized color value [" + value + "]");
  }
}
