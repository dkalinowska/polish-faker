package random;

import java.util.Random;

import static util.NumberUtil.nextDigit;

public class Nip {

    private final String nip;
    private final Random random = new Random();
    private static final int NIP_LENGTH = 10;
    private static final int[] CONTROL_SUM_WEIGHTS = {6, 5, 7, 2, 3, 4, 5, 6, 7};

    public Nip() {
        this.nip = getRandomNip();
    }

    private String getRandomNip() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < NIP_LENGTH - 1; i++) {
            stringBuilder.append(nextDigit());
        }
        return nip;
    }

    private String calculateControlSum(String nip) {
        int controlSum = 0;
        for (int i = 0; i < nip.length(); i++) {
            controlSum += Character.getNumericValue(nip.charAt(i)) * CONTROL_SUM_WEIGHTS[i];
        }
        controlSum %= 11;
        return controlSum == 10 ? "0" : String.valueOf(controlSum);
    }

    private String getRandomDepartmentCode() {
        return null;
    }
}
