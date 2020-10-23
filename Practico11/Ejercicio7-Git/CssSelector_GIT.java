package Practico11;

import Utilities.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CssSelector_GIT {

    WebDriver driver;

    public static void main(String[] args) {
        System.out.println("Ejercicio Spotify_Test");

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
    public void spotifyByPlaceHolder() throws InterruptedException {
        InicializarDriver("https://www.spotify.com/co/signup/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[placeholder ='Introduce tu correo electrónico.']")).sendKeys("testman@testing.com");
        driver.findElement(By.cssSelector("[placeholder = 'Vuelve a introducir tu correo electrónico.']")).sendKeys("testman@testing.com");
        driver.findElement(By.cssSelector("[placeholder = 'Crea una contraseña.']")).sendKeys("123456789");
        driver.findElement(By.cssSelector("[placeholder = 'Introduce un nombre de perfil.']")).sendKeys("Testingman");
        driver.findElement(By.cssSelector("[placeholder = 'DD']")).sendKeys("13");

        //ComboBox
        WebElement mes = driver.findElement(By.name("month"));
        Select Comboboxmeses = new Select(mes);
        Comboboxmeses.selectByVisibleText("Junio");
        driver.findElement(By.cssSelector("[placeholder = 'AAAA']")).sendKeys("1987");
        //Genero
        driver.findElement(By.cssSelector("[class = 'Indicator-sc-16vj7o8-0 kSKYRE']")).click();





    }
}



