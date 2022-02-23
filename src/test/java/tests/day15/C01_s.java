package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_s extends TestBase {
    @Test
    public void test1() throws IOException, InterruptedException {
        // amazon ana sayfaya gidelim
        driver.get("https://amazon.com");
        // nutella icin arama yapalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // sonuclarin nutella icerdigini test edelim
        WebElement sonucNutellaYazisielementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonuc=sonucNutellaYazisielementi.getText();
        String expectedSonuc="Nutella";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));
        // testin calistiginin ispati icin tum sayfamim screenshot ini alalim

        // tum sayfa screenshot icin 4 adim gerekli
        // 1. adim TakeScreenShot objesi olusturmak
        TakesScreenshot tss=(TakesScreenshot)  driver;
        //2. adim kaydedecegimiz dosyayi olusturalim
        File tumSayfaSS=new File("target/screenFoto/tumSayfa.png");
        //3.adim bir dosya daha olusturup screenshot objesi ile screenshot i alalim
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        // 4. adim: gecici resmi kaydetmek istedigimiz asil dosyaya copy edelim
        FileUtils.copyFile(geciciResim,tumSayfaSS);
        Thread.sleep(3000);













    }
}
