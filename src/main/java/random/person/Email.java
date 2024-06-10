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

    private final Name name = new Name();
    private static final String PATH = "person/email.yaml";

    @Getter
    @AllArgsConstructor
    enum EmailKey implements Key {

        TLD("tld"),
        SLD("sld");

        private final String key;
    }

    /**
     * @return random email address
     */
    public String random() {
        return getRandomEmail();
    }

    private String getRandomEmail() {
        return getRandomLocalPart() + "@" + getRandomDomain();
    }

    private String getRandomLocalPart() {
        return removePolish(name.funnyName().random())
                .replace(" ", ".")
                .toLowerCase()
                + "."
                + randomNumber(1000);
    }

    private String getRandomDomain() {
        return getRandomSld() + "." + getRandomTld();
    }

    private String getRandomTld() {
        return (randomBoolean() ? getRandomValue(PATH, TLD) + "." : "") + getRandomValue(PATH, TLD);
    }

    private String getRandomSld() {
        return getRandomValue(PATH, SLD);
    }

    private static String removePolish(String s) {
        return Normalizer.normalize(s.replaceAll("ł", "l"), Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
