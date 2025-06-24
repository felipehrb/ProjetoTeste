package faker;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerFactory {
    private static final Faker faker = new Faker(new Locale("pt-BR"));

    public static Faker get() {
        return faker;
    }
}
