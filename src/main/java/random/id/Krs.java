package random.id;

import static util.RandomUtil.randomDigit;
import static util.RandomUtil.simpleCheckSum;

public class Krs {

    private static final int[] WEIGHTS = {6, 5, 7, 2, 3, 4, 5, 6, 7};

    public String random() {
        StringBuilder krs = new StringBuilder();
        for (int i = 0; i < 9; i++)
            krs.append(randomDigit());
        return krs + simpleCheckSum(krs.toString(), WEIGHTS);
    }
}
