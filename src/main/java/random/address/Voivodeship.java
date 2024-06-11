package random.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static random.address.Voivodeship.VoivodeshipKey.VOIVODESHIP;
import static service.Randomizer.getRandomValue;

/**
 * This class provides a method which returns a random Polish voivodeship.
 */
public class Voivodeship {

    private final static String PATH = "address/voivodeship.yaml";

    @Getter
    @AllArgsConstructor
    enum VoivodeshipKey implements Key {

        VOIVODESHIP("voivodeship");

        private final String key;
    }

    /**
     * @return random Polish voivodeship
     */
    public String random() {
        return getRandomValue(PATH, VOIVODESHIP);
    }
}
