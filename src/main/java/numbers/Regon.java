package numbers;

import static util.NumberUtil.nextDigit;
import static util.NumberUtil.simpleCheckSum;

public class Regon {

    private final String regon;
    private final int[] shortRegonWeights = {8, 9, 2, 3, 4, 5, 6, 7};
    private final int[] longRegonWeights = {2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8};

    public Regon() {
        this.regon = generateRegon();
    }

    public String regon() {
        return regon;
    }

    private String generateRegon() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(nextDigit());
        }
        return stringBuilder.toString() + calculateCheckSum(stringBuilder.toString());
    }

    private String calculateCheckSum(String regon) {
        int checkSum = simpleCheckSum(regon, shortRegonWeights);
        return checkSum == 10 ? "0" : String.valueOf(checkSum);
    }
}
