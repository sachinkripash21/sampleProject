package sachinbhandary.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sachinbhandary.CommonComponents.CommomComponents;

public class CheckoutComplete extends CommomComponents{
	WebDriver driver;
	
	public CheckoutComplete(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	

	By confirmationMessage =By.cssSelector(".complete-header");
		
	public boolean confirmation()
	{
		waitUntilElemenrAppear(confirmationMessage);
		boolean verified = driver.findElement(By.className("complete-header")).getText().equalsIgnoreCase("THANK YOU FOR YOUR ORDER");
		return verified;
	}
	
	

}
