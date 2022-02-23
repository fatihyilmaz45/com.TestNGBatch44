package tests.day12;

import org.testng.annotations.Test;
import tests.day10.C01_Allerts;
import utilities.TestBase;

public class C01_TestBaseKullanim {

    @Test
    public void test01(){
        //projeniz icerisindeki herhangi bir class dan obje olusturabilir
        //ve o obje sayesinde ait oldugu classdaki tum variable ve methodlara
        //(access modifier izin verdigi surece) methodlara ulasabilirim
        C01_Allerts obj=new C01_Allerts();


        //eger proje kapsaminda bir classdan obje olusturulmasini engellemek isterseniz
        // 1. o class'in constructor'ini  private yaparsiniz
        // 2. class'in kendisini abstract yapabiliriz
        // 1. method cok tercih edilemz cunku OOP concept'ine uymaz(cok sinirli sayida kullanimi vardir)
        // 2. method u kullanabiliriz boylece o calssdaki abstract olmayan(concrete) methodlari
        // override etmek mecburiyeti olmadan kullanabiliriz
        // ama obje olusturamayiz
        // ornegin biz TESTBase classini abstract yaptigimizdan obje olusturamayiz
        // ama child class'lardan TestBase deki setUp ve tearDown methodlarini kullanabiliriz

       // TestBase obj1=new TestBase();
    }

}
