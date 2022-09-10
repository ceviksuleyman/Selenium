package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class Task01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // facebook sayfasina gidin
        driver.get("https://www.facebook.com");

        //sayfanin basliginin(title) "facebook" oldugunu dogrulayin(verify),degilse dogru basligi yazdirin.
        String fbTitle = driver.getTitle();
        String fbTitleAranan = "facebook";
        if (fbTitle.contains(fbTitleAranan)) System.out.println("facebook title testi PASSED");
        else System.out.println("FAILED sayfanin basligi \"facebook\" icermiyor -> " + driver.getTitle());

        //sayfanin url'nin "facebook" kelimesi icerdigini dogrulayin,icermiyorsa "actual" url'i yazdirin.
        String fbUrl = driver.getCurrentUrl();
        String fbUrlAranan = "facebook";
        if (fbUrl.contains(fbUrlAranan)) System.out.println("facebook url test PASSED -> " + driver.getCurrentUrl());
        else System.out.println("facebook url test FAILED -> " + driver.getCurrentUrl());

        //"https://www.walmart.com" sayfasina gidin
        driver.navigate().to("https://www.walmart.com");

        //sayfanin basliigi "Walmart.com" icerdigini dogrulayin.
        String wmTitle = driver.getTitle();
        String wmTitleAranan = "Walmart.com";
        if (wmTitle.contains(wmTitleAranan)) System.out.println("wallmart title test PASSED -> "+driver.getTitle());
        else System.out.println("wallmart title test FAILED -> "+driver.getTitle());

        //Tekrar facebook sayfasina donun
        driver.navigate().back();
        Thread.sleep(3000);

        //sayfayi yenileyin
        driver.navigate().refresh();

        //sayfayi maximize yapin
        driver.manage().window().maximize();
        Thread.sleep(3000);


        driver.close();
    }
}
