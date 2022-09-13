package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_getMethods {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //amazon.com'a git
        driver.get("https://www.amazon.com");

        //arama kutusunu locate et.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //arama kutusunun tagname'inin input oldugunu test et
        String expextedTagName = "input";
        String actualTagName = searchBox.getTagName();

        if (actualTagName.equals(expextedTagName)) System.out.println("tagname test PASS");
        else System.out.println("tagname test FAIL");

        //arama kutusunun name atribute degerinin "field-keywords" oldugunu test et
        String expectedAtributName = "field-keywords";
        String actualAtributName = searchBox.getAttribute("name");

        if (actualAtributName.equals(expectedAtributName)) System.out.println("atribut test PASS");
        else System.out.println("atribut test FAIL");

        //arama kutusunun konumu
        System.out.println("searcBox location -> " + searchBox.getLocation());

        //kapat
        driver.close();


    }
}
