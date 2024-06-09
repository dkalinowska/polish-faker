package random.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static service.RandomValueExtractor.getRandomValue;

public class Voivodeship {

    private final static String PATH = "random/address/voivodeship.yaml";

    public String name() {
        return getRandomValue(PATH, VoivodeshipKey.VOIVODESHIP);
    }

    @Getter
    @AllArgsConstructor
    enum VoivodeshipKey implements Key {

        VOIVODESHIP("voivodeship");

        private final String key;
    }
}
