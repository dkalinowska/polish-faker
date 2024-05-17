package service;

import java.util.List;
import java.util.Random;

public class RandomValueExtractor {

    private final static YamlHandler yamlHandler = new YamlHandler();
    private final static Random random = new Random();

    public static String getRandomValue(String filePath, String... keys) {
        List<String> values = yamlHandler.getListForGivenKey(filePath, keys);
        return values.get(random.nextInt(values.size()));
    }
}