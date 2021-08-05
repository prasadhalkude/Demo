package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserCart {
	public WebDriver driver;
	By checkOut = By.id("checkout");
	By productAdded;
	By productPrice;
	
	
	public UserCart(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getProductAdded(String product) {
		productAdded = By.xpath("//div[text()='"+product+"']");
		return driver.findElement(productAdded);
	}
	
	public List<WebElement> getProductsCountInTable() {
		return driver.findElements(By.xpath("//table[contains(@class,'cart')]//tr[contains(@class,'woocommerce-cart-form__cart-item')]"));
	}
	
	public WebElement getCheckOut() {
		return driver.findElement(checkOut);
	}
	
	public String getPriceInCart(String product) {
		String value = driver.findElement(By.xpath("(//div[text()='"+product+"']//parent::*/parent::*)/following-sibling::div//div[@class='inventory_item_price']")).getAttribute("innerHTML");
		return value;
	}
}
