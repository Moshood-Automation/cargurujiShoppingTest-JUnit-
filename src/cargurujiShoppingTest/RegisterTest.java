package cargurujiShoppingTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class RegisterTest {
	
    WebDriver driver;
	public int random;
	
		
	

    @Before
    public void setUp(){
      driver = new ChromeDriver();
	  driver.manage().window().maximize();
      driver.navigate().to("http://carguruji.com/shop/");
      driver.manage().deleteAllCookies();
    //This code is for synchronisation in test automation i.e: causes 2 or more events to occur at exactly the same time, rate or with coordinated timing. 
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
	@Test
	public void RegisterNewuser() throws InterruptedException {
	  driver.findElement(By.cssSelector("div.header_user_info")).click();
	  
	  //     THIS GENERATES RANDOM EMAIL ADDRESS
	  random = 1000000 + (int)(Math.random() * ((1000 - 1) + 1));
	  System.out.println(random);
	  driver.findElement(By.cssSelector("input#email_create")).sendKeys("mosh" + random + "@yahoo.com");
	  //Thread.sleep(5000);
	  driver.findElement(By.cssSelector("button#SubmitCreate")).click();
	  driver.findElement(By.cssSelector("input#id_gender1")).click();
	  //Thread.sleep(5000);
	  driver.findElement(By.cssSelector("input#customer_firstname")).sendKeys("mosh");
	  driver.findElement(By.cssSelector("input#customer_lastname")).sendKeys("agbosasa");
      driver.findElement(By.cssSelector("input#passwd")).sendKeys("Isaac");
	 
      // THIS WILL PRINT OUT LIST OF ALL HIDDEN WEBELEMENT IN A DROP DOWN FIELD
      List<WebElement> options = driver.findElements(By.cssSelector("select#days"));
      for (int i=0; i<options.size(); i++) {
      System.out.println(options.get(i).getText());
      }
      
      Select drpDay = new Select(driver.findElement(By.cssSelector("select#days")));
	  drpDay.selectByValue("10");
     
      
     
       List<WebElement> options1 = driver.findElements(By.id("months"));
       for (int i=0; i<options1.size(); i++) {
       System.out.println(options1.get(i).getText());
       }
       
	  Select drpMonth = new Select(driver.findElement(By.cssSelector("select#months")));
	  drpMonth.selectByIndex(3);
     
	  List<WebElement> options2 = driver.findElements(By.cssSelector("select#years"));
      for (int i=0; i<options2.size(); i++) {
      System.out.println(options2.get(i).getText());
      }
      
      Select drpYear = new Select(driver.findElement(By.cssSelector("select#years[class='form-control']")));
  	  drpYear.selectByValue("1999");
      
  	  driver.findElement(By.cssSelector("input#newsletter")).click();
  	  driver.findElement(By.cssSelector("button#submitAccount")).click();
     
	  String ExpectedMessage = "Your account has been created.";
      String ActualMessage = driver.findElement(By.cssSelector("p.alert")).getText();
      
      if (ExpectedMessage.equals(ActualMessage)) {
    	  System.out.println("Pass"); 
      }else {
    	  System.out.println("Fail");
      }
      
      Assert.assertEquals(ExpectedMessage, ActualMessage);
      //Thread.sleep(5000);
      System.out.println(ActualMessage);
      
	}
	@After
	public void TearDown(){
	driver.close();
	  //driver.quit();
	}
	
	
	
	
	
	
	
	
}
	
	

