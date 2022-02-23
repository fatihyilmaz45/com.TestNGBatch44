package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_d extends TestBase {
    // //Yeni bir class olusturalim: MouseActions2
    //    //1- https://demoqa.com/droppable adresine gidelim
    //    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    @Test
    public void test01(){
        driver.get(" https://demoqa.com/droppable");
        Actions actions= new Actions(driver);
        WebElement drag= driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag,drop).perform();

        String  act=driver.findElement(By.xpath("//p[.='Dropped!']")).getText();
        String exp="Dropped!";
        Assert.assertTrue(act.equals(exp),"olmadi llaaaa");

    }
}
