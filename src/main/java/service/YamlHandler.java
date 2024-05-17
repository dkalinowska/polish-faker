package service;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YamlHandler {

    private final Yaml yaml;

    public YamlHandler() {
        this.yaml = new Yaml();
    }

    @SuppressWarnings("unchecked")
    List<String> getListForGivenKey(String filePath, String... keys) {
        Map<String, Object> map = getYamlAsMap(filePath);
        for (String key : keys) {
            Object value = map.get(key);
            switch (value) {
                case Map<?, ?> _ -> map = (Map<String, Object>) value;
                case List<?> objects -> {
                    return objects.stream().map(Object::toString).collect(Collectors.toList());
                }
                case null -> throw new IllegalArgumentException(String.format("Key '%s' does not exist.", key));
                default ->
                        throw new IllegalArgumentException(String.format("Key '%s' leads to value '%s' which is not a list.", key, value));
            }
        }
        throw new IllegalArgumentException("The final object is not a list");
    }

    Map<String, Object> getYamlAsMap(String filePath) {
        verifyFileIsYaml(filePath);
        InputStream inputStream;
        inputStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null)
            throw new IllegalArgumentException(String.format("Failed to load file '%s'.", filePath));
        return yaml.load(inputStream);
    }

    private static void verifyFileIsYaml(String filePath) {
        if (!(filePath.endsWith(".yaml") || filePath.endsWith(".yml")))
            throw new IllegalArgumentException(String.format("Path '%s' doesn't lead to a yaml file.\n" +
                    "Please provide a path to a valid yaml file.", filePath));
    }
}