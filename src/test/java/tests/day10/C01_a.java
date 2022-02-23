package tests.day10;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_a extends TestBase {
    SoftAssert softAssert;
    @Test
    public void test1(){
        // ● Bir class olusturun: Alerts
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //● Bir metod olusturun: acceptAlert
        //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //      “You successfully clicked an alert” oldugunu test edin.
            driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
            driver.switchTo().alert().accept();
            String actual=driver.findElement(By.id("result")).getText();
            String expected="You successfully clicked an alert";
        softAssert=new SoftAssert();
        softAssert.assertTrue(actual.equals(expected));
        softAssert.assertAll();
    }
        @Test
    public void test2(){
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            //● Bir metod olusturun: dismissAlert
            //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
            driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
            driver.switchTo().alert().dismiss();
            //      “successfuly” icermedigini test edin.
            String actual=driver.findElement(By.id("result")).getText();
            String unexpected="successfuly";
            softAssert.assertFalse(actual.contains(unexpected));
            softAssert.assertAll();
        }
        @Test
    public void test3(){
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            //● Bir metod olusturun: sendKeysAlert
            //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
            driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
            driver.switchTo().alert().sendKeys("fatih");
            //      OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
            driver.switchTo().alert().accept();
            String  actual=driver.findElement(By.xpath("//*[.='You entered: fatih']")).getText();
            String expected="fatih";
            softAssert.assertTrue(actual.contains(expected));
             softAssert.assertAll();
        }



}
