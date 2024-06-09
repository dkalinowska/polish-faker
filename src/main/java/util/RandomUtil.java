package util;

import random.person.Sex;

import java.util.Random;

import static random.person.Sex.FEMALE;
import static random.person.Sex.MALE;

public class RandomUtil {

    private final static Random random = new Random();

    public static int randomDigit() {
        return random.nextInt(0, 10);
    }

    public static int randomNumber(int max) {
        return random.nextInt(0, max);
    }

    public static int randomNumber() {
        return random.nextInt() & Integer.MAX_VALUE;
    }

    public static char randomCapitalLetter() {
        return (char) random.nextInt(65, 91);
    }

    public static String randomCapitalLetter(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++)
            stringBuilder.append(randomCapitalLetter());
        return stringBuilder.toString();
    }

    public static char randomSmallLetter() {
        return (char) random.nextInt(97, 123);
    }

    public static String randomSmallLetter(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++)
            stringBuilder.append(randomSmallLetter());
        return stringBuilder.toString();
    }

    public static String simpleCheckSum(String id, int[] weights) {
        int sum = 0;
        for (int i = 0; i < id.length(); i++)
            sum += weights[i] * Integer.parseInt(String.valueOf(id.charAt(i)));
        sum %= 11;
        return sum == 10 ? String.valueOf(0) : String.valueOf(sum);
    }

    public static Sex randomSex() {
        boolean isMale = random.nextBoolean();
        return isMale ? MALE : FEMALE;
    }

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }
}
