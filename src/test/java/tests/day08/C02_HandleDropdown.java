package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void dropdownTesti() throws InterruptedException {
        // Dropdown'da var olan seceneklerden birirni secmek icin
        // 1, adim: Dropdown webelementini locate edip bir degiskene atiyoruz

        driver.get("https://www.amazon.com");
        WebElement dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2. adim: Select class'indan bir obje olusturalim
        // ve parametre olarak locate ettigimiz webelementi yazalim
        Select select=new Select(dropdownElementi);
        // 3. adim: select objesini kullanarak select classindan var olan 3 secim methodundan
        // istedigimizi kullanarak dropdown da var oaln option lardan birini secebiliriz
        // secim pamamiza yardim eden bu 3 method voidir dolayisiyla bize bir sey dondurmezler
        select.selectByIndex(3);

        // eger sectigimiz option degerini yazdirmak istersek
        System.out.println(select.getFirstSelectedOption().getText());//baby
        Thread.sleep(3000);
        select.selectByVisibleText("Deals");
        Thread.sleep(3000);
        select.selectByValue("search-alias=arts-crafts-intl-ship");

        List<WebElement> optionList= select.getOptions();
        for (WebElement each: optionList
             ) {
            System.out.println(each.getText());
        }
    }

    @AfterMethod
    public void tearown(){
        driver.close();
    }
}
