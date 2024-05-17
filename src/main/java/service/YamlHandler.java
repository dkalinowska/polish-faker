package service;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class YamlHandler {

    private final Yaml yaml;

    public YamlHandler(Yaml yaml) {
        this.yaml = yaml;
    }

    public Map<String, Object> getYamlAsMap(String filePath) {
        verifyFileExists(filePath);
        verifyFileIsYaml(filePath);
        InputStream inputStream;
        inputStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
        return yaml.load(inputStream);
    }

    public static void verifyFileIsYaml(String filePath) {
        if (filePath.endsWith(".yaml") || filePath.endsWith(".yml"))
            throw new IllegalArgumentException(String.format("Invalid path %s. " +
                    "Please provide a path to a valid yaml file.", filePath));
    }

    public static void verifyFileExists(String filePath) {
        if (!Files.exists(Paths.get(filePath)))
            throw new IllegalArgumentException("Invalid path. Please provide a valid path.");
    }
}