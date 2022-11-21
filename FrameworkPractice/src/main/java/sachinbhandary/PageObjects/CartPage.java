package sachinbhandary.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sachinbhandary.CommonComponents.CommomComponents;

public class CartPage extends CommomComponents{
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".inventory_item_name")
	List<WebElement> cartProducts;
	By cartProductsBy =By.cssSelector(".inventory_item_name");
	@FindBy(id="checkout")
	WebElement checkout;
	@FindBy(id="continue-shopping")
	WebElement continueShopping;
	@FindBy(css=".btn.btn_secondary.btn_small.cart_button")
	WebElement removeButton;
	
	public List<WebElement> getProducts()
	{
		waitUntilElemenrAppear(cartProductsBy);
		return cartProducts;
	}
	
	public boolean verifyProducts(String productName)
	{
		boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public void removeButtonClick()
	{
		removeButton.click();
	}
	
	public void backToProductPage()
	{
		continueShopping.click();
	}
	
	public CheckoutPage goTocheckout()
	{
		checkout.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
		
	public boolean itemsNotRemoved() {
	    try { 
	    	removeButton.isDisplayed(); 
	    	return true;
	    }catch (Exception ignored) { 
	    	return false; }
	}
	
	public void clickToRemoveAllProducts()
	{
		List<WebElement> items = driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
		for (int i=0; i<items.size();i++)
		{
			items.get(i).click();
		}
	}
	
	public boolean verifyAllItems(ArrayList<String> list)
	{
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".inventory_item_name"));		
		List<String> strings = new ArrayList<>();		
		cartProducts.forEach(cartProduct ->strings.add(cartProduct.getText()));
		boolean match = strings.containsAll(list);
		return match;
	}

}
