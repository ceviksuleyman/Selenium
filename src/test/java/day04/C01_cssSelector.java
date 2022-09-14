package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_cssSelector {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        //Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in

        driver.get(" http://a.testaddressbook.com/sign_in");

        //Locate email textbox
        WebElement emailTextBox = driver.findElement(By.cssSelector("#session_email"));

        /*
        cssSelector'de sadece id atribute icin # kullanilir !!!!
        cssSelector'de sadece class atribute icin . kullanilir. !!
         */

        //Locate password textbox
        WebElement passwordTextBox = driver.findElement(By.cssSelector("#session_password"));

        //Locate signin button
        WebElement signIn = driver.findElement(By.cssSelector("input[name='commit']"));

        //kullanıcı adını ve şifreyi girin ve sign in düğmesinitıklayın
        Thread.sleep(3000);
        String userName = "testtechproed@gmail.com";
        String password = "Test1234!";

        emailTextBox.sendKeys(userName);
        Thread.sleep(1000);
        passwordTextBox.sendKeys(password);
        Thread.sleep(1000);
        signIn.click();
        Thread.sleep(3000);

        //kapat
        driver.close();

    }
}
