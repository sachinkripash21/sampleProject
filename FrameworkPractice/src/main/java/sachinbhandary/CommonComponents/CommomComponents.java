package sachinbhandary.CommonComponents;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sachinbhandary.PageObjects.CartPage;

public class CommomComponents {
	WebDriver driver;
	
	public CommomComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="shopping_cart_link")
	WebElement cartIcon;
	@FindBy(id="react-burger-menu-btn")
	WebElement menuBar;
	@FindBy(id="logout_sidebar_link")
	WebElement logoutButton;

	public void waitUntilElemenrAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
		

	public CartPage gotoCartPage()
	{
		cartIcon.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public void clickLogout()
	{
		menuBar.click();
		logoutButton.click();
		
	}
}
