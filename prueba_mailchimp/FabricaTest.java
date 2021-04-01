package EXAMEN_FINAL.FACTORY;

import EXAMEN_FINAL.TEST.prueba_mailchimp;
import org.testng.annotations.Factory;

public class FabricaTest {
    @Factory
    public Object[] FactoryTest(){
        return new Object[]{
                new prueba_mailchimp(),
                new prueba_mailchimp(),

        };
    }

}
