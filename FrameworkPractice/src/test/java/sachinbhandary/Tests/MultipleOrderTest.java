package sachinbhandary.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sachinbhandary.PageObjects.CartPage;
import sachinbhandary.PageObjects.CheckoutComplete;
import sachinbhandary.PageObjects.CheckoutPage;
import sachinbhandary.PageObjects.FinalCheckoutPage;
import sachinbhandary.PageObjects.ProductPage;
import sachinbhandary.Testcomponents.BaseTest;

public class MultipleOrderTest extends BaseTest{
	
	@Test(dataProvider="getData")
	public void MultipleOrderWithContinueShoppingButton(HashMap<String,String> input) throws IOException, InterruptedException
	{
		ProductPage productPage = landingPage.loginApplication(input.get("username"), input.get("password"));
		productPage.sortProducts();
		Thread.sleep(2000);
		List<WebElement> products =productPage.getProducts();
		productPage.getProductByName(input.get("itema"));
		productPage.addProductToCart(input.get("itema"));
		CartPage cartPage = productPage.gotoCartPage();
		cartPage.getProducts();
		boolean match = cartPage.verifyProducts(input.get("itema"));				
		Assert.assertTrue(match);
		cartPage.backToProductPage();
		List<WebElement> products2 =productPage.getProducts();
		productPage.getProductByName(input.get("itemb"));
		productPage.addProductToCart(input.get("itemb"));
		productPage.gotoCartPage();
		CheckoutPage checkoutPage =cartPage.goTocheckout();				
		FinalCheckoutPage finalCheckoutPage = checkoutPage.fillInformation(input.get("firstname"), input.get("lastname"), input.get("postcode"));		
		CheckoutComplete checkoutComplete = finalCheckoutPage.clickOnFinish();		
		boolean verified = checkoutComplete.confirmation();
		Assert.assertTrue(verified);
	}
	
	@DataProvider
	public Object [] [] getData() throws IOException
	{
		List<HashMap<String, String>> data = getDataFromJason(System.getProperty("user.dir")+"\\src\\test\\java\\sachinbhandary\\data\\PurchaseOrder.json");
		return new Object [] [] {{data.get(0)}};
	}


}
