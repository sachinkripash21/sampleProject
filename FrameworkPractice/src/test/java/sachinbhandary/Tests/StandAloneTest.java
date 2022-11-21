package sachinbhandary.Tests;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item")));
		
		List<WebElement> products =driver.findElements(By.cssSelector(".inventory_item_description"));
		WebElement requiredProduct = products.stream().filter(product->
		product.findElement(By.cssSelector(".inventory_item_name")).getText().equals("Sauce Labs Fleece Jacket")).findFirst().orElse(null);
		requiredProduct.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click();
				
		driver.findElement(By.className("shopping_cart_link")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item_name")));
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
		boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("Sauce Labs Fleece Jacket"));
		Assert.assertTrue(match);
		
		driver.findElement(By.id("continue-shopping")).click();
		
		List<WebElement> products2 =driver.findElements(By.cssSelector(".inventory_item_description"));
		WebElement requiredProduct2 = products2.stream().filter(product2->
		product2.findElement(By.cssSelector(".inventory_item_name")).getText().equals("Sauce Labs Backpack")).findFirst().orElse(null);
		requiredProduct2.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click();
		
		driver.findElement(By.className("shopping_cart_link")).click();
		
		driver.findElement(By.id("checkout")).click();
		
		driver.findElement(By.id("first-name")).sendKeys("Sachin");
		driver.findElement(By.id("last-name")).sendKeys("Bhandary");
		driver.findElement(By.id("postal-code")).sendKeys("45698");
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("finish")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".complete-header")));
		boolean verified = driver.findElement(By.className("complete-header")).getText().equalsIgnoreCase("THANK YOU FOR YOUR ORDER");
		Assert.assertTrue(verified);
		
	}

}
