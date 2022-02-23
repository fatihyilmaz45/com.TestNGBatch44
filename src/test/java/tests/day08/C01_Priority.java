package tests.day08;

import org.testng.annotations.Test;

public class C01_Priority {

    @Test(priority = 9)
    public void youtubeTest(){
        System.out.println("Youtube testi calisti");

    }

    @Test
    public void amazonTest(){//priority atanmazsa priority=0 kabul eder
        System.out.println("Amazon testi calisti");

    }
    @Test
    public void bestbuyTest(){
        System.out.println("Bestbuy testi calisti");

    }
}
