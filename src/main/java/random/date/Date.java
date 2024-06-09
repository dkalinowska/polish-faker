package random.date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

import static random.date.Date.DateKey.DAY;
import static random.date.Date.DateKey.MONTH;
import static service.RandomValueExtractor.getRandomValue;

public class Date {

    private static final String DD_MM_YYYY = "dd-MM-yyyy";
    private static final String START_DATE = "01-01-1900";
    private static final String END_DATE = eighteenYearsAgo();
    private static final String PATH = "date/date.yaml";

    /**
     * Default setting useful for generating dates of birth
     * @return random LocalDate in dd-MM-yyyy format between 01-01-1900 and 18 years ago
     */
    public static LocalDate randomDate() {
        return randomDate(START_DATE, END_DATE, DD_MM_YYYY);
    }

    /**
     * @param start start date in dd-MM-yyyy format
     * @param end end date in dd-MM-yyyy format
     * @return random LocalDate in dd-MM-yyyy format between given start and end dates
     */
    public static LocalDate randomDate(String start, String end) {
        return randomDate(start, end, DD_MM_YYYY);
    }

    /**
     * @param start date in given format
     * @param end date in given format
     * @param format of dates
     * @return random LocalDate in given format between start and end
     */
    public static LocalDate randomDate(String start, String end, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    /**
     * @return random day of week (Poniedziałek, Wtorek, ...)
     */
    public String dayOfWeek() {
        return getRandomValue(PATH, DAY);
    }

    /**
     * @return random month name (Styczeń, Luty, ...)
     */
    public String monthName() {
        return getRandomValue(PATH, MONTH);
    }

    private static String eighteenYearsAgo() {
        return LocalDate.now().minusYears(18).format(DateTimeFormatter.ofPattern(DD_MM_YYYY));
    }

    @Getter
    @AllArgsConstructor
    enum DateKey implements Key {

        DAY("day"),
        MONTH("month");

        private final String key;
    }
}
