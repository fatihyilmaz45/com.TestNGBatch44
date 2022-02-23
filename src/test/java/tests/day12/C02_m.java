package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_m extends TestBase {
    // amazon anasayfaya gidin
    // sag ustte hello,signIn elementinin uzerinde mouse'u bekletin
    // acilan menude new list linkine tiklayin
    // ve new list sayfasinin acildigini test edin

    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement helloElementi= driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(helloElementi).perform();
        driver.findElement(By.xpath("//span[.='Create a List']")).click();

        String ac=driver.getTitle();
        String ex="Your List";
        Assert.assertEquals(ac,ex,"galat list");
    }

}
