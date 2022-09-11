package day02;

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

        // email textbox,password textbox, and signin button elementlerini locate ediniz..
        // Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // Username : testtechproed@gmail.com
        // Password : Test1234!
        WebElement userName = driver.findElement(By.id("session_email"));
        userName.sendKeys("testtechproed@gmail.com");

        Thread.sleep(3000);

        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("Test1234!");

        Thread.sleep(3000);

        driver.findElement(By.name("commit")).click();

        //Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).




        //“Addresses” ve “Sign Out” textlerinin goruntulendigini( displayed) dogrulayin(verify).



        //Sayfada kac tane link oldugunu bulun.
        System.out.println("sayfadaki link sayisi -> " + driver.findElements(By.tagName("a")).size());

        //driver.close();
    }
}
