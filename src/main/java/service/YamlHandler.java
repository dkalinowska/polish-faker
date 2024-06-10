package service;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * YamlHandler is a class that allows
 * to read yaml files and extract data from them.
 */
public class YamlHandler {

    private final Yaml yaml;

    YamlHandler() {
        LoaderOptions loaderOptions = new LoaderOptions();
        loaderOptions.setAllowDuplicateKeys(false);
        this.yaml = new Yaml(loaderOptions);
    }

    /**
     * @param filePath path to the yaml file
     * @param key      key for which the list of strings should be returned
     * @return a list of strings for a given key from a yaml file
     */
    public List<String> getListForGivenKey(String filePath, String key) {
        Map<String, Object> map = getYamlAsMap(filePath);
        return findListForKey(map, key);
    }

    private List<String> findListForKey(Map<String, Object> map, String key) {
        if (map == null)
            throw new IllegalArgumentException("The provided map cannot be null");
        if (key == null || key.isEmpty())
            throw new IllegalArgumentException("The provided key cannot be null or empty");

        return findListRecursive(map, key);
    }

    @SuppressWarnings("unchecked")
    private static List<String> findListRecursive(Map<String, Object> map, String key) throws IllegalArgumentException {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();

            if (key.equals(entry.getKey())) {
                if (!(value instanceof List<?> list))
                    throw new IllegalArgumentException("The value associated with the key is not a List");
                if (list.isEmpty())
                    throw new IllegalArgumentException("The list associated with the key is empty");
                if (list.getFirst() instanceof String)
                    return (List<String>) list;
                return list.stream().map(Object::toString).toList();
            }

            if (value instanceof Map<?, ?>) {
                List<String> result = findListRecursive((Map<String, Object>) value, key);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    Map<String, Object> getYamlAsMap(String filePath) {
        verifyFileIsYaml(filePath);
        InputStream inputStream;
        inputStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null)
            throw new IllegalArgumentException(String.format("Failed to load file '%s'.", filePath));
        return yaml.load(inputStream);
    }

    private void verifyFileIsYaml(String filePath) {
        if (!(filePath.endsWith(".yaml") || filePath.endsWith(".yml")))
            throw new IllegalArgumentException(String.format("Path '%s' doesn't lead to a yaml file.\n" +
                    "Please provide a path to a valid yaml file.", filePath));
    }
}