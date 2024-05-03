package numbers;

import java.time.Year;
import java.util.Random;
import java.util.regex.Pattern;

public class Pesel {

    private final Random random = new Random();
    private final String pesel;
    private final String sex;

    public Pesel() {
        this.pesel = getRandomPesel();
        this.sex = calculateSexNumber(pesel);
    }

    public Pesel(String sex) {
        this.pesel = getRandomPesel(sex);
        this.sex = sex;
    }

//    public Pesel(String sex, Date date) {
//        this.pesel = getRandomPesel(sex, date);
//        this.sex = sex;
//        this.date = date;
//    }

    public String getRandomPesel() {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]{11}");


        return null;
    }

    public String getRandomPesel(String sex) {
        StringBuilder pesel = new StringBuilder();
        return null;
    }

    private String getMonthNumbers(Year year) {
        return null;
    }

    private static String calculateControlSum(String pesel) {
        int controlSum = getControlSumDigit(pesel, 0, 1)
                + getControlSumDigit(pesel, 1, 3)
                + getControlSumDigit(pesel, 2, 7)
                + getControlSumDigit(pesel, 3, 9)
                + getControlSumDigit(pesel, 4, 1)
                + getControlSumDigit(pesel, 5, 3)
                + getControlSumDigit(pesel, 6, 7)
                + getControlSumDigit(pesel, 7, 9)
                + getControlSumDigit(pesel, 8, 1)
                + getControlSumDigit(pesel, 9, 3);
        return String.valueOf(controlSum % 10);
    }

    private static String calculateSexNumber(String pesel) {
        return null;
    }

    private static int getControlSumDigit(String pesel, int index, int multiplier) {
        return ((int) pesel.charAt(index) * multiplier) % 10;
    }
}
