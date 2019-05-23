package demo.page.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TC06_Tab_Switching {
	
	@Test
	public void tabSwitching(){
		
		String browser = "Mozilla";
		WebDriver driver = null;
		
		
		if(browser == "Mozilla"){
			System.setProperty("webdriver.gecko.driver", "/Users/Rashmi/Documents/NewWorkSpace/Projects/DemoPage/DemoPageProject/geckodriver");
			driver = new FirefoxDriver();
		}else if (browser == "Chrome"){
			System.setProperty("webdriver.chrome.driver", "/Users/Rashmi/Documents/NewWorkSpace/Projects/DemoPage/DemoPageProject/chromedriver");
			driver = new ChromeDriver();
		}
		
		//maximize the browser before launching
		driver.manage().window().maximize();
				
		//launch URL
		driver.get("http://newtours.demoaut.com/");
		
		//tab switching
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a/img")).click();
		
		driver.quit();
		
		
	}

}
