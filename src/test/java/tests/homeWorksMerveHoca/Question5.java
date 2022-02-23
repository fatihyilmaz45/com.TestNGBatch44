package tests.homeWorksMerveHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Question5 {

//● https://www.amazon.com/ adresine gidin.
//            - Test 1
//    Arama kutusunun yanindaki kategori menusundeki kategori
//    sayisinin 45 oldugunu test edin
//-Test 2
//            1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin

    static WebDriver driver;
    @Test
    public void test01() {
        List<WebElement> kategori= driver.findElements(By.xpath("//option"));
        int kategoriSayisi = kategori.size();
        System.out.println(kategoriSayisi);
        if (kategoriSayisi == 45) {
            System.out.println("Menudeki kategori sayisi 45");
        } else {
            System.out.println("Menudeki kategori sayisi 45 degil");
            System.out.println("Menudeki kategori sayisi : " + kategoriSayisi);
        }
    }
    @Test
    public void test02() {
        driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).click();
        driver.findElement(By.xpath("//option[@value='search-alias=stripbooks-intl-ship']")).click();

        WebElement aramaBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaBox.sendKeys("Java"+ Keys.ENTER);

        String sonucSayisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(sonucSayisi);

        String sonuc="Java";
        if (sonucSayisi.contains(sonuc)) {
            System.out.println("Java kelimesi iceriyor");
        }else{
            System.out.println("Java kelimesi icermiyor");
        }
    }
    @BeforeClass
    public static void baslangic() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @AfterClass
    public static void son() {
        driver.close();
    }

}
