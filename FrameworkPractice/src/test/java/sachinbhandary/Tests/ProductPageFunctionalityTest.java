package sachinbhandary.Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sachinbhandary.PageObjects.CartPage;
import sachinbhandary.PageObjects.ProductPage;
import sachinbhandary.Testcomponents.BaseTest;

public class ProductPageFunctionalityTest extends BaseTest {
	
	@Test(dataProvider="getData")
	public void VerifyRemoveButton(HashMap<String,String> input)
	{
		ProductPage productPage = landingPage.loginApplication(input.get("username"), input.get("password"));
		List<WebElement> products =productPage.getProducts();
		productPage.getProductByName(input.get("itema"));
		productPage.addProductToCart(input.get("itema"));
		List<WebElement> remove =productPage.getProducts();
		productPage.removeProductFromcart(input.get("itema"));
		CartPage cartPage = productPage.gotoCartPage();
		boolean match = cartPage.itemsNotRemoved();
		Assert.assertFalse(match);
	}
	
	@Test(dataProvider="getData")
	public void AddAllItemsToCart(HashMap<String,String> input)
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("Sauce Labs Backpack");
		list.add("Sauce Labs Bike Light");
		list.add("Sauce Labs Fleece Jacket");
		list.add("Sauce Labs Bolt T-Shirt");
		list.add("Sauce Labs Onesie");
		list.add("Test.allTheThings() T-Shirt (Red)");
		ProductPage productPage = landingPage.loginApplication(input.get("username"), input.get("password"));
		productPage.clickToAddAllProducts();
		CartPage cartPage = productPage.gotoCartPage();
		cartPage.getProducts();
		boolean match = cartPage.verifyAllItems(list);
		Assert.assertTrue(match);
		
	}
	
	@Test(dataProvider="getData")
	public void RemoveAllItemsFromCart(HashMap<String,String> input)
	{
		ProductPage productPage = landingPage.loginApplication(input.get("username"), input.get("password"));
		productPage.clickToAddAllProducts();
		productPage.clickToRemoveAllProducts();
		CartPage cartPage = productPage.gotoCartPage();
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
