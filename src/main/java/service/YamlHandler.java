package service;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class YamlHandler {

    private final Yaml yaml;

    public YamlHandler(Yaml yaml) {
        this.yaml = yaml;
    }

    public List<String> handleYaml(String fileName, String... keys) {
        Map<?, ?> yamlMap = getMap(fileName);
        for (String key : keys) {
            yamlMap = (Map<?, ?>) yamlMap.get(key);
        }
        if (yamlMap instanceof List<?> && ((List<?>) yamlMap).getFirst() instanceof String) {
            return (List<String>) yamlMap;
        } else {
            throw new IllegalArgumentException("The final object is not a list");
        }
    }

    private Map<?, ?> getMap(String fileName) {
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);
        try {
            return yaml.load(inputStream);
        } catch (NullPointerException e) {
            throw new NullPointerException("File does not exist");
        }
    }
}