package random.address;

import util.Key;

import static random.address.FromVoivodeship.DOLNOSLASKIE;
import static random.address.FromVoivodeship.KUJAWSKO_POMORSKIE;
import static random.address.FromVoivodeship.LODZKIE;
import static random.address.FromVoivodeship.LUBELSKIE;
import static random.address.FromVoivodeship.LUBUSKIE;
import static random.address.FromVoivodeship.MALOPOLSKIE;
import static random.address.FromVoivodeship.MAZOWIECKIE;
import static random.address.FromVoivodeship.OPOLSKIE;
import static random.address.FromVoivodeship.PODKARPACKIE;
import static random.address.FromVoivodeship.PODLASKIE;
import static random.address.FromVoivodeship.POMORSKIE;
import static random.address.FromVoivodeship.SLASKIE;
import static random.address.FromVoivodeship.SWIETOKRZYSKIE;
import static random.address.FromVoivodeship.WARMINSKO_MAZURSKIE;
import static random.address.FromVoivodeship.WIELKOPOLSKIE;
import static random.address.FromVoivodeship.ZACHODNIOPOMORSKIE;
import static service.Randomizer.getRandomValue;
import static util.RandomUtil.randomNumber;

/**
 * This class provides methods for generating random county names.
 */
public class County {
    
    private static final String PATH = "address/county.yaml";

    /**
     * @return random county name.
     */
    public String random() {
        return getRandomCounty(FromVoivodeship.values()[randomNumber(FromVoivodeship.values().length)]);
    }

    /**
     * @return random county name from given voivodeship.
     */
    public CountyFromVoivodeship fromVoivodeship() {
        return new CountyFromVoivodeship();
    }
    
    private static String getRandomCounty(Key key) {
        return getRandomValue(PATH, key);
    }

    /**
     * This class provides methods for generating random county names from a specific voivodeship.
     */
    public static class CountyFromVoivodeship {

        /**
         * @return random county name from dolnośląskie voivodeship.
         */
        public String dolnoslaskie() {
            return getRandomCounty(DOLNOSLASKIE);
        }

        /**
         * @return random county name from kujawsko-pomorskie voivodeship.
         */
        public String kujawskoPomorskie() {
            return getRandomCounty(KUJAWSKO_POMORSKIE);
        }

        /**
         * @return random county name from lubelskie voivodeship.
         */
        public String lubelskie() {
            return getRandomCounty(LUBELSKIE);
        }

        /**
         * @return random county name from lubuskie voivodeship.
         */
        public String lubuskie() {
            return getRandomCounty(LUBUSKIE);
        }

        /**
         * @return random county name from łódzkie voivodeship.
         */
        public String lodzkie() {
            return getRandomCounty(LODZKIE);
        }

        /**
         * @return random county name from małopolskie voivodeship.
         */
        public String malopolskie() {
            return getRandomCounty(MALOPOLSKIE);
        }

        /**
         * @return random county name from mazowieckie voivodeship.
         */
        public String mazowieckie() {
            return getRandomCounty(MAZOWIECKIE);
        }

        /**
         * @return random county name from opolskie voivodeship.
         */
        public String opolskie() {
            return getRandomCounty(OPOLSKIE);
        }

        /**
         * @return random county name from podkarpackie voivodeship.
         */
        public String podkarpackie() {
            return getRandomCounty(PODKARPACKIE);
        }

        /**
         * @return random county name from podlaskie voivodeship.
         */
        public String podlaskie() {
            return getRandomCounty(PODLASKIE);
        }

        /**
         * @return random county name from pomorskie voivodeship.
         */
        public String pomorskie() {
            return getRandomCounty(POMORSKIE);
        }

        /**
         * @return random county name from śląskie voivodeship.
         */
        public String slaskie() {
            return getRandomCounty(SLASKIE);
        }

        /**
         * @return random county name from świętokrzyskie voivodeship.
         */
        public String swietokrzyskie() {
            return getRandomCounty(SWIETOKRZYSKIE);
        }

        /**
         * @return random county name from warmińsko-mazurskie voivodeship.
         */
        public String warminskoMazurskie() {
            return getRandomCounty(WARMINSKO_MAZURSKIE);
        }

        /**
         * @return random county name from wielkopolskie voivodeship.
         */
        public String wielkopolskie() {
            return getRandomCounty(WIELKOPOLSKIE);
        }

        /**
         * @return random county name from zachodniopomorskie voivodeship.
         */
        public String zachodniopomorskie() {
            return getRandomCounty(ZACHODNIOPOMORSKIE);
        }
    }
}
