package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	By cartBadge = By.className("shopping_cart_badge");
	By shoppingCart = By.className("shopping_cart_link");
	By productToOrder;
	By productPrice;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartBadge() {
		return driver.findElement(cartBadge);
	}
	
	public WebElement getProductToOrder(String product) {
		productToOrder = By.xpath("(//div[text()='"+product+"']//parent::*/parent::*)/following-sibling::div//button[contains(@id,'add-to-cart')]");
		return driver.findElement(productToOrder);
	}
	
	public WebElement getShoppingCart() {
		return driver.findElement(shoppingCart);
	}
	
	public String getProductPrice(String product) {
		String value = driver.findElement(By.xpath("(//div[text()='"+product+"']//parent::*/parent::*)/following-sibling::div//div[@class='inventory_item_price']")).getAttribute("innerHTML");
		return value;
	}

}
