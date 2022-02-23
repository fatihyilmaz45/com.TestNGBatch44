package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitlyWait() , explicitlyWait()
    //     Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //     Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']\n")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        Thread.sleep(3000);
        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
        Thread.sleep(3000);
    }

    @Test
    public void explicitlyWaitTest() throws InterruptedException {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //explicitlyWai kullanabilmek icin once wait objesi olustur
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']\n")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
       /*
        WebElement itsGoneElementi= driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneElementi));

        her ne kadar once lovcate edelim sonra bekleyelim anlayisi guzel gorunse de
        web element zaten gorunur olmadigindan locate etmemeiz mumkun olmayacaktir
         bu durumda locate ve bekleme isini birlikte yapmaliyiz
        */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement itsGoneElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        Thread.sleep(3000);
        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        //7. It’s back mesajinin gorundugunu test edin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement itsBackElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
        Thread.sleep(3000);

    }
}
