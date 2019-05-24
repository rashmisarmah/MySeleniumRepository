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

public class TC04_SignOn_correctCred_FlightBooking {
	
	WebDriver driver = null;
	
	public void typeName(String locatorname, String value){
		driver.findElement(By.name(locatorname)).isDisplayed();
		driver.findElement(By.name(locatorname)).sendKeys(value);
	}
	
	
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
	public void LoginDemoPage(){
		
	//login from the Home page
	typeName("userName", "mercury");
	typeName("password", "mercury");
	driver.findElement(By.xpath("//font[contains(.,'Password:')]")).click();
	driver.findElement(By.xpath("//input[@name='login']")).click();
	//driver.findElement(By.name("passCount")).click();
	driver.findElement(By.name("fromPort")).click();
	Select s1 = new Select(driver.findElement(By.name("fromPort")));
	s1.selectByVisibleText("Frankfurt");
	driver.findElement(By.name("fromMonth")).click();
	Select s2 = new Select(driver.findElement(By.name("fromMonth")));
	s2.selectByVisibleText("July");
	driver.findElement(By.name("fromDay")).click();
	Select s3 = new Select(driver.findElement(By.name("fromDay")));
	s3.selectByVisibleText("20");
	driver.findElement(By.name("toPort")).click();
	Select s4 = new Select(driver.findElement(By.name("toPort")));
	s4.selectByVisibleText("London");
	driver.findElement(By.name("toMonth")).click();
	Select s5 = new Select(driver.findElement(By.name("toMonth")));
	s5.selectByVisibleText("July");
	driver.findElement(By.name("toDay")).click();
	Select s6 = new Select(driver.findElement(By.name("toDay")));
	s6.selectByVisibleText("30");
	driver.findElement(By.xpath("(//input[@name='servClass'])[2]")).click();
	driver.findElement(By.name("airline")).click();
	Select s7 = new Select(driver.findElement(By.name("airline")));
	s7.selectByVisibleText("Blue Skies Airlines");
	driver.findElement(By.name("findFlights")).click();
		
	//reserve flight
	driver.findElement(By.name("reserveFlights")).click();
		
	//passenger details
	typeName("passFirst0", "rashmi");
	typeName("passLast0", "sarmah");
	driver.findElement(By.name("creditCard")).click();
	driver.findElement(By.name("pass.0.meal")).click();
	Select s8 = new Select(driver.findElement(By.name("pass.0.meal")));
	s8.selectByVisibleText("Low Calorie");
	Select s9 = new Select(driver.findElement(By.name("creditCard")));
	s9.selectByVisibleText("MasterCard");
	typeName("creditnumber", "1234567890");
	typeName("cc_exp_dt_mn", "01");
	typeName("cc_exp_dt_yr", "2002");
	typeName("cc_frst_name", "R");
	typeName("cc_mid_name", "R");
	typeName("cc_last_name", "S");
	typeName("billAddress1", "P1");
	typeName("billCity", "P2");
	driver.findElement(By.name("billCountry")).click();
	Select s10 = new Select(driver.findElement(By.name("billCountry")));
	s10.selectByVisibleText("CZECH REPUBLIC");
	driver.findElement(By.name("buyFlights")).click();
	driver.findElement(By.xpath("//td[3]/a/img")).click();	
		
	}

}
