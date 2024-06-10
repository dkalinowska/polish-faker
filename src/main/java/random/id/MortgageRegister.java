package random.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import java.util.HashMap;
import java.util.Map;

import static random.id.MortgageRegister.CourtKey.COURT;
import static service.Randomizer.getRandomValue;
import static util.RandomUtil.randomNumber;

/**
 * This class generated random Polish mortgage register numbers.
 */
public class MortgageRegister {

    private static final String COURT_PATH = "id/court.yaml";
    private static final int[] WEIGHTS = {1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7};
    private static final Map<Character, Integer> CHAR_VALUE_MAP = getCharacterValueMap();

    @Getter
    @AllArgsConstructor
    enum CourtKey implements Key {

        COURT("court");

        private final String key;
    }

    /**
     * @return Polish mortgage register number for a random court
     */
    public String random() {
        return generateMortgageRegisterNumber();
    }

    private String generateMortgageRegisterNumber() {
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
        int sum = 0;
        for (int i = 0; i < mortgageRegisterNumber.length(); i++)
            sum += WEIGHTS[i] * CHAR_VALUE_MAP.get(mortgageRegisterNumber.charAt(i));
        return String.valueOf(sum % 10);
    }

    private static Map<Character, Integer> getCharacterValueMap() {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch = '0'; ch <= '9'; ch++) {
            map.put(ch, ch - '0');
        }
        map.put('X', 10);
        for (char ch = 'A'; ch <= 'W'; ch++) {
            map.put(ch, ch - 'A' + 11);
        }
        map.put('Y', 32);
        map.put('Z', 33);
        return map;
    }
}
