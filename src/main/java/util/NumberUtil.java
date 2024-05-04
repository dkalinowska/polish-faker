package util;

import java.util.Random;

public class NumberUtil {

    private final static Random random = new Random();

    public static int nextDigit() {
        return random.nextInt(0, 9);
    }
}
