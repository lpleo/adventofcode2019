package it.lpleo.adventofcode.string;

import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InputManipulator {

  public static long[] convertStringListInIntegersArray(List<String> stringList) {
    long[] result = new long[stringList.size()];
    int i = 0;
    for (String splitted : stringList) {
      result[i] = parseLong(splitted);
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

  public static String convertStringCollectionInString(Collection<?> collection,
      char separator) {
    StringBuilder result = new StringBuilder();
    for (Object object : collection) {
      result.append(object.toString());
      result.append(separator);
    }
    if (result.length() > 0) {
      result.deleteCharAt(result.length() - 1);
    }
    return result.toString();
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
