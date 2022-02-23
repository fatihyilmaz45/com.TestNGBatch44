package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_f extends TestBase {
    //1- https://www.facebook.com adresine gidelim
    //2- Yeni hesap olustur butonuna basalim
    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //4- Kaydol tusuna basalim

    @Test
    public void test6(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[.='Allow All Cookies']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement name= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys("g").keyUp(Keys.SHIFT).sendKeys("urhan").sendKeys(Keys.TAB).
                keyDown(Keys.SHIFT).sendKeys("t").keyUp(Keys.SHIFT).sendKeys("ugan").
                sendKeys(Keys.TAB).sendKeys("0123456789").sendKeys(Keys.TAB).sendKeys("12345").keyDown(Keys.SHIFT).sendKeys("d").keyUp(Keys.SHIFT).sendKeys("uhok")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("25").sendKeys(Keys.TAB)
                .sendKeys("Jan").sendKeys(Keys.TAB).
                sendKeys("1975").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

    }

}
