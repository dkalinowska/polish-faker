package service;

import org.junit.jupiter.api.Test;

import static random.person.Name.NameKey.FEMALE_FIRST_NAME;
import static service.Randomizer.getRandomValue;

public class RandomizerTest {

    @Test
    void testGetRandomValue() {
        System.out.println(getRandomValue("person/name.yaml", FEMALE_FIRST_NAME));
    }
}
