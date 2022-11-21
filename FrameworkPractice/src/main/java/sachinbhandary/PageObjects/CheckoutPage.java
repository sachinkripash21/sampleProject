package sachinbhandary.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	WebElement firstNameEle;
	
	@FindBy(id="last-name")
	WebElement latNameEle;
	
	@FindBy(id="postal-code")
	WebElement postCodeEle;
	
	@FindBy(id="continue")
	WebElement next;
	
	public FinalCheckoutPage fillInformation(String firstName,String lastName,String postCode)
	{
		firstNameEle.sendKeys(firstName);
		latNameEle.sendKeys(lastName);
		postCodeEle.sendKeys(postCode);
		next.click();
		FinalCheckoutPage finalCheckoutPage = new FinalCheckoutPage(driver);
		return finalCheckoutPage;
	}
	
	

}
