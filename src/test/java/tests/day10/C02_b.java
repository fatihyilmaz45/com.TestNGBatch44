package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_b extends TestBase {
    @Test
    public void test2(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
      //  driver.get("https://the-internet.herokuapp.com/basic_auth");

        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //    Html komutu : https://username:password@URL
        //    Username     : admin
        //    password      : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        // basic authentication isteyen web servisleri bize nasil
        // ve hangi bilgilerle authentication yapabilecgimiz bilgisini devermek zorundadir
        // bizde bize tarif edilen yontem ve bize verilen bilgileri birebir uyguulayarak istedigimiz
        // web servise giris saglayabiliriz
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement congrat= driver.findElement(By.tagName("p"));
        Assert.assertTrue(congrat.isDisplayed());
    }
}
