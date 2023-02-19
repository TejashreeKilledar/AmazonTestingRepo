package testPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.Browser;
import pomClasses.AddToCartPage;

public class AddToCartNgClass extends Browser{

	WebDriver driver;
	/*@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}*/
	@Parameters("browser")
	@BeforeTest
	public void OpenBrowser(String browserName)
	{
		System.out.println("Open Browser before excute the test method..");
		System.out.println("Open Browser before excute the test method..");
		System.out.println("Open Browser before excute the test method..");
		if(browserName.equals("Chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver.exe");
			//driver= new ChromeDriver();	
			driver= openChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver","D:\\Automation_fileFolder\\geckodriver-v0.32.0-win64\\geckodriver.exe" );
			//driver= new FirefoxDriver();	
			driver= openFirefoxBrowser();
		}
		if(browserName.equals("Opera"))
		{
			//System.setProperty("webdriver.opera.driver","D:\\Automation_fileFolder\\operadriver_win64\\operadriver_win64\\operadriver.exe");
			//driver= new OperaDriver();
			driver= openOperaBrowser();
		}
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
		driver.get("https://www.amazon.com/Tracfone-Samsung-Galaxy-A03s-Black/dp/B09T2JFWKR/ref=sr_1_1_sspa?crid=2EJG7HHBE5F7&keywords=samsung+phone&qid=1674983371&sprefix=samsung+phone%2Caps%2C1114&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyT1VNVllNQk5YRVYyJmVuY3J5cHRlZElkPUEwMTk0NTIxVU5ETkozMUNITlVSJmVuY3J5cHRlZEFkSWQ9QTAzMjk1NjkyUVdURDNEOVlYUk5YJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==");
		
	}
	
	@Test
	public void clickOnAddToCartButton() 
	{
		System.out.println("Test1");
		AddToCartPage addToCartPage=new AddToCartPage(driver);
		addToCartPage.ClickOnAddToCart();
		String actUrl=driver.getCurrentUrl();
		System.out.println("Actual url is "+actUrl);
		
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
		//driver.close();
	}
	
	/*@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
		
		
		driver.quit();
	}*/
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Class");
		
		
		driver.quit();
	}
}
