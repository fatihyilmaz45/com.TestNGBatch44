package tests.day11;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Derste extends TestBase {
    @Test
    public void test1(){

        SoftAssert softAssert =new SoftAssert();
         /*
● Yeni bir class olusturun: WindowHandle
● Amazon anasayfa adresine gidin.

● Sayfa’nin window handle degerini String bir degiskene atayin
● Sayfa title’nin “Amazon” icerdigini test edin
● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
● Sayfa title’nin “Walmart” icerdigini test edin
● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
*/
        driver.get("https://www.amazon.com");
        String handle1= driver.getWindowHandle();
        System.out.println(handle1);
        String actTitle=driver.getTitle();
        String expTit="Amazon";
        softAssert.assertTrue(actTitle.contains(expTit),"ozledim seni");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        String handle2=driver.getWindowHandle();
        System.out.println(handle2);
        softAssert.assertTrue(driver.getTitle().contains("TECHPROEDUCATION"),"olmadi loooo");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        String handle3=driver.getWindowHandle();
        driver.switchTo().window(handle3);
        System.out.println(handle3);
        softAssert.assertTrue(driver.getTitle().contains("Walmart"));
        driver.switchTo().window(handle1);
        softAssert.assertTrue(driver.getTitle().contains("Amazon"));

        softAssert.assertAll();

    }
}
