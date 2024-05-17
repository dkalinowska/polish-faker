package service;

import org.junit.jupiter.api.Test;

import static service.RandomValueExtractor.getRandomValue;

public class RandomValueExtractorTest {

    @Test
    void testGetRandomValue() {
        System.out.println(getRandomValue("testing/test.yaml", "key1"));
    }
}
