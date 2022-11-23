package sachinbhandary.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement userNameEle;
	
	@FindBy(id="password")
	WebElement passwordEle;
	
	@FindBy(id="login-button")
	WebElement login;
	

	@FindBy(css="h3[data-test='error']")
	WebElement errorMessage;
	
	public ProductPage loginApplication(String username,String password)
	{
		userNameEle.sendKeys(username);
		passwordEle.sendKeys(password);
		login.click();
		ProductPage productPage= new ProductPage(driver);
		return productPage;
	}
	
	public void goTo()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	public void errorMessage()
	{
		String mixText = errorMessage.getText();
		String text = mixText.replace(driver.findElement(By.cssSelector("button.error-button")).getText(), "").trim();
		System.out.println(text);
//		boolean message = errorMessage.isDisplayed();
//		return message;
	}

}
