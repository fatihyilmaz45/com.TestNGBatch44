package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_Screenshot extends TestBase {

    @Test
    public void screenTest() throws IOException {
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
        //1. adim: Screenshot almak icin obje olusturalim ve degr olarak driver imizi atayalim
        // deger olarak driveri kabul etmesi icin xasting yapmamiz gerekir
        TakesScreenshot tss= (TakesScreenshot) driver;

        //2. adim: tum sayfanin screenshot ini almak icin bir file olusturalim ve dosya yolunu belirtelim

        File tumSayfaSS= new File("src//tumSayfa.png");

        //3. adim: Olustuerdugumuz file ile takescreenshot objesini iliskilendirelim
        tumSayfaSS=tss.getScreenshotAs(OutputType.FILE);

        // eger specific bir webelementin screenshot ini almak istiyorsaniz

        WebElement logoElementi= driver.findElement(By.xpath("(//img[@alt='Google'])[1]"));
       // File logoResmi=new File("src/logo.png");
       // logoElementi=logoResm
        FileHandler.copy(tumSayfaSS, new File("src\\tumSayfa.png"));
    }
}
