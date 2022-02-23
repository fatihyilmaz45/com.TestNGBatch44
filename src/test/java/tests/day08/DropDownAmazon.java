package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDownAmazon {
     //● Bir class oluşturun: C3_DropDownAmazon
        //● https://www.amazon.com/ adresine gidin.
        //- Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        //-Test 2
        //    1. Kategori menusunden Books secenegini  secin
        //    2. Arama kutusuna Java yazin ve aratin
        //    3. Bulunan sonuc sayisini yazdirin
        //    4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;
    WebElement dropDownElementi;
    Select select;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void test01(){
        //● https://www.amazon.com/ adresine gidin.
        //- Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        driver.get("https://www.amazon.com/");
        dropDownElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropDownElementi);
        List<WebElement> optionListesi=select.getOptions();
//        int actualOptionSayisi=optionListesi.size();
//        int expectedOptionSayisi=45;
//        Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi);

    }

    @Test
    public void test02(){
        //-Test 2
        //    1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Books");
        //    2. Arama kutusuna Java yazin ve aratin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);
        //    3. Bulunan sonuc sayisini yazdirin
        WebElement bulunanSonucElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String bulunanSonucSayisi=bulunanSonucElementi.getText();
        System.out.println(bulunanSonucSayisi);
        //    4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(bulunanSonucSayisi.contains("Java"));
    }
    @AfterClass
    public void tearDown(){
      // driver.close();
    }
}
