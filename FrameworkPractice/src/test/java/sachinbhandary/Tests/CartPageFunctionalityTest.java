package sachinbhandary.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sachinbhandary.PageObjects.CartPage;
import sachinbhandary.PageObjects.ProductPage;
import sachinbhandary.Testcomponents.BaseTest;

public class CartPageFunctionalityTest extends BaseTest{
	
//	@Test(dataProvider="getData")
//	public void RefreshCartTest(HashMap<String,String> input) throws InterruptedException
//	{
//		ProductPage productPage = landingPage.loginApplication(input.get("username"), input.get("password"));
//		List<WebElement> products =productPage.getProducts();
//		productPage.getProductByName(input.get("itema"));
//		productPage.addProductToCart(input.get("itema"));
//		CartPage cartPage = productPage.gotoCartPage();
//		driver.navigate().refresh();
//		cartPage.getProducts();
//		Thread.sleep(3);
//		boolean match = cartPage.verifyProducts(input.get("itema"));				
//		Assert.assertTrue(match);
//		Thread.sleep(3);
//	}
//	
//	@Test(dataProvider="getData")
//	public void LogoutAndVerifyCartProduct(HashMap<String,String> input) throws InterruptedException
//	{
//		ProductPage productPage = landingPage.loginApplication(input.get("username"), input.get("password"));
//		List<WebElement> products =productPage.getProducts();
//		productPage.getProductByName(input.get("itema"));
//		productPage.addProductToCart(input.get("itema"));
//		Thread.sleep(3);
//		productPage.clickLogout();
//		Thread.sleep(3);
//		landingPage.loginApplication(input.get("username"), input.get("password"));
//		Thread.sleep(3);
//		CartPage cartPage = productPage.gotoCartPage();
//		cartPage.getProducts();
//		boolean match = cartPage.verifyProducts(input.get("itema"));				
//		Assert.assertTrue(match);
//	}
//	
//	@Test(dataProvider="getData")
//	public void VerifyRemoveButton(HashMap<String,String> input)
//	{
//		ProductPage productPage = landingPage.loginApplication(input.get("username"), input.get("password"));
//		List<WebElement> products =productPage.getProducts();
//		productPage.getProductByName(input.get("itema"));
//		productPage.addProductToCart(input.get("itema"));
//		CartPage cartPage = productPage.gotoCartPage();
//		cartPage.getProducts();
//		cartPage.removeButtonClick();
//		boolean match = cartPage.itemsNotRemoved();
//		Assert.assertFalse(match);
//	}
	
	@Test(dataProvider="getData")
	public void RemoveAllItemsFromCart(HashMap<String,String> input)
	{
		ProductPage productPage = landingPage.loginApplication(input.get("username"), input.get("password"));
		productPage.clickToAddAllProducts();
		CartPage cartPage = productPage.gotoCartPage();
		cartPage.getProducts();
		cartPage.clickToRemoveAllProducts();
		boolean match = cartPage.itemsNotRemoved();
		Assert.assertFalse(match);
		
	}
	
	
	
	@DataProvider
	public Object [] [] getData() throws IOException
	{
		List<HashMap<String, String>> data = getDataFromJason(System.getProperty("user.dir")+"\\src\\test\\java\\sachinbhandary\\data\\PurchaseOrder.json");
		return new Object [] [] {{data.get(0)}};
	}

}
