package it.lpleo.adventofcode.service;

import java.util.List;

public class ListService {
  public static <T> T getLast(List<T> list) {
    if(list != null && list.size() > 0) {
      return list.get(list.size() - 1);
    }
    return null;
  }
}
