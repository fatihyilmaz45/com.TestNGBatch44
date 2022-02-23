package tests.homeWorksMerveHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Question6 {


    // 4 TEST METODU OLUSTURUN,oncelik vererek sirasiyla
    // https://www.n11.com/ SAYFASINA GiDİN.
    // https://www.gittigidiyor.com/ SAYFASINA GiDiN
    // https://getir.com/ SAYFASINA GiDiN
    // https://www.sahibinden.com/ SAYFASINA GiDiN

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(priority =  1)
    public void n11Test(){
        driver.get("https://www.n11.com/");
        System.out.println(driver.getTitle());
    }
    @Test (priority =  2)
    public void getirTest(){
        driver.get("https://getir.com/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void gittiGidiyorTest(){
        driver.get("https://www.gittigidiyor.com/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void sahibindenTest(){
        driver.get("https://www.sahibinden.com/");
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
