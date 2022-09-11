package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_findElements {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 6 - findElements(By.tagName(""))

        //Amazon sayfasina git
        driver.get("https://www.amazon.com");

        //Amazon sayfasindaki <a> (link) tag'larin sayisini yazdirin
        List<WebElement> tagA = driver.findElements(By.tagName("a"));

        System.out.println("a taglarinin  (link) sayisi -> " + tagA.size());

        // NOTE => list'deki her webelementi 0'dan baslayan bir index alir. index veya iterator ile ulasilir.

        // "input" taglarinin sayisi
        System.out.println("input taglarinin sayisi -> " + driver.findElements(By.tagName("input")).size());

        driver.close();
    }
}
