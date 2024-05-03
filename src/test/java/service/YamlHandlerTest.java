package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class YamlHandlerTest {
    private YamlHandler yamlHandler;
    private Yaml yamlMock;
    private InputStream inputStreamMock;

    @Before
    public void setup() {
        yamlMock = Mockito.mock(Yaml.class);
        inputStreamMock = Mockito.mock(InputStream.class);
        yamlHandler = new YamlHandler(yamlMock);
    }

    @Test
    public void handleYamlReturnsCorrectListWhenFileAndKeyExist() {
        String fileName = "test.yaml";
        String key = "testKey";
        List<String> expectedList = Arrays.asList("value1", "value2", "value3");
        Map<String, List<String>> yamlContent = Map.of(key, expectedList);

        Mockito.when(yamlMock.load(inputStreamMock)).thenReturn(yamlContent);

        List<String> result = yamlHandler.handleYaml(fileName, key);

        Assert.assertEquals(expectedList, result);
    }

    @Test(expected = NullPointerException.class)
    public void handleYamlThrowsExceptionWhenFileDoesNotExist() {
        String fileName = "nonexistent.yaml";
        String key = "testKey";

        yamlHandler.handleYaml(fileName, key);
    }

    @Test(expected = NullPointerException.class)
    public void handleYamlThrowsExceptionWhenKeyDoesNotExist() {
        String fileName = "test.yaml";
        String key = "nonexistentKey";

        yamlHandler.handleYaml(fileName, key);
    }
}