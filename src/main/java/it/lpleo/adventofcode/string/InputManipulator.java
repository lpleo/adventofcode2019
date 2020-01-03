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

  public static List<String> convertStringInStringsList(String input) {
    List<String> result = new ArrayList<>();
    for (char letter : input.toCharArray()) {
      result.add(letter + "");
    }
    return result;
  }

  public static List<String> convertIntegerListInStringList(List<Integer> integerList) {
    List<String> result = new ArrayList<>();
    for (Integer integer : integerList) {
      result.add(integer + "");
    }
    return result;
  }

  public static List<String> copy(List<String> sourceList) {
    List<String> result = new ArrayList<>();
    for (String source : sourceList) {
      result.add(String.copyValueOf(source.toCharArray()));
    }
    return result;
  }
}
