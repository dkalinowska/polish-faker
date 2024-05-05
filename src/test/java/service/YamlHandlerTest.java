package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
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
    public void handleYamlReturnsCorrectListWhenFileAndKeysExist() {
        String fileName = "test/java/service/test.yaml";
        String[] keys = {"key1", "key2"};
        List<String> expectedList = Arrays.asList("value1", "value2", "value3");
        Map<String, Object> yamlContent = new HashMap<>();
        yamlContent.put("key2", expectedList);
        Map<String, Object> yamlContentNested = new HashMap<>();
        yamlContentNested.put("key1", yamlContent);

        Mockito.when(yamlMock.load(inputStreamMock)).thenReturn(yamlContentNested);

        List<String> result = yamlHandler.handleYaml(fileName, keys);

        Assert.assertEquals(expectedList, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void handleYamlThrowsExceptionWhenFinalObjectIsNotAList() {
        String fileName = "test/java/service/test.yaml";
        String[] keys = {"key1", "key2"};
        Map<String, Object> yamlContent = new HashMap<>();
        yamlContent.put("key2", "value");
        Map<String, Object> yamlContentNested = new HashMap<>();
        yamlContentNested.put("key1", yamlContent);

        Mockito.when(yamlMock.load(inputStreamMock)).thenReturn(yamlContentNested);

        yamlHandler.handleYaml(fileName, keys);
    }

    @Test(expected = NullPointerException.class)
    public void handleYamlThrowsExceptionWhenFileDoesNotExist() {
        String fileName = "nonexistent.yaml";
        String[] keys = {"testKey"};

        yamlHandler.handleYaml(fileName, keys);
    }

    @Test(expected = NullPointerException.class)
    public void handleYamlThrowsExceptionWhenKeyDoesNotExist() {
        String fileName = "test.yaml";
        String[] keys = {"nonexistentKey"};

        yamlHandler.handleYaml(fileName, keys);
    }
}