package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_IlkTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // 1.Amazon sayfasina gidiniz.
        driver.get("https://www.amazon.com");

        // 2.Basligin "Amazon" icerdigini test ediniz.
        String actualTitle = driver.getTitle();
        String aranan = "Amazon";
        if (actualTitle.contains(aranan)) System.out.println("title test PASSED");
        else System.out.println("title test FAILED");

        // 3.Url'in "amazon" icerdigini test edin.
        String actualUrl = driver.getCurrentUrl();
        String aranan2 = "amazon";
        if (actualUrl.contains(aranan2)) System.out.println("url test PASSED");
        else System.out.println("url test FAILED");

        // 4.sayfayi kapat
        driver.close();

    }
}
