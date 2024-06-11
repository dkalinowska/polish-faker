package random.word;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static random.word.Plant.PlantKey.ALGAE;
import static random.word.Plant.PlantKey.FERN;
import static random.word.Plant.PlantKey.FLOWER;
import static random.word.Plant.PlantKey.GRASS;
import static random.word.Plant.PlantKey.MOSS;
import static random.word.Plant.PlantKey.SHRUB;
import static random.word.Plant.PlantKey.TREE;
import static service.Randomizer.getRandomValue;
import static util.RandomUtil.randomNumber;

/**
 * This class provides methods for generating random plant names.
 */
public class Plant {

    private static final String PATH = "word/plant.yaml";

    @Getter
    @AllArgsConstructor
    enum PlantKey implements Key {

        FLOWER("flower"),
        TREE("tree"),
        SHRUB("shrub"),
        GRASS("grass"),
        FERN("fern"),
        MOSS("moss"),
        ALGAE("algae");

        private final String key;
    }

    /**
     * @return random plant name.
     */
    public String random() {
        return getRandomPlant(PlantKey.values()[randomNumber(PlantKey.values().length)]);
    }

    /**
     * @return plant name of a specified kind (flower, tree etc.).
     */
    public PlantFromGroup fromGroup() {
        return new PlantFromGroup();
    }

    private static String getRandomPlant(PlantKey plantKey) {
        return getRandomValue(PATH, plantKey);
    }

    /**
     * Class for generating plants from a given group.
     */
    public static class PlantFromGroup {

        /**
         * @return name of a flower.
         */
        public String flower() {
            return getRandomPlant(FLOWER);
        }

        /**
         * @return name of a tree.
         */
        public String tree() {
            return getRandomPlant(TREE);
        }

        /**
         * @return name of a shrub.
         */
        public String shrub() {
            return getRandomPlant(SHRUB);
        }

        /**
         * @return name of a grass.
         */
        public String grass() {
            return getRandomPlant(GRASS);
        }

        /**
         * @return name of a fern.
         */
        public String fern() {
            return getRandomPlant(FERN);
        }

        /**
         * @return name of a moss.
         */
        public String moss() {
            return getRandomPlant(MOSS);
        }

        /**
         * @return name of an algae.
         */
        public String algae() {
            return getRandomPlant(ALGAE);
        }
    }
}
