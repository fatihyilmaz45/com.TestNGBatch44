package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_e extends TestBase {
    @Test
    public void test2(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']\n")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement ew= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(ew.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement istback= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(istback.isDisplayed());
    }
}
