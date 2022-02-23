package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C02_w extends TestBase {
    SoftAssert softAssert;
    @Test
    public void test02(){
        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String handle1= driver.getWindowHandle();
        System.out.println(handle1);
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String  act=driver.findElement(By.tagName("h3")).getText();
        String exp="Opening a new window";
        softAssert=new SoftAssert();
        softAssert.assertTrue(act.equals(exp),"naberloo");
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actTitle= driver.getTitle();
        String expTitle="The Internet";
        softAssert.assertTrue(actTitle.equals(expTitle),"siitttttir looo");
        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        String handle2="";
        Set<String> handleSet=driver.getWindowHandles();
        for (String w:handleSet
             ) {
            if(!w.equals(handle1)){
                handle2=w;
            }
        }
        System.out.println(handle2);
        System.out.println(handleSet);
        driver.switchTo().window(handle2);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actTitle2= driver.switchTo().window(handle2).getTitle();
        String expTitle2="New Window";
        softAssert.assertTrue(actTitle2.equals(expTitle2),"oglumm yanlis yapiyon lllaaaa!!!");
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String acc=driver.findElement(By.tagName("h3")).getText();
        String exxx="New Window";
        softAssert.assertTrue(acc.equals(exxx));
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        softAssert.assertTrue(driver.switchTo().window(handle1).getTitle().contains("The Internet"));

        softAssert.assertAll();
    }
}
