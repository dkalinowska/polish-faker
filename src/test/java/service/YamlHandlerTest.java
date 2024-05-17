package service;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class YamlHandlerTest {

    private final Yaml yaml = new Yaml();
    private final YamlHandler yamlHandler = new YamlHandler(yaml);
    private final static String CORRECT_FILE = "test.yaml";

    @Test
    public void testGetYamlAsMap() {
        yamlHandler.getYamlAsMap(CORRECT_FILE);
    }
}