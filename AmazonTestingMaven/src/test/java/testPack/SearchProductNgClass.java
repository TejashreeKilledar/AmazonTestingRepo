package testPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.Browser;
import pomClasses.SearchAmazonPage;
import utils.Utility;


public class SearchProductNgClass extends Browser {

	WebDriver driver;
/*	@BeforeClass
	public void beforeClass()
	{
		
		System.out.println("Before Class");
		System.out.println("Before Class");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}*/
	@Parameters("browser")
	@BeforeTest
	public void OpenBrowser(String browserName)
	{
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
		System.out.println("Before Method");System.out.println("Before Method");System.out.println("Before Method");
		driver.get("https://www.amazon.com/");
		
	}
	
	@Test
	public void clickOnSearchBar() throws InterruptedException, IOException
	{
		System.out.println("Test1");
		SearchAmazonPage searchAmazonPage=new SearchAmazonPage(driver);
		
		searchAmazonPage.sendProductOnSerchBar();
		Utility.captureScreenShot(driver,"sendProductOnSerchBar.jpeg");
		Thread.sleep(5000);
		searchAmazonPage.clickOnSearchitem();
	//	Utility.captureScreenShot(driver,"clickOnSearchitem.jpeg");
		String actUrl=driver.getCurrentUrl();
		System.out.println("Actual url is "+actUrl);
		String expUrl ="https://www.amazon.com/s?k=samsung+phone&crid=2EJG7HHBE5F7&sprefix=samsung+phone%2Caps%2C1114&ref=nb_sb_ss_ts-doa-p_2_13";
	
		if(actUrl.equals(expUrl))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
		//driver.close();
	}
	
/*	@AfterClass
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
