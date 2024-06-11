package random.word;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static random.word.Food.FoodKey.BEVERAGE;
import static random.word.Food.FoodKey.CONDIMENT;
import static random.word.Food.FoodKey.DAIRY;
import static random.word.Food.FoodKey.DISH;
import static random.word.Food.FoodKey.FRUIT;
import static random.word.Food.FoodKey.GRAIN;
import static random.word.Food.FoodKey.MEAT;
import static random.word.Food.FoodKey.SEAFOOD;
import static random.word.Food.FoodKey.SPICE;
import static random.word.Food.FoodKey.SWEET;
import static random.word.Food.FoodKey.VEGETABLE;
import static service.Randomizer.getRandomValue;
import static util.RandomUtil.randomNumber;

/**
 * This class provides methods for generating random food names.
 */
public class Food {

    private static final String PATH = "word/food.yaml";

    @Getter
    @AllArgsConstructor
    enum FoodKey implements Key {

        FRUIT("fruit"),
        VEGETABLE("vegetable"),
        GRAIN("grain"),
        MEAT("meat"),
        SEAFOOD("seafood"),
        DAIRY("dairy"),
        BEVERAGE("beverage"),
        SWEET("sweet"),
        SPICE("spice"),
        CONDIMENT("condiment"),
        DISH("dish");

        private final String key;
    }

    /**
     * @return random food name.
     */
    public String random() {
        return getRandomFood(FoodKey.values()[randomNumber(FoodKey.values().length)]);
    }

    /**
     * @return food name of a specified kind (fruit, vegetable etc.).
     */
    public FoodOfType ofType() {
        return new FoodOfType();
    }

    private static String getRandomFood(Key key) {
        return getRandomValue(PATH, key);
    }

    /**
     * This class provides methods for generating random food names of a specified kind.
     */
    public static class FoodOfType {

        /**
         * @return a fruit name
         */
        public String fruit() {
            return getRandomFood(FRUIT);
        }

        /**
         * @return a vegetable name
         */
        public String vegetable() {
            return getRandomFood(VEGETABLE);
        }

        /**
         * @return a grain name
         */
        public String grain() {
            return getRandomFood(GRAIN);
        }

        /**
         * @return a meat name
         */
        public String meat() {
            return getRandomFood(MEAT);
        }

        /**
         * @return a seafood name
         */
        public String seafood() {
            return getRandomFood(SEAFOOD);
        }

        /**
         * @return a dairy name
         */
        public String dairy() {
            return getRandomFood(DAIRY);
        }

        /**
         * @return a beverage name
         */
        public String beverage() {
            return getRandomFood(BEVERAGE);
        }

        /**
         * @return a sweet name
         */
        public String sweet() {
            return getRandomFood(SWEET);
        }

        /**
         * @return a spice name
         */
        public String spice() {
            return getRandomFood(SPICE);
        }

        /**
         * @return a condiment name
         */
        public String condiment() {
            return getRandomFood(CONDIMENT);
        }

        /**
         * @return a dish name
         */
        public String dish() {
            return getRandomFood(DISH);
        }
    }
}
