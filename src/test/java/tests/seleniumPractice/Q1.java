package tests.seleniumPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Q1 {
    //odev
    //soru :ingilizce
    // //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    // //maximize the window
    ////click on action dialog button
    // //if need use explicitly wait
    ////click on the ok button
    ////accept the iframe message
    //1.soru :Turkce
    ////web sitesine gidin: https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //     // pencereyi büyüt
    //     // eylem diyalog düğmesine tıklayın
    //     // kullanmanız gerekiyorsa açıkça bekleyin
    //     // tamam butonuna tıklayın
    //     // iframe mesajını kabul et
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException {
        // odev
        //soru :ingilizce
        // //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        // //maximize the window
        ////click on action dialog button
        // //if need use explicitly wait
        ////click on the ok button
        ////accept the iframe message
        //1.soru :Turkce
        ////web sitesine gidin: https://www.jqueryscript.net/demo/bootstrap-alert-box/
        //     // pencereyi büyüt
        //     // eylem diyalog düğmesine tıklayın
        //     // kullanmanız gerekiyorsa açıkça bekleyin
        //     // tamam butonuna tıklayın
        //     // iframe mesajını kabul et
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='action']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
    @AfterClass
    public void teardown() {
        driver.close();
    }

}
