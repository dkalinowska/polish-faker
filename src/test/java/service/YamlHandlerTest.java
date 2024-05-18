package service;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class YamlHandlerTest {

    private final YamlHandler yamlHandler = new YamlHandler();

    private final static String CORRECT_FILE = "testing/test.yaml";
    private final static String NESTED_FILE = "testing/list.yaml";

    @Test
    public void testGetYamlAsMap() {
        Map<String, Object> map = yamlHandler.getYamlAsMap(CORRECT_FILE);
        System.out.println(map);
    }

    @Test
    public void testGetListForGivenKey() {
        System.out.println(yamlHandler.getListForGivenKey(NESTED_FILE, "a", "b", "c"));
    }
}