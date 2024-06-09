package random.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static random.address.Street.StreetType.ADJECTIVE;
import static random.address.Street.StreetType.FAIRYTALE;
import static random.address.Street.StreetType.GEOGRAPHICAL;
import static random.address.Street.StreetType.HISTORICAL;
import static random.address.Street.StreetType.NATURE;
import static random.address.Street.StreetType.PLACE;
import static random.address.Street.StreetType.SURNAME;
import static service.RandomValueExtractor.getRandomValue;

public class Street {

    private static final String PATH = "random/address/street.yaml";

    public String surname() {
        return getRandomStreet(SURNAME);
    }

    public String adjective() {
        return getRandomStreet(ADJECTIVE);
    }

    public String fairytale() {
        return getRandomStreet(FAIRYTALE);
    }

    public String historical() {
        return getRandomStreet(HISTORICAL);
    }

    public String geographical() {
        return getRandomStreet(GEOGRAPHICAL);
    }

    public String place() {
        return getRandomStreet(PLACE);
    }

    public String nature() {
        return getRandomStreet(NATURE);
    }

//    public String random() {
//
//    }

    private String getRandomStreet(Key key) {
        return getRandomValue(PATH, key);
    }

    @Getter
    @AllArgsConstructor
    enum StreetType implements Key {

        SURNAME("surname"),
        ADJECTIVE("adjective"),
        FAIRYTALE("fairytale"),
        HISTORICAL("historical"),
        GEOGRAPHICAL("geographical"),
        PLACE("place"),
        NATURE("nature");

        private final String key;
    }
}
