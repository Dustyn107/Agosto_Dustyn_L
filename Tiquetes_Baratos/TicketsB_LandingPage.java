package Tiquetes_Baratos_test.PageObejects;

import org.openqa.selenium.WebDriver;

public class TicketsB_LandingPage {

    private WebDriver driver;

    public TicketsB_LandingPage (WebDriver Drivers){
        driver= Drivers;
    }

    public AgendarTickets HomeVuelo(){
        driver.get("https://www.tiquetesbaratos.com/");
        return new AgendarTickets(driver);
    }

}
