package service;

import util.Key;

import java.util.List;
import java.util.Random;

public class Randomizer {

    private final static YamlHandler yamlHandler = new YamlHandler();
    private final static Random random = new Random();

    public static String getRandomValue(String filePath, Key key) {
        List<String> values = yamlHandler.getListForGivenKey(filePath, key.getKey());
        return values.get(random.nextInt(values.size()));
    }
}
