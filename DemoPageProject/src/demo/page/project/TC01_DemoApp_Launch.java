package demo.page.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC01_DemoApp_Launch {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void launchDemoPage(){
		String browser = "Mozilla";
		
		if(browser == "Mozilla"){
			System.setProperty("webdriver.gecko.driver", "/Users/Rashmi/Documents/NewWorkSpace/Projects/DemoPage/DemoPageProject/geckodriver");
			driver = new FirefoxDriver();
		}else if (browser == "Chrome"){
			System.setProperty("webdriver.chrome.driver", "/Users/Rashmi/Documents/NewWorkSpace/Projects/DemoPage/DemoPageProject/chromedriver");
			driver = new ChromeDriver();
		}
		
		//maximize the browser before launching
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//launch URL
		driver.get("http://newtours.demoaut.com/");
			
}
	
	@Test
	public void Sign_On(){
		
	}
	
	@AfterTest
	public void afterTest_Quit(){
		driver.quit();
	}
	
}
