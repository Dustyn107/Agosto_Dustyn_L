package Practico10;

import Utilities.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Practico10_Test {

    WebDriver driver;

    public static void main(String[] args) {
        System.out.println("Ejercicios de Automatización");
    }

    public void InicializarDriver(String url) {

        GetProperties properties = new GetProperties();
        String Chrome = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Dustyn\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }

    @Test
    public void fullRegistrationTest() throws InterruptedException {
        InicializarDriver("https://www.facebook.com/");
        driver.findElement(By.id("u_0_2")).click();
        Thread.sleep(3000);

     //Nombre, Apellido, tel, pass
        driver.findElement(By.id("u_1_b")).sendKeys("John");
        driver.findElement(By.id("u_1_d")).sendKeys("Smith");
        driver.findElement(By.id("u_1_g")).sendKeys("5555555");
        driver.findElement(By.id("password_step_input")).sendKeys("123456789");

     //dias
        WebElement dias = driver.findElement(By.name("birthday_day"));
        Select Combodias = new Select(dias);
        List<WebElement> CombodiasOptions = Combodias.getOptions();
        for (WebElement dia : CombodiasOptions) {
            System.out.println(dia.getText());
        }
        Combodias.selectByValue("26");
     //meses
        WebElement mes = driver.findElement(By.name("birthday_month"));
        Select Comboboxmeses = new Select(mes);
        Comboboxmeses.selectByVisibleText("jun");
     //año
        WebElement año = driver.findElement(By.id("year"));
        Select Comboboxaño = new Select(año);
        Comboboxaño.selectByValue("1980");
     //Genero
        driver.findElement(By.cssSelector("[name='sex'][value='2']")).click();

    }


}
