package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        Thread.sleep(2000);


        //Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();
        Thread.sleep(3000);


        //email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextBox = driver.findElement(By.id("session_email"));
        WebElement passwordTextBox = driver.findElement(By.id("session_password"));
        WebElement signIn = driver.findElement(By.name("commit"));


        //Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın
        String email = "testtechproed@gmail.com";
        String password = "Test1234!";
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        Thread.sleep(2000);

        signIn.click(); //signin butonu tikla


        //Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement expectedUser = driver.findElement(By.className("navbar-text"));
        //1.yontem
        if (expectedUser.isDisplayed())
            System.out.println("1.yontem ExpectedUser TEST PASSED -> " + expectedUser.getText());
        else System.out.println("1.yontem ExpectedUser TEST FAILED");

        //NOTE => Webelementin uzerindeki konsolda yazdirabilmek icin getText() method'u kullanilir.

        //2.yontem
        String expectedUserText = "testtechproed@gmail.com";
        String actualUserText = expectedUser.getText();
        if (actualUserText.equals(expectedUserText)) System.out.println("2.yontem Expected User Test PASS");
        System.out.println("Expected User Test FAIL");


        //“Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addresses = driver.findElement(By.linkText("Addresses"));
        WebElement signOut = driver.findElement(By.linkText("Sign out"));

        if (addresses.isDisplayed()) System.out.println("Adres TEST PASS");
        else System.out.println("Adres TEST FAIL");

        if (signOut.isDisplayed()) System.out.println("signout TEST PASS");
        else System.out.println("signout TEST FAIL");


        //Sayfada kac tane link oldugunu bulun.
        List<WebElement> tagAList = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayisi : " + tagAList.size());
        //forloop
        int count = 1;
        for (WebElement w : tagAList) {
            System.out.println(count + " -> " + w.getText());
            count++;
        }
        //lambda
        tagAList.forEach(t -> System.out.println(t.getText()));


        //kapat
        driver.close();

    }
}
