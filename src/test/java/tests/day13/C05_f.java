package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_f extends TestBase {
    //Tests packagenin altina bir class oluşturun : C05_UploadFile
    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.
    //Upload butonuna basalim.
    //“File Uploaded!” textinin goruntulendigini test edelim

    @Test
    public void test05(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload=driver.findElement(By.id("file-upload"));
        String excelpath=System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx";
        upload.sendKeys(excelpath);
        driver.findElement(By.id("file-submit")).click();

        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
    }
}
