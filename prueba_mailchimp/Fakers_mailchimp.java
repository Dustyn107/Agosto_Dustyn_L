package EXAMEN_FINAL.FAKERS;

import com.github.javafaker.Faker;

public class Fakers_mailchimp {

    private static Faker FAKER =new Faker();

    public static String emailAddress(){
        return FAKER.internet().emailAddress();

    }

}
