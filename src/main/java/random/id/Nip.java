package random.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import static random.id.Nip.NipKey.DEPARTMENT;
import static service.RandomValueExtractor.getRandomValue;
import static util.RandomUtil.randomDigit;
import static util.RandomUtil.simpleCheckSum;

public class Nip {

    private static final int[] WEIGHTS = {6, 5, 7, 2, 3, 4, 5, 6, 7};

    /**
     * @return random NIP number
     */
    public String random() {
        return generateNip();
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

    @Getter
    @AllArgsConstructor
    enum NipKey implements Key {

        DEPARTMENT("department");

        private final String key;
    }
}
