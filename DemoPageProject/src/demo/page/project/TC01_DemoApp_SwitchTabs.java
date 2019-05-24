package demo.page.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC01_DemoApp_SwitchTabs {
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
	public void TabSwitching(){
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.linkText("SUPPORT")).click();
		driver.findElement(By.linkText("CONTACT")).click();
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.linkText("Flights")).click();
		driver.findElement(By.linkText("Hotels")).click();
		driver.findElement(By.linkText("Car Rentals")).click();
		driver.findElement(By.linkText("Cruises")).click();
		driver.findElement(By.linkText("Destinations")).click();
		driver.findElement(By.linkText("Vacations")).click();
		driver.findElement(By.xpath("//a/img")).click();
	}

}
