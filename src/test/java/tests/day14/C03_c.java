package tests.day14;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_c extends TestBase {
    @Test
    public void test3(){
        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> allCookies= driver.manage().getCookies();
        System.out.println(allCookies);
        int sayac=1;
        for (Cookie each:allCookies
             ) {
            System.out.println(sayac + ". cookie: " +each);
            sayac++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(allCookies.size()>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        Cookie cookiei18n=driver.manage().getCookieNamed("i18n-prefs");
        System.out.println("cookie degeri: " + cookiei18n);
        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals("USD"));
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie myCookie=new Cookie("en sevdigim cikolata", "Nutella");
        driver.manage().addCookie(myCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Set<Cookie> allCookies2= driver.manage().getCookies();
        System.out.println(allCookies);
        sayac=1;
        for (Cookie each:allCookies2
        ) {
            System.out.println(sayac + ". cookie: " +each);
            sayac++;
        }
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Set<Cookie> allCookies3= driver.manage().getCookies();
        System.out.println(allCookies);
        sayac=1;
        for (Cookie each:allCookies3
        ) {
            System.out.println(sayac + ". cookie: " +each);
            sayac++;
        }
        Assert.assertFalse(allCookies3.contains(driver.manage().getCookieNamed("skin")));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Set<Cookie> allCookies4= driver.manage().getCookies();
        Assert.assertFalse(allCookies4.size()==1);
    }
}
