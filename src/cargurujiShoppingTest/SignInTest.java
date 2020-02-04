package cargurujiShoppingTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInTest {

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
		//This code is for synchronisation in WebDriver i.e: causes 2 or more events to occur at exactly the same time, rate or with coordinated timing. 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	 public void SignInWithValidDetails() throws InterruptedException {
		driver.findElement(By.cssSelector("div.header_user_info")).click();
		driver.findElement(By.cssSelector("input#email")).sendKeys("mosh.agbosasa@yahoo.com");
		driver.findElement(By.cssSelector("input#passwd")).sendKeys("Isaac");
		driver.findElement(By.cssSelector("button#SubmitLogin")).click();
		
		String ExpectedMessage = "Sign out";
	    String ActualMessage = driver.findElement(By.cssSelector("a.logout")).getText();
		System.out.println(ActualMessage);
		//Thread.sleep(5000);
	}
	
	@Test
    public void SignInWithValidEmailAndInvalidPassword() throws InterruptedException {
		driver.findElement(By.cssSelector("div.header_user_info")).click();
		driver.findElement(By.cssSelector("input#email")).sendKeys("mosh.agbosasa@yahoo.com");
		driver.findElement(By.cssSelector("input#passwd")).sendKeys("Alan");
		driver.findElement(By.cssSelector("button#SubmitLogin")).click();
		
		String ExpectedMessage = "Invalid password.";
	    String ActualMessage = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li")).getText();
		System.out.println(ActualMessage);
		//Thread.sleep(5000);
	}
	
   @Test
   public void SignInWithInvalidEmailAndValidPassword() throws InterruptedException {
	   driver.findElement(By.cssSelector("div.header_user_info")).click();
	   driver.findElement(By.cssSelector("input#email")).sendKeys("mosh.agbo@yahoo.com");
	   driver.findElement(By.cssSelector("input#passwd")).sendKeys("Isaac");
	   driver.findElement(By.cssSelector("button#SubmitLogin")).click();
	   //Thread.sleep(5000);/*
	   
	   String ExpectedMessage = "Authentication failed.";
	   String ActualMessage = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li")).getText();
	   System.out.println(ActualMessage);
	  // Thread.sleep(5000);
  }
   
   @Test
   public void SignInWithBlankEmailAndPassword() throws InterruptedException {
	   driver.findElement(By.cssSelector("div.header_user_info")).click();
	   driver.findElement(By.cssSelector("button#SubmitLogin")).click();
	
	   String ExpectedMessage = "An email address required.";
	   String ActualMessage = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li")).getText();
	   System.out.println(ActualMessage);
	  // Thread.sleep(5000);
   }


   @After
	public void TearDown() {
	driver.close();
	//driver.quit();
}

}


















