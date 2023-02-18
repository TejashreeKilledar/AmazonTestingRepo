package testPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.AddToCartPage;
import pomClasses.SamsungMobilePage;
import pomClasses.SearchAmazonPage;

public class TestClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		
System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver.exe");//key ,path
		
		WebDriver driver=new ChromeDriver();//upcasting
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");//to launch the browser of page through url 
		
		SearchAmazonPage searchAmazonPage=new SearchAmazonPage(driver);
		try {
			searchAmazonPage.sendProductOnSerchBar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchAmazonPage.clickOnSearchitem();
		SamsungMobilePage samsungMobilePage=new SamsungMobilePage(driver);
		samsungMobilePage.ClickOnSpecificItem("text");
		AddToCartPage addToCartPage=new AddToCartPage(driver);
		addToCartPage.ClickOnAddToCart();

	}

}
