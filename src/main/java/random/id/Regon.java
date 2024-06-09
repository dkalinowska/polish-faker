package random.id;

import static util.RandomUtil.randomBoolean;
import static util.RandomUtil.randomDigit;
import static util.RandomUtil.simpleCheckSum;

/**
 * Class for generating random REGON numbers.
 */
public class Regon {

    private static final int[] SHORT_REGON_WEIGHTS = {8, 9, 2, 3, 4, 5, 6, 7};
    private static final int[] LONG_REGON_WEIGHTS = {2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8};

    /**
     * @return random REGON number of 9 or 14 digits
     */
    public String random() {
        return randomBoolean() ? longRegon() : shortRegon();
    }

    /**
     * @return random REGON number of 9 digits
     */
    public String shortRegon() {
        StringBuilder regon = new StringBuilder();
        for (int i = 0; i < 8; i++)
            regon.append(randomDigit());
        return regon + simpleCheckSum(regon.toString(), SHORT_REGON_WEIGHTS);
    }

    /**
     * @return random REGON number of 14 digits
     */
    public String longRegon() {
        StringBuilder regon = new StringBuilder();
        regon.append(shortRegon());
        for (int i = 0; i < 4; i++)
            regon.append(randomDigit());
        return regon + simpleCheckSum(regon.toString(), LONG_REGON_WEIGHTS);
    }
}
