package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_WindowHandle {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
        System.out.println(driver.getWindowHandle());// CDwindow-C229322B9159393E13EE104D0B0DF79A
        //farkli pencereler arasinda gezinebilmek icin getWindowHandle() method'unu kullaniriz.

        driver.close();
    }
}
