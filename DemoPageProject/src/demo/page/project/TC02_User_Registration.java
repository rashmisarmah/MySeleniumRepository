package demo.page.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC02_User_Registration {
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
	public void registerUser(){
		
		//find REGISTER and click on it.
		driver.findElement(By.linkText("REGISTER")).click();
		
		//filling contact information
		driver.findElement(By.name("firstName")).sendKeys("Rashmi");
		driver.findElement(By.name("lastName")).sendKeys("Sarmah");
		driver.findElement(By.name("phone")).sendKeys("1234");
		driver.findElement(By.id("userName")).sendKeys("rsmisrmh29@gmail.com");
		
		//filling mailing information
		driver.findElement(By.name("address1")).sendKeys("P4");
		driver.findElement(By.name("city")).sendKeys("Prague");
		driver.findElement(By.name("state")).sendKeys("Prague");
		driver.findElement(By.name("postalCode")).sendKeys("1111");
		
		//to select the Country
		Select s = new Select(driver.findElement(By.name("country")));
		s.selectByVisibleText("CZECH REPUBLIC");
		
		//filling user information
		driver.findElement(By.name("email")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("confirmPassword")).sendKeys("mercury");
		
		//clicking on REGISTER button
		driver.findElement(By.name("register")).click();
		//driver.findElement(By.xpath("//input[@name='register'")).click();
		
	}
	

}
