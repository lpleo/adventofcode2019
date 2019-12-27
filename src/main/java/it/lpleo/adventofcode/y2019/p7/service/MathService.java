package it.lpleo.adventofcode.y2019.p7.service;

import java.util.ArrayList;
import java.util.List;

public class MathService {

  public static List<String> permutation(String inputString) {
    List<String> permutations = new ArrayList<>();
    if (inputString.length() == 1) {
      permutations.add(inputString);
    }
    if (inputString.length() > 1) {
      int lastIndex = inputString.length() - 1;
      String last = inputString.substring(lastIndex);
      String rest = inputString.substring(0, lastIndex);
      permutations = merge(permutation(rest), last);
    }
    return permutations;
  }

  public static List<String> merge(List<String> list, String c) {
    ArrayList<String> res = new ArrayList<>();
    for (String s : list) {
      for (int i = 0; i <= s.length(); ++i) {
        String ps = new StringBuffer(s).insert(i, c).toString();
        res.add(ps);
      }
    }
    return res;
  }

}
