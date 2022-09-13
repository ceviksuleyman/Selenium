package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_xpath {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        // https://the-internet.herokuapp.com/add_remove_elements/ adresine git
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(3000);

        WebElement addElement = driver.findElement(By.xpath("//*[text()='Add Element']"));
        addElement.click();
        Thread.sleep(3000);


        //Delete butonu’nun gorunur oldugunu test edin
        WebElement delete = driver.findElement(By.xpath("//*[text()='Delete']"));
        System.out.println("delete botunu goruntuleme test -> " + delete.isDisplayed());


        //Delete tusuna basin
        delete.click();


        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemove = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        System.out.println("Add/Remove Elements butonu goruntuleme test -> " + addRemove.isDisplayed());

    }
}
