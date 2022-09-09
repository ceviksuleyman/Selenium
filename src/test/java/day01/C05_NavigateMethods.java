package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class C05_NavigateMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(3000);
        //driver.navigate().to() method'u sayfada ileri geri yapacaksak kullanilir.
        //driver.get() method'u gibi istedigimiz url'e goturur.

        driver.navigate().to("https://www.github.com/ceviksuleyman");
        Thread.sleep(3000);

        //amazon.com'a geri donelim
        driver.navigate().back();
        Thread.sleep(3000);

        //tekrar github'a gidelim
        driver.navigate().forward();
        Thread.sleep(3000);

        //githup sayfasini yenileyelim
        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.close();
    }
}
