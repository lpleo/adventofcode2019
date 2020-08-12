package it.lpleo.adventofcode.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileService {

  private static FileService instance = null;

  public static FileService getInstance() {
    if (instance == null) {
      instance = new FileService();
    }
    return instance;
  }

  public List<String> readFile(String resourcePath) {
    URL resource = this.getClass().getResource(resourcePath);
    try {
      Path path = Paths.get(resource.toURI());
      return Files.readAllLines(path, StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new RuntimeException("Can not find file [" + resourcePath + "]", e);
    }
  }
}
