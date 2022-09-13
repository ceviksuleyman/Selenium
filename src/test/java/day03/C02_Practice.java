package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_Practice {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //amazon sayfasina git
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);


        //Search(ara) “city bike”
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(2000);
        searchBox.sendKeys("city bike", Keys.ENTER);
        Thread.sleep(2000);


        //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> arama = driver.findElements(By.className("sg-col-inner"));
        String aramaSonucuYazisi = arama.get(0).getText();
        System.out.println(aramaSonucuYazisi);


        // sadece sonuc sayisini yazdirin
        String[] sonucYazisiArr = aramaSonucuYazisi.split(" ");
        System.out.println("city bike arama sonucu -> " + sonucYazisiArr[2]);


        // sonuc sayisini lambda ile yazdirin
        Arrays.stream(aramaSonucuYazisi.split(" ")).limit(3).skip(2).forEach(System.out::println);


        //Sonra karşınıza çıkan ilk sonucun resmine tıklayın
        List<WebElement> ilkResim = driver.findElements(By.className("s-image"));
        ilkResim.get(0).click();


        // sayfayi kapat
        Thread.sleep(3000);
        driver.close();
    }
}
