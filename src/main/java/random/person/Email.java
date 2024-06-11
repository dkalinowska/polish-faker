package random.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import util.Key;

import java.text.Normalizer;

import static random.person.Email.EmailKey.SLD;
import static random.person.Email.EmailKey.TLD;
import static service.Randomizer.getRandomValue;
import static util.RandomUtil.randomBoolean;
import static util.RandomUtil.randomNumber;

/**
 * This class generates random email addresses.
 */
public class Email {

    private final Name nameGenerator = new Name();
    private static final String PATH = "person/email.yaml";

    @Getter
    @AllArgsConstructor
    enum EmailKey implements Key {

        TLD("tld"),
        SLD("sld");

        private final String key;
    }

    /**
     * @return email address based on given
     */
    public String basedOnName(String name) {
        return getRandomEmail(name);
    }

    /**
     * @return random email address
     */
    public String random() { return getRandomEmail(nameGenerator.funnyName().random()); }

    private String getRandomEmail(String name) {
        return getLocalPart(name) + "@" + getDomain();
    }

    private String getLocalPart(String name) {
        return removePolish(name)
                .replace(" ", ".")
                .toLowerCase()
                + "."
                + randomNumber(1000);
    }

    private String getDomain() {
        return getSecondLevelDomain() + "." + getTopLevelDomain();
    }

    private String getTopLevelDomain() {
        return (randomBoolean() ? getRandomValue(PATH, TLD) + "." : "") + getRandomValue(PATH, TLD);
    }

    private String getSecondLevelDomain() {
        return getRandomValue(PATH, SLD);
    }

    private static String removePolish(String s) {
        return Normalizer.normalize(s.replaceAll("ł", "l"), Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
