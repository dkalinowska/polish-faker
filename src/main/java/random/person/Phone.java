package random.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static random.person.Phone.PhoneKey.AREA_CODE;
import static random.person.Phone.PhoneKey.MOBILE_PREFIX;
import static service.Randomizer.getRandomValue;
import static util.RandomUtil.randomBoolean;
import static util.RandomUtil.randomDigit;

/**
 * This class provides methods for generating random Polish phone numbers.
 */
public class Phone {

    private static final String PATH = "person/phone.yaml";

    @Getter
    @AllArgsConstructor
    enum PhoneKey implements Key {

        AREA_CODE("area-code"),
        MOBILE_PREFIX("mobile-prefix");

        private final String key;
    }

    /**
     * @return random 9-digit number, not following any specific pattern or format.
     */
    public String random() {
        return random(9);
    }

    /**
     * @return random landline phone number.
     */
    public String landline() {
        return getAreaCode() + random(7);
    }

    /**
     * @return random mobile phone number.
     */
    public String mobile() {
        return getMobilePrefix() + random(7);
    }

    /**
     * @return random phone number with +48 prefix.
     */
    public Plus48Phone plus48() {
        return new Plus48Phone();
    }

    private String random(int length) {
        return randomDigit(length);
    }

    private String getAreaCode() {
        return getRandomValue(PATH, AREA_CODE);
    }

    private String getMobilePrefix() {
        return getRandomValue(PATH, MOBILE_PREFIX);
    }

    /**
     * This class provides methods for generating random Polish phone numbers with +48 prefix.
     */
    public static class Plus48Phone extends Phone {

        private static final String PLUS_48 = "+48";

        @Override
        public String random() {
            return randomBoolean() ? landline() : mobile();
        }

        @Override
        public String landline() {
            return PLUS_48 + super.landline();
        }

        @Override
        public String mobile() {
            return PLUS_48 + super.mobile();
        }
    }
}
