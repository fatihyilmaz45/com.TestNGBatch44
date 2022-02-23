package tests.homeWorksMerveHoca;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.youtube.com");

        String title= driver.getTitle();

        System.out.println(title);

        if (title.equals("YouTube")){
            System.out.println("CORRECT TITLE");
        }else{
            System.out.println("INCORRECT TITLE");
        }



        driver.close();


        driver.quit();

        System.out.println("Test is completed");
    }
}
