package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");

        //Kaynak kodlarinin icinde "Gateway" ifadesi oldugunu test ediniz.
        System.out.println(driver.getPageSource()); // sayfanin kaynak kodlarini getirir
        String aranakKelime = "Gateway";
        if (driver.getPageSource().contains(aranakKelime)) System.err.println("pageSource test PASSED");
        else System.err.println("pageSource test FAILED");

        driver.close(); // driver'i kapat
        //driver.quit(); // birden fazla sayfa varsa hepsini kapatir.

    }
}
