package tests.homeWorksMerveHoca;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Question4 {
    // a. http://a.testaddressbook.com adresine gidiniz.
    // b. Sign in butonuna basin
    // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
    // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
    // i. Username : testtechproed@gmail.com
    // ii.Password : Test1234!
    // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
    // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    //3. Sayfada kac tane link oldugunu bulun.
    //4.Linklerin yazisini nasil yazdirabiliriz
    //Elimizdeki listedeki tum webelementlerin yazilarini for loop veya for each loop ile yazabiliriz
    //5. driver i kapatin

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        //=====================================================================================================

        // b. Sign in butonuna basin
        WebElement signInLinki = driver.findElement(By.linkText("Sign in"));
        signInLinki.click();
        //=====================================================================================================

        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        Thread.sleep(3000);
        WebElement emailTextBox=driver.findElement(By.id("session_email"));
        WebElement passwordTextBox=driver.findElement(By.id("session_password"));
        WebElement signInButonu=driver.findElement(By.name("commit"));

        //===================================================================================================
        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // i. Username : testtechproed@gmail.com
        // ii.Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButonu.click();

        //============================================================================================
        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement dogruKullanici=driver.findElement(By.className("navbar-text"));
        String usarname="testtechproed@gmail.com";

        if ( dogruKullanici.getText().equals(usarname)){

            System.out.println("Test PASS... Dogru kullanici");

        }else {

            System.out.println("test FAILD....Yanlis Kullanici");
        }

        //===================================================================================================
        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).

        WebElement addressesLinki=driver.findElement(By.linkText("Addresses"));
        WebElement SignOut=driver.findElement(By.linkText("Sign out"));

        if (addressesLinki.isDisplayed()){
            System.out.println("test PASS...Adres linki goruluyor");
        }else{

            System.out.println("test FAILD...SignOut linki gorulmuyor");
        }

        if (SignOut.isDisplayed()){
            System.out.println("test PASS..SignOutlinki goruluyor");
        }else{

            System.out.println("test FAILD...Adres linki gorulmuyor");
        }

        //=======================================================================================================
        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkler=driver.findElements(By.tagName("a"));
        System.out.println("sistemin giris sayfasinda olan link sayisi"+linkler.size());

        //=====================================================================================================
        //4.Linklerin yazisini nasil yazdirabiliriz
        //Elimizdeki listedeki tum webelementlerin yazilarini for loop veya for each loop ile yazabiliriz


        for (WebElement each:linkler
        ) {
            System.out.println(each.getText());
        }
        //5. driver i kapatin
        driver.close();
    }
}
