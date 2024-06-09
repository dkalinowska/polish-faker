package service;

import random.address.Address;
import random.address.City;
import random.address.Country;
import random.address.Street;
import random.address.Voivodeship;
import random.id.Iban;
import random.id.Krs;
import random.id.MortgageRegister;
import random.id.Nip;
import random.id.Passport;
import random.id.PersonalId;
import random.id.Pesel;
import random.id.Regon;
import random.person.Email;
import random.person.Name;
import random.person.Phone;

public class Faker {

    private final Iban iban = new Iban();
    private final Krs krs = new Krs();
    private final MortgageRegister mortgageRegister = new MortgageRegister();
    private final Nip nip = new Nip();
    private final Passport passport = new Passport();
    private final PersonalId personalId = new PersonalId();
    private final Pesel pesel = new Pesel();
    private final Regon regon = new Regon();
    private final Address address = new Address();
    private final Street street = new Street();
    private final City city = new City();
    private final Voivodeship voivodeship = new Voivodeship();
    private final Country country = new Country();
    private final Name name = new Name();
    private final Email email = new Email();
    private final Phone phone = new Phone();

    public Iban iban() {
        return iban;
    }

    public Krs krs() {
        return krs;
    }

    public Nip nip() {
        return nip;
    }

    public Passport passport() {
        return passport;
    }

    public PersonalId personalId() {
        return personalId;
    }

    public Regon regon() {
        return regon;
    }

    public Name name() {
        return name;
    }


}
