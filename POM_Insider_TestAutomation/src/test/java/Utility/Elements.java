package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elements {
    public Elements(){
        PageFactory.initElements(GWD.getDriver(),this);
    }
    @FindBy(xpath = "//a[text()='Login']") public WebElement login;
    @FindBy(xpath = "(//a[@id='navbarDropdownMenuLink'])[5]") public WebElement Company;
    @FindBy(css = "a.dropdown-sub[href='https://useinsider.com/careers/']")                                                                   public WebElement Careers;
    @FindBy(xpath = "//h3[contains(text(), 'Our Locations')]")                                                                                public WebElement OurLocations;
    @FindBy(xpath="//h2[contains(text(), 'Life at Insider')]")                                                                                public WebElement LifeAtInsider;
    @FindBy(xpath = "(//h3[@class='text-center mb-4 mb-xl-5'])[2]")                                                                           public WebElement Sales;
    @FindBy(xpath = "(//h1[contains(text() , 'Quality Assurance' )])[1]")                                                                     public WebElement QualityAssurance;
    @FindBy(css = "button[data-glide-dir='=2']")                                                                                              public WebElement glide2;
    @FindBy(xpath = "//a[contains(text(), 'See all QA jobs')]")                                                                               public WebElement SeeAllQajobs;
    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")                                                                         public WebElement DropIstanbul;
    @FindBy(xpath = "//span[@class='select2-selection__rendered' and @title='Quality Assurance']")                                            public WebElement currentResults;
    @FindBy(xpath = "//li[text()='Istanbul, Turkiye']")                                                                                       public WebElement istanbul;
    @FindBy(css = "span.totalResult")                                                                                                         public WebElement TotalResult;
    @FindBy(xpath = "((//div[@class='row'])[3]/div)[2]")                                                                                      public WebElement joblist;
    @FindBy(xpath = "//p[@class='position-title font-weight-bold']")                                                                          public WebElement jobs;
    @FindBy(xpath = "//span[@class='position-department text-large font-weight-600 text-primary' and contains(text(), 'Quality Assurance')]") public WebElement QaJobs;
    @FindBy(xpath ="//a[text()='Apply for this job']" )                                                                                       public WebElement ApplyJob;
    @FindBy(xpath = "//div[@class='posting-headline']/h2")                                                                                    public WebElement NewTitle;
    @FindBy(xpath = "//a[contains(@class, 'btn-navy') and contains(text(), 'View Role')]")
    public List<WebElement> ViewRoles;
    @FindBy(xpath = "//div[@class='position-list-item col-12 col-lg-4 qualityassurance istanbul-turkiye full-timeremote']")
    public List<WebElement> jobLists;
}
