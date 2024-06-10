package random.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static random.person.Name.NameKey.FEMALE_FIRST_NAME;
import static random.person.Name.NameKey.FEMALE_FUNNY;
import static random.person.Name.NameKey.FEMALE_LAST_NAME;
import static random.person.Name.NameKey.MALE_FIRST_NAME;
import static random.person.Name.NameKey.MALE_FUNNY;
import static random.person.Name.NameKey.MALE_LAST_NAME;
import static service.Randomizer.getRandomValue;
import static util.RandomUtil.randomBoolean;

/**
 * Class for generating random Polish names.
 */
public class Name {

    private static final String PATH = "person/name.yaml";

    /**
     * Class for generating random first names
     */
    public static class FirstName {

        /**
         * @return random female first name
         */
        public String female() {
            return getRandomValue(PATH, FEMALE_FIRST_NAME);
        }

        /**
         * @return random male first name
         */
        public String male() {
            return getRandomValue(PATH, MALE_FIRST_NAME);
        }

        /**
         * @return random first name
         */
        public String random() {
            return randomBoolean() ? female() : male();
        }
    }

    /**
     * Class for generating random last names
     */
    public static class LastName {

        /**
         * @return random female last name
         */
        public String female() {
            return getRandomValue(PATH, FEMALE_LAST_NAME);
        }

        /**
         * @return random male last name
         */
        public String male() {
            return getRandomValue(PATH, MALE_LAST_NAME);
        }

        /**
         * @return random last name
         */
        public String random() {
            return randomBoolean() ? female() : male();
        }
    }

    /**
     * Class for generating random funny full names
     * (e.g. names from movies, TV series, cartoons, etc.)
     */
    public static class FunnyName {

        /**
         * @return random funny female full name
         */
        public String female() {
            return getRandomValue(PATH, FEMALE_FUNNY);
        }

        /**
         * @return random funny male full name
         */
        public String male() {
            return getRandomValue(PATH, MALE_FUNNY);
        }

        /**
         * @return random funny full name
         */
        public String random() {
            return randomBoolean() ? female() : male();
        }
    }

    /**
     * @return instance of {@link FirstName}, a class for generating first names
     */
    public FirstName firstName() {
        return new FirstName();
    }

    /**
     * @return instance of {@link LastName}, a class for generating last names
     */
    public LastName lastName() {
        return new LastName();
    }

    /**
     * @return instance of {@link FunnyName}, a class for generating funny full names
     */
    public FunnyName funnyName() {
        return new FunnyName();
    }

    @Getter
    @AllArgsConstructor
    public enum NameKey implements Key {

        FEMALE_FIRST_NAME("female-first"),
        MALE_FIRST_NAME("male-first"),
        FEMALE_LAST_NAME("female-last"),
        MALE_LAST_NAME("male-last"),
        FEMALE_FUNNY("female-funny"),
        MALE_FUNNY("male-funny");

        private final String key;
    }
}
