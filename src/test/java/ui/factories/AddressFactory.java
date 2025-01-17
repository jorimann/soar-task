package ui.factories;

import com.github.javafaker.Faker;
import ui.models.Address;

import java.util.Locale;

public class AddressFactory {
    public static Address getAddress () {
        Faker faker = new Faker(Locale.forLanguageTag("en-US"));

        return new Address(faker.country().name()
        ,faker.name().fullName()
        ,faker.numerify("##########")
        ,faker.numerify("#######")
        ,faker.address().streetAddress()
        ,faker.address().city()
        ,faker.address().state());
    }
}

