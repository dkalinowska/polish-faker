package random.id;

import java.util.Random;

import static util.RandomUtil.randomDigit;

public class PersonalId {

    private final String personalId;
    private final Random random = new Random();
    private final int[] controlSumWeights = {7, 3, 1, 7, 3, 1, 7, 3};

    public PersonalId() {
        this.personalId = generatePersonalId();
    }

    public String personalId() {
        return personalId;
    }

    private String generatePersonalId() {
        String personalId = getPersonalIdWithoutChecksum();
        return personalId.substring(0, 3) + calculateCheckSum(personalId) + personalId.substring(3);
    }

    private String getLetters() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append((char) random.nextInt(65, 91));
        }
        return stringBuilder.toString();
    }

    private String getNumbers() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(randomDigit());
        }
        return stringBuilder.toString();
    }

    private String getPersonalIdWithoutChecksum() {
        return getLetters() + getNumbers();
    }

    private String calculateCheckSum(String personalId) {
        String id = getPersonalIdWithoutChecksum();
        int sum = 0;
        for (int i = 0; i < id.length(); i++) {
            sum += controlSumWeights[i] * Integer.parseInt(String.valueOf(id.charAt(i)));
        }
        int checkSum = sum % 11;
        return checkSum == 10 ? "0" : String.valueOf(checkSum);
    }
}
