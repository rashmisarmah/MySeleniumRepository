//This Test Case follows the below steps in short:
//Login from the Home screen first with wrong Credentials.
//Login from the Sign-On link tab with wrong Credentials.
//Login again from Sign-On link tab with correct Credentials.
//After successful login verify Sign-On link tab now becomes "Sign-OFF" link tab.

package demo.page.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC03_SignOn_wrongCred {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void launchDemoPage(){
	String browser = "Mozilla";
		
	if(browser == "Mozilla"){
		//System.setProperty("webdriver.gecko.driver", "/Users/Rashmi/Documents/NewWorkSpace/Projects/DemoPage/DemoPageProject/geckodriver");
		driver = new FirefoxDriver();
	}else if (browser == "Chrome"){
		//System.setProperty("webdriver.chrome.driver", "/Users/Rashmi/Documents/NewWorkSpace/Projects/DemoPage/DemoPageProject/chromedriver");
		driver = new ChromeDriver();
	}
		
	//maximize the browser before launching
	driver.manage().window().maximize();
		
	//implicit wait
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	//launch URL
	driver.get("http://newtours.demoaut.com/");
			
}
	
	@AfterTest
	public void afterTest_Quit(){
		driver.quit();
	}	
	
	
	//TestCase starts from here.
	@Test
	public void wrongCred(){
		
		//Signing from Home screen with wrong Cred
		driver.findElement(By.name("userName")).click();
		driver.findElement(By.name("userName")).sendKeys("abc");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("abc");
		driver.findElement(By.xpath("//*[contains(text(),'User')]")).click();
		driver.findElement(By.name("login")).click();
		
		//Signing from Sign-On link tab with wrong Cred
		driver.findElement(By.name("userName")).click();
		driver.findElement(By.name("userName")).sendKeys("xyz");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("xyz");
		driver.findElement(By.xpath("//*[contains(text(),'User')]")).click();
		driver.findElement(By.name("login")).click();
		
		//Signing from Sign-On link tab with correct Cred
		driver.findElement(By.name("userName")).click();
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.xpath("//*[contains(text(),'User')]")).click();
		driver.findElement(By.name("login")).click();
		
		//Signing OFF from the flight booking page
		driver.findElement(By.linkText("SIGN-OFF")).click();
		
	}

}
