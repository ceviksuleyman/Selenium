package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ManageMethodWait {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        /*
        Ileride Wait konusunu daha genis olarak ele alacagiz.
        Bir sayfa acilirken ilk basta sayfanin iceriginde bulunan elementlere gore bir yukleme suresine
        ihtiyac vardir veya bir webelement'in kullanilabilmesi icin zamana ihtiyac olabilir.

        implicitlyWait() method'u bize sayfanin yuklenmesi ve sayfadaki elementlere ulasim icin beklenecek
        maksimum sureyi belirleme olanagi saglar.
         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(5000);
        driver.get("https://www.youtube.com");
        Thread.sleep(3000);

        driver.close();
    }
}
