package service;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class YamlHandlerTest {

    private final YamlHandler yamlHandler = new YamlHandler();

    private final static String CORRECT_FILE = "testing/test.yaml";
    private final static String LIST_FILE = "testing/list.yaml";
    private final static String NESTED_FILE = "testing/nested.yaml";

    @Test
    public void testGetYamlAsMap() {
        Map<String, Object> map = yamlHandler.getYamlAsMap("person/name.yaml");
        System.out.println(map);
    }

    @Test
    public void testGetListForGivenKey() {
        System.out.println(yamlHandler.getListForGivenKey(LIST_FILE, "b"));
    }

    @Test
    public void testGetListForGivenKeyNested() {
        System.out.println(yamlHandler.getListForGivenKey(NESTED_FILE, "bottom"));
    }
}