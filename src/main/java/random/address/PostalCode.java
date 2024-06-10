package random.address;

import static util.RandomUtil.randomNumber;

/**
 * This class provides methods for generating random postal codes.
 */
public class PostalCode {

    /**
     * @return random postal code without format (XXXXX).
     */
    public String random() {
        return getPostalCode();
    }

    /**
     * @return random postal code with format "XX-XXX".
     */
    public String formatted() {
        return getPostalCode().substring(0, 2) + "-" + getPostalCode().substring(2);
    }

    private String getPostalCode() {
        return String.format("%05d", randomNumber() % 100000);
    }
}
