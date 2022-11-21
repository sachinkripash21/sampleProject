package sachinbhandary.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalCheckoutPage {
	WebDriver driver;
	
	public FinalCheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="finish")
	WebElement next;
//	driver.findElement(By.id("finish")).click();
	public CheckoutComplete clickOnFinish()
	{
		next.click();
		CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
		return checkoutComplete;
	}
	
	

}
