package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamsungMobilePage {

	WebDriver driver;
	@FindBy (xpath=" (//span[@class='a-price'])[1]")
	private WebElement specificItem;
	
	public SamsungMobilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ClickOnSpecificItem(String text)
	{
		specificItem.click();
		String productText=specificItem.getText();
		return productText;
	}
}
