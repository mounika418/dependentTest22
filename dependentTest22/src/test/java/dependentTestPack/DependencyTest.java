package dependentTestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DependencyTest {

	public static WebDriver driver;
	
  @Test (dependsOnMethods = "LaunchBrowser")
  public void SignIn() throws Exception {
  
	  driver.findElement(By.id("usernameId")).sendKeys("MounikaS");
	  
	  Thread.sleep(2000);
	  
	  driver.findElement(By.className("loginPassword")).sendKeys("Myh620");
	  
	  Thread.sleep(2000);
	  
	  driver.findElement(By.id("otpId")).click();
	  
	  Thread.sleep(2000);
	  
	  driver.findElement(By.id("loginbutton")).click();
	  
	  Thread.sleep(2000);
  }
  
  @Test
  public void LaunchBrowser() throws Exception
  {
	  driver = new FirefoxDriver();
	  
	  Thread.sleep(2000);
	  
	  driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	  
	  Thread.sleep(2000);
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  Thread.sleep(2000);
  }
  
  @Test (dependsOnMethods = "SignIn")
  public void LogOut() throws Exception
  {
	 driver.findElement(By.xpath("//ul[@id='topnav']/li[7]/ul/li[5]/a/span")).click();
	 
	 Thread.sleep(2000);
	 
	 driver.quit();
  }
}
