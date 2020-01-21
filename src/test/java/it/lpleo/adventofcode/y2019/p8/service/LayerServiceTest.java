package it.lpleo.adventofcode.y2019.p8.service;

import static it.lpleo.adventofcode.string.InputManipulator.*;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class LayerServiceTest {

  private static final List<String> input = convertStringInStringsList("123456789012");

  @Test
  public void extractLayerTest() {
    List<String> result = LayerService.extractLayer(input, 3, 2);
    assertThat(result.size(), is(2));
    assertThat(result.get(0), is("123456"));
    assertThat(result.get(1), is("789012"));
  }

  @Test
  public void findLayerWithLess0Test() {
    String result = LayerService.findLayerWithLess0(asList("123456", "789012"));
    assertThat(result, is("123456"));
  }

  @Test
  public void generateImageTest() {
    String result = LayerService.generateImage(asList("0222", "1122", "2212", "0000"), 2, 2);
    assertThat(result, is("\n\n X\nX \n"));
  }
}
