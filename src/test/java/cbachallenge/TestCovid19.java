package cbachallenge;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestCovid19 {
	
String driverPath = "src/test/resources/geckodriver-v0.30.0-linux64/geckodriver";    
    WebDriver driver;    
    Covid19 objCovid19;
    Choosebattlefield objChoosebattlefield; 

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.gecko.driver", driverPath);        
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://responsivefight.herokuapp.com");
    }

    @Test(priority=1)
    public void verifyPageTitleTest() {
    	String title=driver.getTitle();
    	System.out.println("the page title is: "+title);
    	Assert.assertEquals(title,"COVID-19 THE GAME");
    }
    @Test(priority=2)
    public void verifyPageLogoTest() {
    	boolean flag = driver.findElement(By.xpath("//i[@class='material-icons']")).isDisplayed();
    	Assert.assertTrue(flag);
    }
    @Test(priority=3)
    public void verifyWarriorCreation() throws InterruptedException{
        //Create Login Page object
    	Covid19 objCovid19 = new Covid19(driver);
    //Verify landing page title   
    String PageName = objCovid19.getPageBanner();
    Assert.assertTrue(PageName.toUpperCase().contains("COVID-19 THE GAME"));
    objCovid19.setWarriorName("1234567");
    objCovid19.clickCreateWarrior();
    String popupmsg = objCovid19.getPopupmsg();
    boolean isNoWarning = (popupmsg==null);
    Assert.assertTrue(isNoWarning);
    if (!isNoWarning) System.out.println("pop up test is : "+popupmsg);

   
    }
    @AfterTest
    public void tearDown(){
          driver.quit();
       }
    
}
