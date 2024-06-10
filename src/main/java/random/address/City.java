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
 * This class provides methods for generating random city names.
 */
public class City {

    private static final String PATH = "address/city.yaml";

    /**
     * @return random city name.
     */
    public String random() {
        return getRandomCity(FromVoivodeship.values()[randomNumber(FromVoivodeship.values().length)]);
    }

    /**
     * @return random city name from given voivodeship.
     */
    public CityFromVoivodeship fromVoivodeship() {
        return new CityFromVoivodeship();
    }

    private String getRandomCity(Key key) {
        return getRandomValue(PATH, key);
    }

    /**
     * This class provides methods for generating random city names from Polish voivodeships.
     */
    public class CityFromVoivodeship {

        /**
         * @return random city name from dolnośląskie voivodeship.
         */
        public String dolnoslaskie() {
            return getRandomCity(DOLNOSLASKIE);
        }

        /**
         * @return random city name from kujawsko-pomorskie voivodeship.
         */
        public String kujawskoPomorskie() {
            return getRandomCity(KUJAWSKO_POMORSKIE);
        }

        /**
         * @return random city name from lubelskie voivodeship.
         */
        public String lubelskie() {
            return getRandomCity(LUBELSKIE);
        }

        /**
         * @return random city name from lubuskie voivodeship.
         */
        public String lubuskie() {
            return getRandomCity(LUBUSKIE);
        }

        /**
         * @return random city name from łódzkie voivodeship.
         */
        public String lodzkie() {
            return getRandomCity(LODZKIE);
        }

        /**
         * @return random city name from małopolskie voivodeship.
         */
        public String malopolskie() {
            return getRandomCity(MALOPOLSKIE);
        }

        /**
         * @return random city name from mazowieckie voivodeship.
         */
        public String mazowieckie() {
            return getRandomCity(MAZOWIECKIE);
        }

        /**
         * @return random city name from opolskie voivodeship.
         */
        public String opolskie() {
            return getRandomCity(OPOLSKIE);
        }

        /**
         * @return random city name from podkarpackie voivodeship.
         */
        public String podkarpackie() {
            return getRandomCity(PODKARPACKIE);
        }

        /**
         * @return random city name from podlaskie voivodeship.
         */
        public String podlaskie() {
            return getRandomCity(PODLASKIE);
        }

        /**
         * @return random city name from pomorskie voivodeship.
         */
        public String pomorskie() {
            return getRandomCity(POMORSKIE);
        }

        /**
         * @return random city name from śląskie voivodeship.
         */
        public String slaskie() {
            return getRandomCity(SLASKIE);
        }

        /**
         * @return random city name from świętokrzyskie voivodeship.
         */
        public String swietokrzyskie() {
            return getRandomCity(SWIETOKRZYSKIE);
        }

        /**
         * @return random city name from warmińsko-mazurskie voivodeship.
         */
        public String warminskoMazurskie() {
            return getRandomCity(WARMINSKO_MAZURSKIE);
        }

        /**
         * @return random city name from wielkopolskie voivodeship.
         */
        public String wielkopolskie() {
            return getRandomCity(WIELKOPOLSKIE);
        }

        /**
         * @return random city name from zachodniopomorskie voivodeship.
         */
        public String zachodniopomorskie() {
            return getRandomCity(ZACHODNIOPOMORSKIE);
        }
    }
}
