package tests.homeWorksMerveHoca;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\melek\\Documents\\selenium dependencies\\drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://id.heroku.com/login");


        WebElement userElement = driver.findElement(By.cssSelector("input#email"));
        userElement.sendKeys("aliseleniumcu@gmail.com");

        WebElement userPass= driver.findElement(By.cssSelector("input#password"));
        userPass.sendKeys("test@123");

        WebElement loginBtn= driver.findElement(By.id("login"));
        loginBtn.click();
        WebElement expectedResult=driver.findElement(By.cssSelector("form[role='form'] > div[role='alert']"));

        if (expectedResult.isDisplayed()) {
            System.out.println("kayit yapilamadi");
        } else {
            System.out.println("kayit yapildi");

        }
        driver.close();
    }
}
