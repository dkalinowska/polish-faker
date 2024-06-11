package random.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import java.util.Random;

import static random.address.Country.CountryKey.AFRICA;
import static random.address.Country.CountryKey.ASIA;
import static random.address.Country.CountryKey.EUROPE;
import static random.address.Country.CountryKey.NORTH_AMERICA;
import static random.address.Country.CountryKey.OCEANIA;
import static random.address.Country.CountryKey.SOUTH_AMERICA;
import static service.Randomizer.getRandomValue;

/**
 * This class provides a random country name.
 */
public class Country {

    private static final String PATH = "address/country.yaml";
    private final Random random = new Random();

    @Getter
    @AllArgsConstructor
    enum CountryKey implements Key {

        EUROPE("europe"),
        ASIA("asia"),
        AFRICA("africa"),
        NORTH_AMERICA("north_america"),
        SOUTH_AMERICA("south_america"),
        OCEANIA("oceania");

        private final String key;
    }

    /**
     * @return random country name.
     */
    public String random() {
        return getRandomCountry(CountryKey.values()[random.nextInt(CountryKey.values().length)]);
    }

    /**
     * @return random country name from a specified continent.
     */
    public CountyFromContinent fromContinent() {
        return new CountyFromContinent();
    }

    private static String getRandomCountry(Key key) {
        return getRandomValue(PATH, key);
    }

    /**
     * This class provides methods for generating random country names from specified continents.
     */
    public static class CountyFromContinent {

        /**
         * @return random country from Europe.
         */
        public String europe() {
            return getRandomCountry(EUROPE);
        }

        /**
         * @return random country from Asia.
         */
        public String asia() {
            return getRandomCountry(ASIA);
        }

        /**
         * @return random country from Africa.
         */
        public String africa() {
            return getRandomCountry(AFRICA);
        }

        /**
         * @return random country from North America.
         */
        public String northAmerica() {
            return getRandomCountry(NORTH_AMERICA);
        }

        /**
         * @return random country from South America.
         */
        public String southAmerica() {
            return getRandomCountry(SOUTH_AMERICA);
        }

        /**
         * @return random country from Australia.
         */
        public String oceania() {
            return getRandomCountry(OCEANIA);
        }
    }
}
