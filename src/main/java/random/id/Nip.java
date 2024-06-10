package random.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static random.id.Nip.NipKey.DEPARTMENT;
import static service.Randomizer.getRandomValue;
import static util.RandomUtil.randomDigit;
import static util.RandomUtil.simpleCheckSum;

/**
 * This class generates random NIP numbers
 */
public class Nip {

    private static final int[] WEIGHTS = {6, 5, 7, 2, 3, 4, 5, 6, 7};

    @Getter
    @AllArgsConstructor
    enum NipKey implements Key {

        DEPARTMENT("department");

        private final String key;
    }

    /**
     * @return random NIP number without any formatting
     */
    public String random() {
        return generateNip();
    }

    /**
     * @return random NIP number with format "XXX-XXX-XX-XX"
     */
    public String formatted() {
        String nip = generateNip();
        return nip.substring(0, 3) + "-" + nip.substring(3, 6) + "-" + nip.substring(6, 8) + "-" + nip.substring(8);
    }

    private String generateNip() {
        StringBuilder nip = new StringBuilder();
        nip.append(getRandomDepartmentCode());
        for (int i = 0; i < 6; i++)
            nip.append(randomDigit());
        nip.append(simpleCheckSum(nip.toString(), WEIGHTS));
        return nip.toString();
    }

    private String getRandomDepartmentCode() {
        return getRandomValue("id/nip.yaml", DEPARTMENT);
    }
}
