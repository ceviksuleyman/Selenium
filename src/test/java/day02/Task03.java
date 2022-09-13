package day02;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task03 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        // Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();
        Thread.sleep(3000);

        // email textbox,password textbox, and signin button elementlerini locate ediniz
        // Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın
        // Username : testtechproed@gmail.com
        // Password : Test1234!
        String userMail = "testtechproed@gmail.com";
        String userPassword = "Test1234!";

        WebElement userSignIn = driver.findElement(By.id("session_email"));
        userSignIn.sendKeys(userMail);

        Thread.sleep(3000);

        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys(userPassword);

        Thread.sleep(3000);

        driver.findElement(By.name("commit")).click();


        //Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        String expectedUser = driver.findElement(By.xpath("//span[@data-test=\"current-user\"]")).getText();
        System.out.println(expectedUser);

        if (expectedUser.equals(userMail)) System.out.println("User id test PASSED");
        else System.out.println("user id test FAILED");


        //“Addresses” ve “Sign Out” textlerinin goruntulendigini( displayed) dogrulayin(verify).
        System.out.println("Addresses goruntuleme test -> " + driver.findElement(By.xpath("//a[@data-test=\"addresses\" ]")).isDisplayed());
        System.out.println("Sign Out goruntuleme test -> " + driver.findElement(By.xpath("//a[@data-test=\"sign-out\" ]")).isDisplayed());


        //Sayfada kac tane link oldugunu bulun.
        System.out.println("sayfadaki link sayisi -> " + driver.findElements(By.tagName("a")).size());

        Thread.sleep(7000);
        driver.close();
    }
}
