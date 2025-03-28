package Utility;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GWD {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver==null){
            driver= new ChromeDriver();
            driver.manage().window().setPosition(new Point(1000,0));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
        return driver;
    }
    public static void quitDriver(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
