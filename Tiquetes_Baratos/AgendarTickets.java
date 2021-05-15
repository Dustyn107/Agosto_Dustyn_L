package Tiquetes_Baratos_test.PageObejects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AgendarTickets {
    WebDriver driver;

    public AgendarTickets(WebDriver Drivers) {
        driver = Drivers;
    }

    public void FechasTickets() throws InterruptedException {

        driver.findElement(By.id("ptags1")).sendKeys("Bogota");
        driver.findElement(By.id("ptags2")).click();
        driver.findElement(By.id("ptags2")).sendKeys("Quito");
        Thread.sleep(4000);
        driver.findElement(By.id("onesignal-slidedown-cancel-button")).click();
        driver.findElement(By.id("from")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[3]/a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td[3]/a")).click();
        Select Adultos = new Select(driver.findElement(By.id("adultos")));
        Adultos.selectByValue("2");
        driver.findElement(By.id("btn_buscarmotor")).click();
        Thread.sleep(15000);
       WebElement PrimerFecha = driver.findElement(By.name("ida"));
        PrimerFecha.click();
    }

    public Resultados resultados() {
        return new Resultados(driver);
    }
}
