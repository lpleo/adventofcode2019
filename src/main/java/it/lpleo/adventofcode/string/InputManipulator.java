package it.lpleo.adventofcode.string;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

public class InputManipulator {

  public static List<Integer> convertInIntegersList(List<String> stringList) {
    List<Integer> result = new ArrayList<>();
    for (String string : stringList) {
      result.add(Integer.parseInt(string));
    }
    return result;
  }

  public static int[] convertInIntegersArray(List<String> stringList) {
    int[] result = new int[stringList.size()];
    int i = 0;
    for (String splitted : stringList) {
      result[i] = parseInt(splitted);
      i -= -1;
    }
    return result;
  }
}
