package random.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static random.address.Street.StreetType.ADJECTIVE;
import static random.address.Street.StreetType.FAIRYTALE;
import static random.address.Street.StreetType.GEOGRAPHY;
import static random.address.Street.StreetType.HISTORY;
import static random.address.Street.StreetType.NATURE;
import static random.address.Street.StreetType.PLACE;
import static random.address.Street.StreetType.SURNAME;
import static service.Randomizer.getRandomValue;
import static util.RandomUtil.randomNumber;

/**
 * This class provides methods for generating random street names.
 */
public class Street {

    private static final String PATH = "address/street.yaml";

    @Getter
    @AllArgsConstructor
    enum StreetType implements Key {

        SURNAME("surname"),
        ADJECTIVE("adjective"),
        FAIRYTALE("fairytale"),
        HISTORY("history"),
        GEOGRAPHY("geography"),
        PLACE("place"),
        NATURE("nature");

        private final String key;
    }

    /**
     * @return random street name.
     */
    public String random() {
        return getRandomStreet(StreetType.values()[randomNumber(StreetType.values().length)]);
    }

    /**
     * @return street name of a specified kind (based on a surname, adjective etc.).
     */
    public StreetBasedOn basedOn() {
        return new StreetBasedOn();
    }

    private static String getRandomStreet(Key key) {
        return getRandomValue(PATH, key);
    }

    public static class StreetBasedOn {

        /**
         * @return street name based on a surname.
         */
        public String surname() {
            return getRandomStreet(SURNAME);
        }

        /**
         * @return street name based on an adjective.
         */
        public String adjective() {
            return getRandomStreet(ADJECTIVE);
        }

        /**
         * @return street name based on a fairytale.
         */
        public String fairytale() {
            return getRandomStreet(FAIRYTALE);
        }

        /**
         * @return street name based on a historical event.
         */
        public String history() {
            return getRandomStreet(HISTORY);
        }

        /**
         * @return street name based on a geographical location.
         */
        public String geography() {
            return getRandomStreet(GEOGRAPHY);
        }

        /**
         * @return street name based on a place.
         */
        public String place() {
            return getRandomStreet(PLACE);
        }

        /**
         * @return street name based on nature, animals.
         */
        public String nature() {
            return getRandomStreet(NATURE);
        }
    }
}
