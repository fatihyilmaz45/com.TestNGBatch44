package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.domstorage.model.DomStorageItemRemoved;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_m extends TestBase {
    //1- Yeni bir class olusturalim: MouseActions1
    @Test
    public void test01() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement cizili=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(cizili).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String act=driver.switchTo().alert().getText();
        String ex="You selected a context menu";
        Assert.assertEquals(act,ex,"Lan biraaak");



        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHandle=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[.='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
       String ikincihandle="";
       Set<String> handledegerleri=driver.getWindowHandles();
        for (String w:handledegerleri
             ) {
            if(!w.equals(ilkSayfaHandle)){
                ikincihandle=w;
            }
        }
        driver.switchTo().window(ikincihandle);

        String a= driver.findElement(By.tagName("h1")).getText();
        String e="Elemental Selenium";
        Assert.assertEquals(a,e);

    }
}
