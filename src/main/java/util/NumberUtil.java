package util;

import java.util.Random;

public class NumberUtil {

    private final static Random random = new Random();

    public static int nextDigit() {
        return random.nextInt(0, 10);
    }

    public static int simpleCheckSum(String id, int[] weights) {
        int sum = 0;
        for (int i = 0; i < id.length(); i++)
            sum += weights[i] * Integer.parseInt(String.valueOf(id.charAt(i)));
        return sum % 11;
    }
}
