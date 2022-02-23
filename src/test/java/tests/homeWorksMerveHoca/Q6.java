package tests.homeWorksMerveHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class Q6 {
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    WebDriver driver;
    SoftAssert softAssert=new SoftAssert();
    @BeforeClass
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void openWindowElementiTesti (){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
//driver.get("https://the-internet.herokuapp.com/windows");
        //  //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openWindowElementi=driver.findElement(By.tagName("h3"));
        String openWindowElementiStr=openWindowElementi.getText();
        System.out.println("openWindowElementiStr = " + openWindowElementiStr);

        String expectedText="Opening a new window";
        softAssert.assertEquals(openWindowElementiStr,expectedText,"beklenen text cikmadi");
    }
    @Test
    public void titleTesti(){
        //  //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualIlkSayfaTitle=driver.getTitle();
        System.out.println("actualIlkSayfaTitle = " + actualIlkSayfaTitle);
        String expectedTitle="The Internet";
        softAssert.assertEquals(actualIlkSayfaTitle,expectedTitle,"ilk sayfa title eslesmiyor");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        System.out.println("ilkSayfaHandleDegeri = " + ilkSayfaHandleDegeri);
        //  //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        Set<String> handleDegerleriSet=driver.getWindowHandles();
        String ikinciSayfaHandleDegeri="";
        for (String w:handleDegerleriSet        ) {
            if (!w.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaHandleDegeri=w;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        System.out.println("ikinciSayfaHandleDegeri = " + ikinciSayfaHandleDegeri);
        //  //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualIkinciSayfaTitle=driver.getTitle();
        System.out.println("actualIkinciSayfaTitle = " + actualIkinciSayfaTitle);
        String expectedIkinciSayfaTitle="New Window";
        softAssert.assertEquals(actualIkinciSayfaTitle,expectedIkinciSayfaTitle,"ikinci sayfa title eslesmiyor");
        // //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaText= driver.findElement(By.tagName("h3"));
        String ikinciSayfaTextStr=ikinciSayfaText.getText();
        System.out.println("ikinciSayfaTextStr = " + ikinciSayfaTextStr);
        // //● Bir önceki pencereye geri döndükten sonra sayfa başlığının

        // “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);

        softAssert.assertEquals(actualIlkSayfaTitle,expectedTitle,"ilk sayfa title eslesmiyor 2.test");

    }



    @AfterClass
    public void tearDown () throws InterruptedException {
        softAssert.assertAll();
        Thread.sleep(2000);
        driver.quit();
    }


}
