package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_k extends TestBase {
    //1- Bir Class olusturalim KeyboardActions1
    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    //4- aramanin gerceklestigini test edin

    @Test
    public void test5(){
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        //aramaKutusu.sendKeys("Samsung A71"+ Keys.ENTER);
       actions.click(aramaKutusu).
               keyDown(Keys.SHIFT).sendKeys("s").keyUp(Keys.SHIFT).sendKeys("amsung ").
               keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("71").sendKeys(Keys.ENTER).perform();

        String actTitle= driver.getTitle();
        String expectedtitle="Samsung A71";
        Assert.assertTrue(actTitle.contains(expectedtitle));

    }
}
