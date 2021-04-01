package EXAMEN_FINAL.DATAPROVIDERS;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviders_mailchimp {

    WebDriver driver;

    @DataProvider(name = "Emails")
    public Object[][] EmailsTest() {
        return new Object[][]{

                {"XYtest@gmail.com"},
                {"ABtest@outlook.com"},
                {"YZtest@yahoo.com"}
        };
    }

    @Test(dataProvider = "Emails")
    public void Correos(String email) {

        //driver.get("https://www.netflix.com/co/");
        //driver.findElement(By.id("id_email_hero_fuji")).sendKeys(email);
        //driver.findElement(By.cssSelector("[class='cta-btn-txt']")).click();
        System.out.println("Imprimir correos: " + email);

    }

}
