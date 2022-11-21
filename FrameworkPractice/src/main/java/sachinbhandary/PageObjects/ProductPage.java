package sachinbhandary.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import sachinbhandary.CommonComponents.CommomComponents;

public class ProductPage extends CommomComponents{
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".inventory_item_description")
	List<WebElement> products;
	@FindBy(className="product_sort_container")
	WebElement sortProducts;
			
	By productsBy =By.cssSelector(".inventory_item");
	By addToCart = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
	By removeFromCart = By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory");
		
	public void sortProducts()
	{
		Select dropdown = new Select(sortProducts);
		dropdown.selectByValue("hilo");
	}
	
	
	public List<WebElement> getProducts()
	{
		waitUntilElemenrAppear(productsBy);
		return products;
		
	}
	
	
	
	public WebElement getProductByName(String productname)
	{
		WebElement prod = getProducts().stream().filter(product->
		product.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
	
		
	public void addProductToCart(String productName)
	{
		getProductByName(productName).findElement(addToCart).click();	
	}
	
	public void removeProductFromcart(String productName)
	{
		getProductByName(productName).findElement(removeFromCart).click();
	}
	
	
	public void clickToAddAllProducts()
	{
		List<WebElement> items = driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
		for (int i=0; i<items.size();i++)
		{
			items.get(i).click();
		}
	}
	
	public void clickToRemoveAllProducts()
	{
		List<WebElement> items = driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
		for (int i=0; i<items.size();i++)
		{
			items.get(i).click();
		}
	}
	
}
