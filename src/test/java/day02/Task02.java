package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task02 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Youtube sayfasina git
        driver.get("https://www.youtube.com");

        //sayfa basliginin "youtube" olup olmadigini dogrulayin, eger degilse dogru basligi yazdirin.
        String ytTitle = driver.getTitle();
        String ytTitleAra = "youtube";
        if (ytTitle.contains(ytTitleAra)) System.out.println("youtube title test PASSED -> " + driver.getTitle());
        else System.out.println("youtube title test FAILED -> " + driver.getTitle());

        //amazon sayfasina git
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(3000);

        //youtube sayfasina geri don
        driver.navigate().back();
        Thread.sleep(3000);

        //sayfayi yenile
        driver.navigate().refresh();

        //amazon sayfasina geri don
        driver.navigate().forward();

        //sayfayi tam ekran yap
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //amazon sayfasinin basliginin "Amazon" icerip icermedigini kontrol et, icermiyorsa dogru basligi yazdir
        String amazonTit = driver.getTitle();
        String amazon = "Amazon";
        if (amazonTit.contains(amazon)) System.out.println("amazon title test PASSED -> " + driver.getTitle());
        else System.out.println("amazon title Test FAILED -> " + driver.getTitle());

        //sayfanin url'i https://www.amazon.com/ olup olmadigini dogrulayin degilse url'i yazdirin.
        String amazonUrl = driver.getCurrentUrl();
        String amznUrlAra = "https://www.amazon.com/";
        if (amazonUrl.contains(amznUrlAra)) System.out.println("amazon url testi PASSED -> " + driver.getCurrentUrl());
        else System.out.println("amazon url testi -> " + driver.getCurrentUrl());

        driver.close();
    }
}
