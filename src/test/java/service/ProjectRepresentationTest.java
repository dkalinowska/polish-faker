package service;

import org.junit.jupiter.api.Test;

/**
 * This test class only serves as a visual representation of what the project can do, it's not a test.
 */
public class ProjectRepresentationTest {

    private static final Faker FAKER = Faker.getInstance();

    @Test
    public void krsRepresentation() {
        System.out.print("KRS: ");
        System.out.println(FAKER.krs().random());
    }

    @Test
    public void mortgageRegisterRepresentation() {
        System.out.print("Numer księgi wieczystej: ");
        System.out.println(FAKER.mortgageRegister().random());
    }

    @Test
    public void nipRepresentation() {
        System.out.print("NIP (bez formatowania): ");
        System.out.println(FAKER.nip().random());
        System.out.print("NIP (z formatowaniem): ");
        System.out.println(FAKER.nip().formatted());
    }

    @Test
    public void personalIdRepresentation() {
        System.out.print("Numer dowodu osobistego: ");
        System.out.println(FAKER.personalId().random());
    }

    @Test
    public void peselRepresentation() {
        System.out.print("PESEL (losowy): ");
        System.out.println(FAKER.pesel().random());
        System.out.print("PESEL (dla kobiety): ");
        System.out.println(FAKER.pesel().female());
        System.out.print("PESEL (dla mężczyzny): ");
        System.out.println(FAKER.pesel().male());
    }

    @Test
    public void regonRepresentation() {
        System.out.print("REGON (losowy): ");
        System.out.println(FAKER.regon().random());
        System.out.print("REGON (9 cyfr): ");
        System.out.println(FAKER.regon().shortRegon());
        System.out.print("REGON (14 cyfr): ");
        System.out.println(FAKER.regon().longRegon());
    }

    @Test
    public void dateRepresentation() {
        System.out.print("Data (losowa): ");
        System.out.println(FAKER.date().random());
        System.out.print("Data (z zakresu): ");
        System.out.println(FAKER.date().between("01-01-2020", "31-12-2020"));
        System.out.print("Dzień tygodnia: ");
        System.out.println(FAKER.date().dayOfWeek());
        System.out.print("Nazwa miesiąca: ");
        System.out.println(FAKER.date().monthName());
    }

    @Test
    public void streetRepresentation() {
        System.out.print("Ulica (losowa): ");
        System.out.println(FAKER.street().random());
        System.out.print("Ulica (bazowana na nazwisku): ");
        System.out.println(FAKER.street().basedOn().surname());
        System.out.print("Ulica (bazowana na przymiotniku): ");
        System.out.println(FAKER.street().basedOn().adjective());
        System.out.print("Ulica (bazowana na bajce): ");
        System.out.println(FAKER.street().basedOn().fairytale());
        System.out.print("Ulica (bazowana na miejscu): ");
        System.out.println(FAKER.street().basedOn().place());
        System.out.print("Ulica (bazowana na geografii): ");
        System.out.println(FAKER.street().basedOn().geography());
        System.out.print("Ulica (bazowana na historii): ");
        System.out.println(FAKER.street().basedOn().history());
        System.out.print("Ulica (bazowana na przyrodzie): ");
        System.out.println(FAKER.street().basedOn().nature());
    }

    @Test
    public void postalCodeRepresentation() {
        System.out.print("Kod pocztowy (bez formatowania): ");
        System.out.println(FAKER.postalCode().random());
        System.out.print("Kod pocztowy (z formatowaniem): ");
        System.out.println(FAKER.postalCode().formatted());
    }

