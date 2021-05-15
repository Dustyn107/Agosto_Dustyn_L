package Tiquetes_Baratos_test.Test;

import Tiquetes_Baratos_test.PageObejects.AgendarTickets;
import Tiquetes_Baratos_test.PageObejects.Resultados;
import Tiquetes_Baratos_test.PageObejects.TicketsB_LandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tiquetes_Test {
    WebDriver driver;
    private TicketsB_LandingPage ticketsB_LandingPage;

    @BeforeTest
    public void Setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Dustyn\\Documents\\Automatizacion\\Drivers\\Version 89\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.tiquetesbaratos.com/");
        ticketsB_LandingPage = new TicketsB_LandingPage(driver);
    }

    @Test
    public void FechasTestVuelos() throws InterruptedException {
        AgendarTickets agendarTickets = ticketsB_LandingPage.HomeVuelo();
        agendarTickets.FechasTickets();
        Resultados resultados = agendarTickets.resultados();
        resultados.BusqIdaRegreso();
    }


    @Test
    public void tiquete_test() throws InterruptedException {
        driver.get("https://www.tiquetesbaratos.com/");
        driver.findElement(By.name("origen")).sendKeys("Bogota");
        driver.findElement(By.id("ptags2")).click();
        driver.findElement(By.id("ptags2")).sendKeys("Quito", Keys.ARROW_DOWN, Keys.ENTER);
        Thread.sleep(4000);

        //abrir calendario
        driver.findElement(By.id("from")).click();

        //selección de dias de la reserva

        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[3]/a")).click();

        driver.findElement(By.xpath("//*[@id='ui-datepicker-div]/div[2]/div/a/span")).click();
        //driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td[3]/a")).click();
        // mala idea: driver.findElement(By.cssSelector("[id='ui-datepicker-div'][data-year='2022'][class='ui-state-default ui-state-active'][href='#']")).click();


        //Selección de pasajeros
        Select Adultos = new Select(driver.findElement(By.id("adultos")));
        Adultos.selectByValue("2");
        driver.findElement(By.id("btn_buscarmotor")).click();
        Thread.sleep(40000);
        WebElement PrimerFecha = driver.findElement(By.name("ida"));
        PrimerFecha.click();
        WebElement SegudaFecha = driver.findElement(By.id("regreso_1_1"));
        SegudaFecha.click();

    }

    @AfterTest
    public void close() {

    }
}
