package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {
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
    WebElement dropdownElementi;
    Select select;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        //● https://www.amazon.com/ adresine gidin.
        //- Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        driver.get("https://www.amazon.com/ ");
        dropdownElementi= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        select = new Select(dropdownElementi);
        List<WebElement> optionListesi=select.getOptions();
        int actualOptionSayisi=optionListesi.size();
        int expectedOptionSayisi=45;
        Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi);


    }

    @Test
    public void test2(){
        //-Test 2
        //	1. Kategori menusunden Books secenegini  secin

        select.selectByVisibleText("Books");
        //	2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        //	3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiElementi=driver.
                findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        //	4. Sonucun Java kelimesini icerdigini test edin

        String actualSonucSayisiYazisi=sonucSayisiElementi.getText();
        String arananKelime="Java";

        Assert.assertTrue(actualSonucSayisiYazisi.contains(arananKelime),"Arama sonucu Java icermiyor");

    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
