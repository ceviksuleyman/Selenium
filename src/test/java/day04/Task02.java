package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        //Browseri tam sayfa yapin
        driver.manage().window().maximize();
        Thread.sleep(3000);


        //Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        System.out.println("Sayfa basligi -> " + driver.getTitle());
        if (driver.getTitle().contains("Spend less")) System.out.println("title Test PASS");
        else System.out.println("title Test FAIL");


        //Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();
        Thread.sleep(2000);


        //Birthday butonuna basin
        driver.findElement(By.cssSelector("img[alt='Birthday gift cards']")).click();
        Thread.sleep(2000);


        //Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.cssSelector("span[class='a-truncate-cut']")).click();
        Thread.sleep(2000);


        //Gift card details’den 25 $’i  secin
        driver.findElement(By.cssSelector("#a-autoid-28")).click();
        Thread.sleep(2000);


        //Urun ucretinin 25$ oldugunu test edin
        String actual$25 = driver.findElement(By.cssSelector("#a-autoid-28")).getText();
        System.out.println(actual$25);

        if (actual$25.equals("$25")) System.out.println("$25 test PASS");
        else System.out.println("$25 test FAIL");


        //kapat
        driver.close();


    }
}
