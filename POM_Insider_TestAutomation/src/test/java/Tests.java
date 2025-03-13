import Utility.Elements;
import Utility.GWD;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Tests extends GWD {
    Elements elm=new Elements();
    MyFunc myFunc= new MyFunc();
    Actions actions=new Actions(getDriver());
    WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(40));

    @Test
    public void SystemControl(){
        getDriver().get("https://useinsider.com/");
        Assert.assertTrue(elm.login.isDisplayed());
        quitDriver();

    }
    @Test
    public void CarrersPageControl(){
        getDriver().get("https://useinsider.com/");
        myFunc.myClick(elm.Company);
        myFunc.myClick(elm.Careers);
        myFunc.scrollToElement(elm.OurLocations);
        Assert.assertTrue(elm.OurLocations.isDisplayed());
        myFunc.scrollToElement(elm.LifeAtInsider);
        Assert.assertTrue(elm.LifeAtInsider.isDisplayed());
        myFunc.scrollToElement(elm.Sales);
        Assert.assertTrue(elm.Sales.isDisplayed());
        quitDriver();

    }
    @Test
    public void QualityAssurance(){
        getDriver().get("https://useinsider.com/careers/quality-assurance/");
        myFunc.scrollToElement(elm.QualityAssurance);
        Assert.assertTrue(elm.QualityAssurance.isDisplayed());
        myFunc.scrollToElement(elm.glide2);
        myFunc.JsClickToElement(elm.glide2);
        myFunc.myClick(elm.SeeAllQajobs);
        myFunc.mySelect(elm.currentResults,elm.DropIstanbul, elm.istanbul);
        myFunc.scrollToElement(elm.jobs);
        Assert.assertTrue(elm.jobs.isDisplayed());
        Assert.assertTrue(elm.joblist.isDisplayed());
        quitDriver();

    }
    @Test
    public void JobsControl() {
        getDriver().get("https://useinsider.com/careers/open-positions/?department=qualityassurance");
        myFunc.mySelect(elm.currentResults,elm.DropIstanbul, elm.istanbul);
        myFunc.scrollToElement(elm.jobs);
        Assert.assertTrue(elm.jobs.isDisplayed());
        Assert.assertTrue(elm.joblist.isDisplayed());
        wait.until(driver -> elm.TotalResult.getText().trim().equals("3"));
        myFunc.scrollToElement(elm.QaJobs);
        Assert.assertTrue(elm.QaJobs.isDisplayed());
        for (WebElement job : elm.jobLists){
            String position = job.findElement(By.xpath("//span[text()='Quality Assurance']")).getText();
            String location = job.findElement(By.xpath("//div[text()='Istanbul, Turkiye']")).getText();
            if (position.contains("Quality Assurance") && location.contains("Istanbul")) {
                System.out.println("Job position:Passed");
            } else {
                System.out.println("Job position:Failed");
            }
        }
        quitDriver();

    }
    @Test
    public void ViewRole() {
        getDriver().get("https://useinsider.com/careers/open-positions/?department=qualityassurance");
        myFunc.mySelect(elm.currentResults, elm.DropIstanbul, elm.istanbul);
        myFunc.scrollToElement(elm.jobs);
        Assert.assertTrue(elm.jobs.isDisplayed());
        Assert.assertTrue(elm.joblist.isDisplayed());
        wait.until(driver -> elm.TotalResult.getText().trim().equals("3"));
        myFunc.scrollToElement(elm.QaJobs);
        Assert.assertTrue(elm.QaJobs.isDisplayed());
        actions.sendKeys(Keys.PAGE_UP).build().perform();

        for (WebElement view : elm.ViewRoles){
            view.click();
            String mainWindow=getDriver().getWindowHandle();
            Set<String> allWindows=getDriver().getWindowHandles();
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(mainWindow)) {
                    getDriver().switchTo().window(windowHandle);
                    break;
                }
            }
            System.out.println("jobTitle = " + elm.NewTitle.getText());
            Assert.assertTrue(elm.ApplyJob.isDisplayed());
            getDriver().close();
            getDriver().switchTo().window(mainWindow);
        }
        quitDriver();

    }
//    @AfterMethod
//    public void takeScreenshot(ITestResult result) throws IOException {
//        System.out.println("Test Durumu: " + result.getStatus());
//        if (result.getStatus() == ITestResult.FAILURE) {
//            System.out.println("hata oldu");
//            TakesScreenshot ts=(TakesScreenshot) GWD.getDriver();
//            File hafidakiHali=ts.getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(hafidakiHali, new File("screenshots\\screenshot.png"));
//
//
//        }
//        quitDriver();
//    }
}
