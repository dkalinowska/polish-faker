package random.word;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static random.word.Animal.AnimalKey.AMPHIBIAN;
import static random.word.Animal.AnimalKey.BIRD;
import static random.word.Animal.AnimalKey.FISH;
import static random.word.Animal.AnimalKey.INSECT;
import static random.word.Animal.AnimalKey.MAMMAL;
import static random.word.Animal.AnimalKey.MOLLUSK;
import static random.word.Animal.AnimalKey.REPTILE;
import static service.Randomizer.getRandomValue;
import static util.RandomUtil.randomNumber;

/**
 * This class provides methods for generating random animal names.
 */
public class Animal {

    private static final String PATH = "word/animal.yaml";

    @Getter
    @AllArgsConstructor
    enum AnimalKey implements Key {

        MAMMAL("mammal"),
        BIRD("bird"),
        REPTILE("reptile"),
        AMPHIBIAN("amphibian"),
        FISH("fish"),
        INSECT("insect"),
        MOLLUSK("mollusk");

        private final String key;
    }

    /**
     * @return random animal name.
     */
    public String random() {
        return getRandomAnimal(AnimalKey.values()[randomNumber(AnimalKey.values().length)]);
    }

    /**
     * @return animal name of a specified kind (mammal, bird etc.).
     */
    public AnimalFromGroup fromGroup() {
        return new AnimalFromGroup();
    }

    private static String getRandomAnimal(AnimalKey animalKey) {
        return getRandomValue(PATH, animalKey);
    }

    /**
     * This class provides methods for generating random animal names from selected groups.
     */
    public static class AnimalFromGroup {

        public String mammal() {
            return getRandomAnimal(MAMMAL);
        }

        public String bird() {
            return getRandomAnimal(BIRD);
        }

        public String reptile() {
            return getRandomAnimal(REPTILE);
        }

        public String amphibian() {
            return getRandomAnimal(AMPHIBIAN);
        }

        public String fish() {
            return getRandomAnimal(FISH);
        }

        public String insect() {
            return getRandomAnimal(INSECT);
        }

        public String mollusk() {
            return getRandomAnimal(MOLLUSK);
        }
    }
}
