package service;

import random.address.City;
import random.address.Country;
import random.address.County;
import random.address.PostalCode;
import random.address.Street;
import random.address.Voivodeship;
import random.date.Date;
import random.id.Krs;
import random.id.MortgageRegister;
import random.id.Nip;
import random.id.PersonalId;
import random.id.Pesel;
import random.id.Regon;
import random.person.Email;
import random.person.Name;
import random.person.Phone;
import random.word.Animal;
import random.word.Food;
import random.word.Plant;

/**
 * Faker is a class of which you should create an instance in your project in order to generate random data.
 */
public class Faker {

    private static volatile Faker instance;

    private Faker() {}

    private final Krs krs = new Krs();
    private final MortgageRegister mortgageRegister = new MortgageRegister();
    private final Nip nip = new Nip();
    private final PersonalId personalId = new PersonalId();
    private final Pesel pesel = new Pesel();
    private final Regon regon = new Regon();
    private final Date date = new Date();
    private final Street street = new Street();
    private final PostalCode postalCode = new PostalCode();
    private final City city = new City();
    private final County county = new County();
    private final Voivodeship voivodeship = new Voivodeship();
    private final Country country = new Country();
    private final Name name = new Name();
    private final Email email = new Email();
    private final Phone phone = new Phone();
    private final Animal animal = new Animal();
    private final Food food = new Food();
    private final Plant plant = new Plant();

    /**
     * @return instance of Faker class.
     */
    public static Faker getInstance() {
        if (instance == null) {
            synchronized (Faker.class) {
                if (instance == null) {
                    instance = new Faker();
                }
            }
        }
        return instance;
    }

    public Krs krs() {
        return krs;
    }

    public MortgageRegister mortgageRegister() {
        return mortgageRegister;
    }

    public Nip nip() {
        return nip;
    }

    public PersonalId personalId() {
        return personalId;
    }

    public Pesel pesel() {
        return pesel;
    }

    public Regon regon() {
        return regon;
    }

    public Date date() {
        return date;
    }

    public Street street() {
        return street;
    }

    public PostalCode postalCode() {
        return postalCode;
    }

    public City city() {
        return city;
    }

    public County county() {
        return county;
    }

    public Voivodeship voivodeship() {
        return voivodeship;
    }

    public Country country() {
        return country;
    }

    public Name name() {
        return name;
    }

    public Email email() {
        return email;
    }

    public Phone phone() {
        return phone;
    }

    public Animal animal() {
        return animal;
    }

    public Food food() {
        return food;
    }

    public Plant plant() {
        return plant;
    }
}
