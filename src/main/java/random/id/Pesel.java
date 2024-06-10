package random.id;

import random.date.Date;
import random.person.Sex;

import java.time.LocalDate;

import static random.person.Sex.FEMALE;
import static random.person.Sex.MALE;
import static util.RandomUtil.randomNumber;
import static util.RandomUtil.randomSex;

/**
 * Class for generating random PESEL numbers
 */
public class Pesel {

    private final Date randomDate = new Date();
    private static final int[] WEIGHTS = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

    /**
     * @return random PESEL number
     */
    public String random() {
        return getRandomPesel(randomSex());
    }

    /**
     * @return random PESEL number for a female
     */
    public String female() {
        return getRandomPesel(FEMALE);
    }

    /**
     * @return random PESEL number for a male
     */
    public String male() {
        return getRandomPesel(MALE);
    }

    private String getRandomPesel(Sex sex) {
        StringBuilder pesel = new StringBuilder();
        LocalDate date = randomDate.randomDate();

        pesel.append(String.format("%02d", date.getYear() % 100));
        pesel.append(getMonth(date));
        pesel.append(String.format("%02d", date.getDayOfMonth()));
        pesel.append(getSexNumber(sex));
        pesel.append(calculateCheckSum(pesel.toString()));

        return pesel.toString();
    }

    private String getMonth(LocalDate date) {
        int year = date.getYear();
        int offset = switch (year / 100) {
            case 18 -> 80;
            case 19 -> 0;
            case 20 -> 20;
            case 21 -> 40;
            case 22 -> 60;
            default -> throw new IllegalArgumentException("Year + " + year + " out of range 1800-2299");
        };
        return String.format("%02d", date.getMonthValue() + offset);
    }

    private String getSexNumber(Sex sex) {
        int sexNumber = randomNumber(5000) * 2;
        if (sex == MALE)
            sexNumber += 1;
        return String.format("%04d", sexNumber);
    }

    private String calculateCheckSum(String pesel) {
        int sum = 0;
        for (int i = 0; i < pesel.length(); i++)
            sum += WEIGHTS[i] * Integer.parseInt(String.valueOf(pesel.charAt(i)));
        sum %= 10;
        return String.valueOf((10 - sum) % 10);
    }
}
