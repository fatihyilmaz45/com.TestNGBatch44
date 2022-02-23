package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuterClick extends TestBase {
    // amazon.com anasayafaya gidip
    // sell linkine JSExecuter ile tiklayalim
    //ilgili sayfaya gittigimizi test edelim
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");

        //1. adim: javascriptExecuter kullanmak icin ilk adim olarak driverimizi JavascriptExecuter'a cast edelim
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        //2. adim: kullanacagimiz WebElementi locate edelim
        WebElement sellElementi= driver.findElement(By.xpath("//a[normalize-space()='Sell']"));
        //3. adim: ilgili script ve argument(bizim web elenmentimiz) ile objemeiz uzerinden
        // executeScript methodunu calistiralim
        jse.executeScript("arguments[0].click;",sellElementi);

        Thread.sleep(5000);
    }
}