    @Test
    public void cityRepresentation() {
        System.out.print("Miasto (losowe): ");
        System.out.println(FAKER.city().random());
        System.out.print("Miasto (z województwa dolnośląskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().dolnoslaskie());
        System.out.print("Miasto (z województwa kujawsko-pomorskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().kujawskoPomorskie());
        System.out.print("Miasto (z województwa lubelskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().lubelskie());
        System.out.print("Miasto (z województwa lubuskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().lubuskie());
        System.out.print("Miasto (z województwa łódzkiego): ");
        System.out.println(FAKER.city().fromVoivodeship().lodzkie());
        System.out.print("Miasto (z województwa małopolskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().malopolskie());
        System.out.print("Miasto (z województwa mazowieckiego): ");
        System.out.println(FAKER.city().fromVoivodeship().mazowieckie());
        System.out.print("Miasto (z województwa opolskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().opolskie());
        System.out.print("Miasto (z województwa podkarpackiego): ");
        System.out.println(FAKER.city().fromVoivodeship().podkarpackie());
        System.out.print("Miasto (z województwa podlaskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().podlaskie());
        System.out.print("Miasto (z województwa pomorskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().pomorskie());
        System.out.print("Miasto (z województwa śląskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().slaskie());
        System.out.print("Miasto (z województwa świętokrzyskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().swietokrzyskie());
        System.out.print("Miasto (z województwa warmińsko-mazurskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().warminskoMazurskie());
        System.out.print("Miasto (z województwa wielkopolskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().wielkopolskie());
        System.out.print("Miasto (z województwa zachodniopomorskiego): ");
        System.out.println(FAKER.city().fromVoivodeship().zachodniopomorskie());
    }

    @Test
    public void countyRepresentation() {
        System.out.print("Powiat (losowy): ");
        System.out.println(FAKER.county().random());
        System.out.print("Powiat (z województwa dolnośląskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().dolnoslaskie());
        System.out.print("Powiat (z województwa kujawsko-pomorskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().kujawskoPomorskie());
        System.out.print("Powiat (z województwa lubelskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().lubelskie());
        System.out.print("Powiat (z województwa lubuskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().lubuskie());
        System.out.print("Powiat (z województwa łódzkiego): ");
        System.out.println(FAKER.county().fromVoivodeship().lodzkie());
        System.out.print("Powiat (z województwa małopolskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().malopolskie());
        System.out.print("Powiat (z województwa mazowieckiego): ");
        System.out.println(FAKER.county().fromVoivodeship().mazowieckie());
        System.out.print("Powiat (z województwa opolskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().opolskie());
        System.out.print("Powiat (z województwa podkarpackiego): ");
        System.out.println(FAKER.county().fromVoivodeship().podkarpackie());
        System.out.print("Powiat (z województwa podlaskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().podlaskie());
        System.out.print("Powiat (z województwa pomorskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().pomorskie());
        System.out.print("Powiat (z województwa śląskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().slaskie());
        System.out.print("Powiat (z województwa świętokrzyskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().swietokrzyskie());
        System.out.print("Powiat (z województwa warmińsko-mazurskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().warminskoMazurskie());
        System.out.print("Powiat (z województwa wielkopolskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().wielkopolskie());
        System.out.print("Powiat (z województwa zachodniopomorskiego): ");
        System.out.println(FAKER.county().fromVoivodeship().zachodniopomorskie());
    }

    @Test
    public void voivodeshipRepresentation() {
        System.out.print("Województwo (losowe): ");
        System.out.println(FAKER.voivodeship().random());
    }

    @Test
    public void countryRepresentation() {
        System.out.print("Kraj (losowy): ");
        System.out.println(FAKER.country().random());
        System.out.print("Kraj (z Europy): ");
        System.out.println(FAKER.country().fromContinent().europe());
        System.out.print("Kraj (z Azji): ");
        System.out.println(FAKER.country().fromContinent().asia());
        System.out.print("Kraj (z Afryki): ");
        System.out.println(FAKER.country().fromContinent().africa());
        System.out.print("Kraj (z Ameryki Północnej): ");
        System.out.println(FAKER.country().fromContinent().northAmerica());
        System.out.print("Kraj (z Ameryki Południowej): ");
        System.out.println(FAKER.country().fromContinent().southAmerica());
        System.out.print("Kraj (z Oceanii): ");
        System.out.println(FAKER.country().fromContinent().oceania());
    }

    @Test
    public void nameRepresentation() {
        System.out.print("Imię (żeńskie): ");
        System.out.println(FAKER.name().firstName().female());
        System.out.print("Imię (męskie): ");
        System.out.println(FAKER.name().firstName().male());
        System.out.print("Imię (losowe): ");
        System.out.println(FAKER.name().firstName().random());
        System.out.print("Nazwisko (żeńskie): ");
        System.out.println(FAKER.name().lastName().female());
        System.out.print("Nazwisko (męskie): ");
        System.out.println(FAKER.name().lastName().male());
        System.out.print("Nazwisko (losowe): ");
        System.out.println(FAKER.name().lastName().random());
        System.out.print("Imię i nazwisko z kultury (żeńskie): ");
        System.out.println(FAKER.name().funnyName().female());
        System.out.print("Imię i nazwisko z kultury (męskie): ");
        System.out.println(FAKER.name().funnyName().male());
        System.out.print("Imię i nazwisko z kultury (losowe): ");
        System.out.println(FAKER.name().funnyName().random());
    }

    @Test
    public void emailRepresentation() {
        System.out.print("Email (bazowany na imieniu): ");
        System.out.println(FAKER.email().basedOnName("Jan Kowalski"));
        System.out.print("Email (losowy): ");
        System.out.println(FAKER.email().random());
    }

    @Test
    public void phoneRepresentation() {
        System.out.print("Numer telefonu (kompletnie losowy): ");
        System.out.println(FAKER.phone().random());
        System.out.print("Numer telefonu (stacjonarny): ");
        System.out.println(FAKER.phone().landline());
        System.out.print("Numer telefonu (komórkowy): ");
        System.out.println(FAKER.phone().mobile());
        System.out.print("Numer telefonu (losowy z prefiksem +48): ");
        System.out.println(FAKER.phone().plus48().random());
        System.out.print("Numer telefonu (stacjonarny z prefiksem +48): ");
        System.out.println(FAKER.phone().plus48().landline());
        System.out.print("Numer telefonu (komórkowy z prefiksem +48): ");
        System.out.println(FAKER.phone().plus48().mobile());
    }

    @Test
    public void animalRepresentation() {
        System.out.print("Zwierzę (losowe): ");
        System.out.println(FAKER.animal().random());
        System.out.print("Zwierzę (ssak): ");
        System.out.println(FAKER.animal().fromGroup().mammal());
        System.out.print("Zwierzę (ptak): ");
        System.out.println(FAKER.animal().fromGroup().bird());
        System.out.print("Zwierzę (gad): ");
        System.out.println(FAKER.animal().fromGroup().reptile());
        System.out.print("Zwierzę (płaz): ");
        System.out.println(FAKER.animal().fromGroup().amphibian());
        System.out.print("Zwierzę (ryba): ");
        System.out.println(FAKER.animal().fromGroup().fish());
        System.out.print("Zwierzę (owad): ");
        System.out.println(FAKER.animal().fromGroup().insect());
        System.out.print("Zwierzę (mięczak): ");
        System.out.println(FAKER.animal().fromGroup().mollusk());
    }

    @Test
    public void foodRepresentation() {
        System.out.print("Jedzenie (losowe): ");
        System.out.println(FAKER.food().random());
        System.out.print("Jedzenie (owoc): ");
        System.out.println(FAKER.food().ofType().fruit());
        System.out.print("Jedzenie (warzywo): ");
        System.out.println(FAKER.food().ofType().vegetable());
        System.out.print("Jedzenie (zboże): ");
        System.out.println(FAKER.food().ofType().grain());
        System.out.print("Jedzenie (mięso): ");
        System.out.println(FAKER.food().ofType().meat());
        System.out.print("Jedzenie (owoce morza): ");
        System.out.println(FAKER.food().ofType().seafood());
        System.out.print("Jedzenie (nabiał): ");
        System.out.println(FAKER.food().ofType().dairy());
        System.out.print("Jedzenie (napój): ");
        System.out.println(FAKER.food().ofType().beverage());
        System.out.print("Jedzenie (słodycz): ");
        System.out.println(FAKER.food().ofType().sweet());
        System.out.print("Jedzenie (przyprawa): ");
        System.out.println(FAKER.food().ofType().spice());
        System.out.print("Jedzenie (sos): ");
        System.out.println(FAKER.food().ofType().condiment());
        System.out.print("Jedzenie (danie): ");
        System.out.println(FAKER.food().ofType().dish());
    }

    @Test
    public void plantRepresentation() {
        System.out.print("Roślina (losowa): ");
        System.out.println(FAKER.plant().random());
        System.out.print("Roślina (kwiat): ");
        System.out.println(FAKER.plant().fromGroup().flower());
        System.out.print("Roślina (drzewo): ");
        System.out.println(FAKER.plant().fromGroup().tree());
        System.out.print("Roślina (krzew): ");
        System.out.println(FAKER.plant().fromGroup().shrub());
        System.out.print("Roślina (trawa): ");
        System.out.println(FAKER.plant().fromGroup().grass());
        System.out.print("Roślina (paprotnik): ");
        System.out.println(FAKER.plant().fromGroup().fern());
        System.out.print("Roślina (mszak): ");
        System.out.println(FAKER.plant().fromGroup().moss());
        System.out.print("Roślina (alga)");
        System.out.println(FAKER.plant().fromGroup().algae());
    }
}
