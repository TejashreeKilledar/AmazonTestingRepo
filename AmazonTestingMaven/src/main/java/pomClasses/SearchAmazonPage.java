package pomClasses;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utility;

public class SearchAmazonPage{
	
	WebDriver driver;
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchElement;
	
	@FindBy (xpath="(//div[@class='s-suggestion s-suggestion-ellipsis-direction'])[1]")
	private WebElement searchSamsunghone;
	
	//@FindBy (xpath="//input[@id='nav-search-submit-button']")
	//private WebElement searchSamsunghone;
	
	public SearchAmazonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void sendProductOnSerchBar()
	{
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOf(searchElement));
		searchElement.sendKeys("samsung phone");
	}
	
	public void clickOnSearchitem() throws IOException, InterruptedException
	{
		//WebDriverWait wait=new WebDriverWait(driver,9);
		//wait.until(ExpectedConditions.visibilityOf(searchSamsunghone));
	
		searchSamsunghone.click();
		Thread.sleep(2000);
		
	
	}
	
}
