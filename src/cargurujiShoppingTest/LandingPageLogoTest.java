package cargurujiShoppingTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPageLogoTest {
	
	
	public WebDriver driver;

    @Before
    public void setUp(){
      System.setProperty("webdriver.chrome.driver", "\\chromedriver.exe");
   	  driver = new ChromeDriver();
   	  
   	 //UNCOMMENT THE TWO LINES OF CODE BELOW TO RUN TEST IN FIREFOX BROWSER
      //System.setProperty("webdriver.gecko.driver", "\\geckodriver.exe");			
	  //driver = new FirefoxDriver();
      
      //UNCOMMENT THE TWO LINES OF CODE BELOW TO RUN TEST IN INTERNET EXPLORER BROWSER
      //System.setProperty("webdriver.ie.driver", "\\IEDriverServer.exe");
	  //driver = new InternetExplorerDriver();
   	  
	  driver.manage().window().maximize();
      driver.navigate().to("http://carguruji.com/shop/");
      driver.manage().deleteAllCookies();
    //This code is for synchronisation in test automation i.e: causes 2 or more events to occur at exactly the same time, rate or with coordinated timing. 
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @Test
    public void VerifyPageLogos() {
    	boolean TwitterLogo = driver.findElement(By.cssSelector("li.twitter")).isDisplayed();
    	Assert.assertTrue(TwitterLogo);
    	System.out.println("Twitter Logo is present");
 
    	boolean FacebookLogo = driver.findElement(By.cssSelector("li.facebook")).isDisplayed();
    	Assert.assertTrue(FacebookLogo);
    	System.out.println("Facebook Logo is present");
    }
    
    @After
    public void tearDown() {
     driver.close();	
     //driver.quit();	
    }
	
	

}
