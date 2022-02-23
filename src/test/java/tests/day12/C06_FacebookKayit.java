package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookKayit extends TestBase {
    //Yeni bir class olusturalim: D15_MouseActions4

    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@title='Allow All Cookies']")).click();
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions. keyDown(Keys.SHIFT).
                sendKeys("e").
                keyUp(Keys.SHIFT).
                sendKeys("mine ").
                sendKeys(Keys.TAB).
                keyDown(Keys.SHIFT).
                sendKeys("c").
                keyUp(Keys.SHIFT).
                sendKeys("eyran").
                sendKeys(Keys.TAB).
                sendKeys("01234568").
                sendKeys(Keys.TAB).
                sendKeys("1234565").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("28").
                sendKeys(Keys.TAB).
                sendKeys("Jan").
                sendKeys(Keys.TAB).
                sendKeys("1983").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_LEFT).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();
        //4- Kaydol tusuna basalim
    }
}