package random.person;

public class Name {

    public Name() {
    }

    public String getFemaleFirstName() {
        return "";
    }

    public enum Names {
        FEMALE_FIRST_NAME("female.first_name"),
        MALE_FIRST_NAME("male.first_name"),
        FEMALE_LAST_NAME("female.last_name"),
        MALE_LAST_NAME("male.last_name");

        Names(String name) {
        }
    }
}
