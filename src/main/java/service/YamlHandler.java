package service;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class YamlHandler {

    private final Yaml yaml;

    public YamlHandler(Yaml yaml) {
        this.yaml = yaml;
    }

    public List<String> handleYaml(String fileName, String... keys) {
        Map<String, Object> yamlMap = getMap(fileName);
        if (yamlMap == null) {
            throw new IllegalArgumentException(String.format("File '%s' does not exist", fileName));
        }
        for (String key : keys) {
            Object value = yamlMap.get(key);
            if (value instanceof Map<?, ?>) {
                yamlMap = (Map<String, Object>) value;
            } else {
                throw new IllegalArgumentException(String.format("Key '%s' does not exist", key));
            }
        }
        if (yamlMap.values().stream().allMatch(val -> val instanceof String)) {
            return yamlMap.values().stream()
                    .map(Object::toString)
                    .collect(ArrayList::new, Collection::add, Collection::addAll);
        } else {
            throw new IllegalArgumentException("The final object is not a list of strings");
        }
    }

    public Map<String, Object> getMap(String fileName) {
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);
        if (inputStream == null) {
            return null;
        }
        return yaml.load(inputStream);
    }
}