package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Task01 {

    /*
    1-https://the-internet.herokuapp.com/add_remove_elements/adresine gidin
    2-Add Element butonuna 10 kez basin
    3-10 kez Add Element butonuna basildigini test edin
    4-Delete butonu gorunmeyene kadar Delete botununa basin
    5-Delete botonunun gorunmedigini test edin.
    6-kapat
     */
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        // https://the-internet.herokuapp.com/add_remove_elements/adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);


        // Add Element butonuna 10 kez basin
        WebElement addElementButton = driver.findElement(By.xpath("//*[.='Add Element']"));
        int s = 10;
        while (s != 0) {
            addElementButton.click();
            s--;
            Thread.sleep(1000);
        }



        // 10 kez Add Element butonuna basildigini test edin
        List<WebElement> addElementCount = driver.findElements(By.xpath("//*[.='Delete']"));
        int count = 1;
        for (WebElement w : addElementCount) {
            System.out.println(count + " -> " + w.getText());
            count++;
        }
        if (addElementCount.size() == 10) System.out.println("Add Element Sayac PASS");
        else System.out.println("Add Element Sayac FAIL");



        //Delete butonu gorunmeyene kadar Delete botununa basin
        int x = 10;
        while (x != 0) {
            driver.findElement(By.xpath("//*[.='Delete']")).click();
            x--;
            Thread.sleep(1000);
        }


        //Delete botonunun gorunmedigini test edin.
        WebElement deleteButton = driver.findElement(By.id("elements"));
        if (!deleteButton.getText().contains("Delete")) System.out.println("delete Button PASS");
        else System.out.println("delete Button FAIL");


        //kapat
        driver.close();
    }
}
