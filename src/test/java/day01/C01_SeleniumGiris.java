package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_SeleniumGiris {

    /*
    En temel haliyle bir otomasyon yapmak icin Class'imiza otomasyon icin gerekli olan
    webdriver'in yerini gostermemiz gerekir.

    Bunun icin Java kutuphanesinden System.setProperty() method'unu kullaniriz.

    Bu method'un icine ilk olarak driver'i yazariz,ikinci olarak onun fiziki yolunu kopyalariz.
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        driver.manage().window().maximize();

        System.out.println("Actual title -> " + driver.getTitle());//gidilen sitenin basligini getirir.

        System.out.println("Actual url -> " + driver.getCurrentUrl());//gidilen sayfanin url'ini getirir.

        //System.out.println("kaynak kodlari -> "+driver.getPageSource());

        driver.close();//acilan sayfayi kapatir

    }
}
