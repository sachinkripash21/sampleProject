package sachinbhandary.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import sachinbhandary.PageObjects.CartPage;
import sachinbhandary.PageObjects.ProductPage;
import sachinbhandary.Testcomponents.BaseTest;

public class ErrorValidationTest extends BaseTest{

	@Test
	public void LoginWrongPasswordErrorValidation() throws IOException
	{
		String username="standard_user";
		String password="secret_saue";
		landingPage.loginApplication(username, password);
		Assert.assertTrue(landingPage.errorMessage());
	}
	
	@Test
	public void LoginWongUsernameErrorValidation() throws IOException
	{
		String username="standard_usr";
		String password="secret_sauce";
		landingPage.loginApplication(username, password);
		Assert.assertTrue(landingPage.errorMessage());
	}
	
	@Test
	public void ProductErrorValidation()
	{
		String username="standard_user";
		String password="secret_sauce";
		String productName = "Sauce Labs Fleece Jacket";
		ProductPage productPage = landingPage.loginApplication(username, password);
		List<WebElement> products =productPage.getProducts();
		productPage.getProductByName(productName);
		productPage.addProductToCart(productName);
		CartPage cartPage = productPage.gotoCartPage();
		cartPage.getProducts();
		boolean match = cartPage.verifyProducts("Sauce Labs Jacket");				
		Assert.assertFalse(match);
	}

}
