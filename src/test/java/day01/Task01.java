package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();


        //Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //Sayfa basligini(title) yazdirin
        System.out.println("title -> " + driver.getTitle());

        //Sayfa basliginin "Amazon" icerdigini test edin
        if (driver.getTitle().contains("Amazon")) System.out.println("title test PASSED");
        else System.out.println("title test FAILED");

        //Sayfa adresini(url) yazdirin
        System.out.println("url -> " + driver.getCurrentUrl());

        //Sayfa url'inin "amazon" icerdigini test edin.
        if (driver.getCurrentUrl().contains("amazon")) System.out.println("url test PASSED");
        else System.out.println("url test FAILED");

        //Sayfa handle degerini yazdirin
        System.out.println("windowhandle -> " + driver.getWindowHandle());

        //Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
        String html = driver.getPageSource();
        String arananKelime = "Gateway";
        if (html.contains(arananKelime)) System.out.println("html test PASSED");
        else System.out.println("html test FAILED");

        //Sayfayi kapatin.
        driver.close();
    }
}
