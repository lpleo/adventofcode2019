package it.lpleo.adventofcode.file;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileHandler {
    private static FileHandler instance = null;

    public static FileHandler getInstance() {
        if (instance == null) {
            instance = new FileHandler();
        }
        return instance;
    }

    public List<String> readFile(String resourcePath) {
        URL resource = this.getClass().getResource(resourcePath);
        try {
            Path path = Paths.get(resource.toURI());
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
