package day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_ManageWindowSet {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Amazon sayfasina gidin
        driver.get("https://www.amazon.com");

        //sayfanin konumu ve boyutlarini yazdirin
        System.out.println("sayfanin konumu -> " + driver.manage().window().getPosition());
        System.out.println("sayfanin boyutlari -> " + driver.manage().window().getSize());

        //sayfa konumu ve boyutlarini istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(15, 15));
        driver.manage().window().setSize(new Dimension(900, 700));
        Thread.sleep(4000);

        //sayfanin sizin istediginiz konum ve boyutunu test edin
        System.out.println("pencerenin istenen konumu -> " + driver.manage().window().getPosition());
        System.out.println("pencerenin istenen boyutlari -> " + driver.manage().window().getSize());
        Thread.sleep(3000);

        driver.close();

    }
}
