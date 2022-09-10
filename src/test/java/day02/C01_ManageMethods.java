package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class C01_ManageMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("pencere konum : " + driver.manage().window().getPosition());//acilan browser'in konumunu verir.
        System.out.println("pencere boyut : " + driver.manage().window().getSize());// acilan browser'in boyutlarini verir.

        //sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //simge durumunda 3 saniye bekleyip maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //sayfanin konum ve boyutlarini maksimize durumda yazdir
        System.out.println("maximize pencere konumu -> " + driver.manage().window().getPosition());
        System.out.println("maximize pencere boyutlari -> " + driver.manage().window().getSize());
        Thread.sleep(4000);

        //sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        //sayfanin konum ve boyutunu fullscreen durumda yazdirin
        System.out.println("fullscreen pencere konum -> " + driver.manage().window().getPosition());
        System.out.println("fullscreen pencere boyutlari -> " + driver.manage().window().getSize());
        Thread.sleep(3000);

        driver.close();
    }
}
