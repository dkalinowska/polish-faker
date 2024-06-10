package random.id;

import java.util.HashMap;
import java.util.Map;

import static util.RandomUtil.randomCapitalLetter;
import static util.RandomUtil.randomDigit;

/**
 * Class which generates random personal identification numbers.
 */
public class PersonalId {

    private static final int[] WEIGHTS = {7, 3, 1, 7, 3, 1, 7, 3};
    private static final Map<Character, Integer> CHAR_VALUE_MAP = getCharacterValueMap();

    /**
     * @return random personal identification number.
     */
    public String random() {
        return personalId();
    }

    private String personalId() {
        String id = randomCapitalLetter(3) + randomDigit(5);
        return id.substring(0, 3) + calculateCheckSum(id) + id.substring(3);
    }

    private String calculateCheckSum(String id) {
        int sum = 0;
        for (int i = 0; i < id.length(); i++)
            sum += WEIGHTS[i] * CHAR_VALUE_MAP.get(id.charAt(i));
        return String.valueOf(sum % 10);
    }

    private static Map<Character, Integer> getCharacterValueMap() {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch = '0'; ch <= 'Z'; ch++) {
            map.put(ch, ch <= '9' ? ch - '0' : ch - 'A' + 10);
        }
        return map;
    }
}
