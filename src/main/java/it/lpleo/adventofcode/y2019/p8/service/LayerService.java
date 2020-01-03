package it.lpleo.adventofcode.y2019.p8.service;

import static java.util.Arrays.fill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LayerService {

  public static List<String> extractLayer(List<String> inputs, int wide, int tall) {
    List<String> layers = new ArrayList<>();
    Iterator<String> iterator = inputs.iterator();
    while (iterator.hasNext()) {
      StringBuilder layerBuilder = new StringBuilder();
      for (int i = 0; i < (wide * tall); i++) {
        layerBuilder.append(iterator.next());
      }
      layers.add(layerBuilder.toString());
    }
    return layers;
  }

  public static String findLayerWithLess0(List<String> layers) {
    String result = null;
    long lessNumberOf0 = Long.MAX_VALUE;
    for (String layer : layers) {
      long numberOf0 = layer.chars().filter(character -> character == '0').count();
      if (numberOf0 < lessNumberOf0) {
        lessNumberOf0 = numberOf0;
        result = layer;
      }
    }
    return result;
  }

  public static String generateImage(List<String> layers, int wide, int tall) {
    char[] result = new char[wide * tall];
    fill(result, '2');

    for (int i = 0; i < wide * tall; i++) {
      result[i] = extractFirstVisibleCharacter(layers, i);
    }
    String resultString = generateImage(result, wide, tall);
    return transcodeImage(resultString);
  }

  private static char extractFirstVisibleCharacter(List<String> layers, int position) {
    char result = '2';
    for (String layer : layers) {
      if (layer.charAt(position) == '0' || layer.charAt(position) == '1') {
        return layer.charAt(position);
      }
    }
    return result;
  }

  private static String generateImage(char[] image, int wide, int tall) {
    StringBuilder result = new StringBuilder("\n");
    for (int i = 0; i < tall; i++) {
      for (int j = 0; j < wide; j++) {
        result.append(image[j + (i * wide)]);
      }
      result.append("\n");
    }
    return result.toString();
  }

  private static String transcodeImage(String image) {
    StringBuilder result = new StringBuilder("\n");
    for (char character : image.toCharArray()) {
      if (character == '1') {
        result.append('X');
      } else if (character == '0') {
        result.append(" ");
      } else {
        result.append("\n");
      }
    }
    return result.toString();
  }
}
