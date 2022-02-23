package tests.day13;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_s extends TestBase {

    @Test
    public void test6(){
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-submit")).click();
    }
}
