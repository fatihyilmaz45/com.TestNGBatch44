package tests.day13;

import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_f {

    //"C:\Users\fatih\Desktop\Deneme\selenium.xlsx"
    @Test
    public void test2(){
        String path= System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx" ;
        System.out.println(path);//:C:\Users\fatih
        System.out.println("path2: " +System.getProperty("user.dir"));


        // Masaustunde deneme klasoru icerisinde selenium.xlsx isminde bir dosya oldugunu test edin
        // ******************** masaustunde Deneme klasoru ve icinde selenium.xlsx olmazsa CALISMAZ*****

        // 1. once bu dosyaya ulasmak icin gerekli dinamik path olusturulmali
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//true

        //projemizde pom.xml oldugunu test edin
        //C:\Users\fatih\IdeaProjects\com.TestNGBatch44\pom.xml
        String pomxml=System.getProperty("user.dir")+"\\pom.xml";
        System.out.println(Files.exists(Paths.get(pomxml)));
    }

}
