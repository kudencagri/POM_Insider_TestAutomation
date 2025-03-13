package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyFunc {
    WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(40));

    public void myClick(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void JsClickToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();",element);
    }
    public void mySelect(WebElement element1,WebElement element2,WebElement secim){
        wait.until(ExpectedConditions.elementToBeClickable(element1));
        element2.click();
        wait.until(ExpectedConditions.elementToBeClickable(secim));
        secim.click();
    }
}
