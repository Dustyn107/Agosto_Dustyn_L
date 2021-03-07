package EXAMEN_FINAL.TEST;

import EXAMEN_FINAL.DATAPROVIDERS.Dataproviders_mailchimp;
import EXAMEN_FINAL.FAKERS.Fakers_mailchimp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class prueba_mailchimp {

    private final String MAILCHIMP_URL = "https://login.mailchimp.com/";
    WebDriver driver;


    @BeforeMethod
    public void Setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Dustyn\\Documents\\Automatizacion\\Drivers\\Versión 27\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    /**
     * Caso de prueba 1:
     * Crear un test llamado  validarTituloTest, que valide el título de la página con un assert.
     */

    @Test
    public void validarTituloTest() {
        driver.get(MAILCHIMP_URL);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Assert.assertTrue(driver.getTitle().contains("Login | Mailchimp"));


    }

    /**
     * Caso de prueba 2:
     * Crear un método de test que se llame iniciarSesionPageTest.
     * a.  Validar que se encuentre el texto “Iniciar sesión” en el sitio. Utilizar asserts
     * b.  Validar que esté el texto: Need a Mailchimp account?
     */

    @Test
    public void iniciarSesionPageTest() {
        driver.get(MAILCHIMP_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();


        WebElement Needmailchimp = driver.findElement(By.xpath("//span[@class='padding-right--lv1']"));
        Assert.assertEquals(Needmailchimp.getText(),"Need a Mailchimp account?");
        System.out.println("Titulo --->" + Needmailchimp.getText());


        WebElement IncioSesion = driver.findElement(By.xpath("//h1[@class='text-align--center !margin-bottom--lv3']"));
        Assert.assertEquals(IncioSesion.getText(),"Log In");
        System.out.println("Titulo --->" + IncioSesion.getText());


    }


    @Test
    public void loginErrorTest() throws InterruptedException {
        driver.get(MAILCHIMP_URL);
        Thread.sleep(2000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("username")).sendKeys("XXXXX@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement Btncheck = driver.findElement(By.xpath("//input[@name='stay-signed-in']"));
        Btncheck.click();

        WebElement MsgErrorCorreo = driver.findElement(By.xpath("//*[contains (text(), 'Looks like you forgot your password there')]"));
        Assert.assertEquals(MsgErrorCorreo.getText(), "Looks like you forgot your password there, XXXXX@gmail.com.");

    }

    /**
     * Crear un método llamado fakeEmailTest.
     * Navegar hacia la sección de registro:
     * driver.navigate().to("https://login.mailchimp.com/signup/");
     * Aceptar las cookies (si aparecen) y esperar 2 segundos.
     * Se debe completar el campo de email que se encuentra dentro de la sección de
     * Registro. Asegurarse que la url contiene la palabra signup.
     * Se debe enviar un email que se genere de forma randómica cada vez que se ejecute el test con la librería Faker.
     */

    @Test
    public void fakeEmailTest() throws InterruptedException {
        driver.navigate().to("https://login.mailchimp.com/signup/");
        Thread.sleep(2000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("email")).sendKeys(Fakers_mailchimp.emailAddress());

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://login.mailchimp.com/signup/");
        System.out.println("La URL es " + driver.getCurrentUrl());

    }
/**
 * Caso de prueba 5:
 * Crear un método llamado dataProviderEmailTest que complete el
 * campo de email que se encuentra dentro de la sección de login.. El dataProvider debe enviar 3 emails
 * válidos al test. La password debe ser definida como “holamundo”. Hacer click en el
 * boton para loguearse y validar que se encuentre el mensaje “Can we help you recover
 * your  username?” dentro del sitio.
 */


@Test (dataProvider = "Emails", dataProviderClass = Dataproviders_mailchimp.class)
    public void dataProviderEmailTest(String Email) throws InterruptedException {

    driver.navigate().to("https://login.mailchimp.com/signup/");
    Thread.sleep(2000);
    driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    driver.findElement(By.id("email")).sendKeys(Email);
    driver.findElement(By.id("new_password")).sendKeys("Holamundo1*");
    driver.findElement(By.xpath("//button[@id='create-account']")).click();
    Thread.sleep(2000);



    WebElement MsgErrorRegistro = driver.findElement(By.cssSelector("[class = 'hide-phone'][class ='show-phone']"));
    
    Assert.assertEquals(MsgErrorRegistro.getText(), "Find your people. Engage your customers. Build your brand. Do it all with Mailchimp’s Marketing Platform. Already have an account?");


}

    @AfterMethod
    public void closePage(){

        driver.close();
    }
}
