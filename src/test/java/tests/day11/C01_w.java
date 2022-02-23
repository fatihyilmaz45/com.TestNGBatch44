package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C01_w extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        //amazonu yazdirip handle degrini alin
        driver.get("https://www.amazon.com");
        String handle1= driver.getWindowHandle();
        System.out.println("ilk sayfanin window handle degeri : " +handle1);
        //bestbuy adresine "https://www.bestbuy.com" gidiniz
        //driver.switchTo().newWindow(WindowType.WINDOW);//yeni bir pencerede acildi
        driver.switchTo().newWindow(WindowType.TAB); // yeni bir sayfada acildi yaninda
        driver.get("https://www.bestbuy.com");
        //ikinci sayfanin handle degerini aliniz
        String handle2=driver.getWindowHandle();
        System.out.println("ikinci sayfanin window handle degeri : " +handle2);
        Set<String> handleSet=driver.getWindowHandles();
        System.out.println(handleSet);
        Thread.sleep(3000);
        //facebook adresine geciniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[.='Allow All Cookies']")).click();
        Thread.sleep(2000);
//        String handle3=driver.getWindowHandle();
//        System.out.println("ucuncu sayfanin window handle degeri : " +handle3);
        // amazon'un acik oldugu sayfaya gecin ve nutella icin arama yapin
        driver.switchTo().window(handle1);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // bestbuy acik olan sayfaya gecin ve title'in Best Buy icerdigini test edin
        handleSet= driver.getWindowHandles();
        driver.switchTo().window(handle2);
        String actTitle=driver.getTitle();
        String expTitle="Best Buy";
        Assert.assertTrue(actTitle.contains(expTitle));

        // facebook'un acik oldugu sayfaya gecin
      //  driver.switchTo().window(handle3);
        String  handle3="";
        for (String w: handleSet
             ) {
            if (!(w.equals(handle1) || w.equals(handle2))){
                handle3=w;
            }
        }
        System.out.println(handle3);
        System.out.println(handleSet);
        // ve url'in https://www.facebook.com oldugunu test edin
        // eger acik olan pencerelerden sadece bir tanesinin window handle degeri bilinmiyorsa
        // once tum handle degerlerini bulup bir set'e koyariz
        // bu soru icin su anda set'te 3 window handle degeri var
        // 1. ve 2/ sayfanin window handle degerlerini biliyoruz
        // setimizde olup, ilk iki sayfa olmayan handle degeri 3.sayfanin handle degeri olacaktir
       // String windowHandleDegeri3="";

        }

    }

