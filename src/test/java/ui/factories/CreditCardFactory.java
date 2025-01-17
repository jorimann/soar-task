package ui.factories;

import com.github.javafaker.Faker;
import ui.models.CreditCard;

import java.util.Locale;

public class CreditCardFactory {
    public static CreditCard getCard (String userName) {
        Faker faker = new Faker(Locale.forLanguageTag("en-US"));

        return new CreditCard(userName
                ,faker.numerify("4###############")
                ,faker.number().numberBetween(1,12)
                ,faker.number().numberBetween(2080, 2099));
    }
}