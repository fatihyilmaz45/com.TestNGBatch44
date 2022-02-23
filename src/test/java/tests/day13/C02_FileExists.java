package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home"));//C:\Users\fatih

        // masaustundeki deneme klasorunun pathini istesem
        //"C:\Users\fatih\Desktop\Deneme\selenium.xlsx"

        //yani dinamik olarak masa ustundeki deneme kalsorunun pathini yazmak istersem

        String path=System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx";
        System.out.println(path);

        System.out.println("user.dir : "+System.getProperty("user.dir"));//user.dir : C:\Users\fatih\IdeaProjects\com.TestNGBatch44

        // Masaustunde deneme klasoru icerisinde selenium.xlsx isminde bir dosya oldugunu test edin
        // ******************** masaustunde Deneme klasoru ve icinde selenium.xlsx olmazsa CALISMAZ*****

        // 1. once bu dosyaya ulasmak icin gerekli dinamik path olusturulmali
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));//true

        //projemizde pom.xml oldugunu test edin
        //C:\Users\fatih\IdeaProjects\com.TestNGBatch44\pom.xml
        System.out.println(System.getProperty("user.dir"));//projenin yolunu verir
        //C:\Users\fatih\IdeaProjects\com.TestNGBatch44

        String pomPath=System.getProperty("user.dir") +"\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));





    }
}
