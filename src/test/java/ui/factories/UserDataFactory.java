package ui.factories;

import com.github.javafaker.Faker;
import ui.models.SecretQuestion;
import ui.models.User;

import java.util.Locale;
import java.util.Random;

public class UserDataFactory {

    public static User getRandomUser() {
        Faker faker = new Faker(Locale.forLanguageTag("en-US"));
        String email = System.currentTimeMillis() + "@gmail.com";
        String password = faker.bothify("password????##");
        String answer = faker.bothify("????##");

        return new User(email
                , password
                , password
                , getRandomEnum(SecretQuestion.class).toString()
                , answer
                , faker.name().fullName());
    }

    private static <E extends Enum<E>> E getRandomEnum(Class<E> enumClass) {
        Random random = new Random();
        E[] enumValues = enumClass.getEnumConstants();
        return enumValues[random.nextInt(enumValues.length)];
    }
}

