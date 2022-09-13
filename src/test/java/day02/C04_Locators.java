package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Locators {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        1 - Tanimladigimiz webelementin yerini driver'in bulabilmesi icin findElement() method'unu kullaniriz.

        2 - findElement() method'unun icine parametre olarak yazacagimiz Locator'in 8 locator'dan hangisi oldugunu
        belirtmek icin By.LocatorTuru("LocateBilgisi") seklinde kullanilir.

        3 - Locate ettigimiz Web Elementini kullanabilmek icin bir variable'a atama yapariz.
         */

        //Amazon'da nutella arat
        driver.get("https://www.amazon.com");

        // 1 - By.id()
        //ilk oncelik id olmali unique oldugu icin sorunsuz calisti.
        WebElement aramaKutusuId = driver.findElement(By.id("twotabsearchtextbox")); // amazon arama kutusu id aldik
        aramaKutusuId.sendKeys("nutella", Keys.ENTER); // nutella ara


        driver.navigate().back();
        Thread.sleep(3000);
        //---------------------------------------------------------------------------------------------------------

        // 2 - By.name() -> name unique olmalidir id varsa oncelik id olmalidir.
        WebElement aramaKutusuName = driver.findElement(By.name("field-keywords"));
        aramaKutusuName.sendKeys("gaming laptop", Keys.ENTER);


        //---------------------------------------------------------------------------------------------------------

        driver.navigate().back();
        Thread.sleep(3000);
        // 3 -By.className()
        //WebElement aramaKutusuClassName = driver.findElement(By.className("nav-search-field "));
        //aramaKutusuClassName.sendKeys("nutella", Keys.ENTER);

        /*
        classname calismadi Locator alirken gozumuzden kacan detaylar olabilir!!
        aldigimiz bir locator calismazsa alternatif locator'lar denemeliyiz

        className ile yapilan locator'lar saglikli calismaz !!
         */

        //---------------------------------------------------------------------------------------------------------

        // 4 - By.linkText()
        /*
        Bu yalnızca HTML baglantilarini(link) tanimlamak icin kullanilabilir.
        linkText link'ler html tag'larinda <a> da olur.
         */
        WebElement linkText = driver.findElement(By.linkText("Sell products on Amazon"));
        linkText.click();

        driver.navigate().back();
        Thread.sleep(3000);

        // 5 - By.partialLinkText()
        // <a> tag'indan istedigimiz  parcayi aldik ve  gittik
        driver.findElement(By.partialLinkText("ucts on Amazon")).click();


        Thread.sleep(3000);
        driver.close();
    }
}
