package random.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import java.util.Map;

import static random.id.MortgageRegister.CourtKey.COURT;
import static service.RandomValueExtractor.getRandomValue;
import static util.RandomUtil.randomNumber;

public class MortgageRegister {

    private static final String COURT_PATH = "id/court.yaml";
    private static final int[] WEIGHTS = {1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7};

    /**
     * @return Polish mortgage register number for a random court
     */
    public static String generateMortgageRegisterNumber() {
        StringBuilder mortgageRegisterNumber = new StringBuilder();
        mortgageRegisterNumber.append(getCourtCode());
        mortgageRegisterNumber.append(String.format("%08d", randomNumber(100000000)));
        mortgageRegisterNumber.append(calculateCheckSum(String.valueOf(mortgageRegisterNumber)));
        mortgageRegisterNumber.insert(4, '/').insert(13, '/');
        return mortgageRegisterNumber.toString();
    }

    private static String getCourtCode() {
        return getRandomValue(COURT_PATH, COURT);
    }

    private static String calculateCheckSum(String mortgageRegisterNumber) {
        Integer[] characterValues = getCharacterValues(mortgageRegisterNumber);
        int sum = 0;
        for (int i = 0; i < characterValues.length; i++)
            sum += WEIGHTS[i] * characterValues[i];
        return String.valueOf(sum % 10);
    }

    private static Integer[] getCharacterValues(String mortgageRegisterNumber) {
        Map<Character, Integer> map = getCharacterValueMap();
        Integer[] characterValues = new Integer[12];

        for (int i = 0; i < mortgageRegisterNumber.length(); i++)
            characterValues[i] = map.get(mortgageRegisterNumber.charAt(i));

        return characterValues;
    }

    private static Map<Character, Integer> getCharacterValueMap() {
        return Map.ofEntries(
                Map.entry('0', 0),
                Map.entry('1', 1),
                Map.entry('2', 2),
                Map.entry('3', 3),
                Map.entry('4', 4),
                Map.entry('5', 5),
                Map.entry('6', 6),
                Map.entry('7', 7),
                Map.entry('8', 8),
                Map.entry('9', 9),
                Map.entry('X', 10),
                Map.entry('A', 11),
                Map.entry('B', 12),
                Map.entry('C', 13),
                Map.entry('D', 14),
                Map.entry('E', 15),
                Map.entry('F', 16),
                Map.entry('G', 17),
                Map.entry('H', 18),
                Map.entry('I', 19),
                Map.entry('J', 20),
                Map.entry('K', 21),
                Map.entry('L', 22),
                Map.entry('M', 23),
                Map.entry('N', 24),
                Map.entry('O', 25),
                Map.entry('P', 26),
                Map.entry('R', 27),
                Map.entry('S', 28),
                Map.entry('T', 29),
                Map.entry('U', 30),
                Map.entry('W', 31),
                Map.entry('Y', 32),
                Map.entry('Z', 33)
        );
    }

    @Getter
    @AllArgsConstructor
    enum CourtKey implements Key {

        COURT("court");

        private final String key;
    }
}
