package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_xpath {

    /*
    1-absolute xpath(mutlak) -> kullanimi cok tercih EDILMEZ   en basa // sonraki her adimda / yazarak hedef element'e kadar tum tag'lar yazilir

    2-relative xpath(bagil) -> //*[@class='added-manually']    , //*[text()='Delete']
     */

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


        Thread.sleep(3000); // 10 defa addElement'e tikla
        int x = 10;
        while (x != 0) {
            addElement.click();
            x--;
            Thread.sleep(2000);
        }


        //Delete butonu’nun gorunur oldugunu test edin  //*[@class='added-manually']
        WebElement deleteButton = driver.findElement(By.xpath("//*[text()='Delete']"));
        if (deleteButton.isDisplayed()) System.out.println("Delete Button PASS");
        else System.out.println("Delete Button FAIL");

        /*
        Locate alirken text kullanicaksak  //*[text()='Delete'] bu formattadir.
        Atribute kullanicaksak //*[@class='added-manually'] bu format kullanilir.
         */


        //Delete tusuna basin
        deleteButton.click();


        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemove = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if (addRemove.isDisplayed()) System.out.println("Add/Remove Elements PASS");
        else System.out.println("Add/Remove Elements FAIL");

        //kapat
        driver.close();

    }
}
