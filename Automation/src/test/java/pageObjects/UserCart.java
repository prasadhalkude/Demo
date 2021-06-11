package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserCart {
	public WebDriver driver;
	By continuetoShop = By.id("continue-shopping");
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
	
	public WebElement getContinueToShop() {
		return driver.findElement(continuetoShop);
	}
	
	public WebElement getCheckOut() {
		return driver.findElement(checkOut);
	}
	
	public String getPriceInCart(String product) {
		String value = driver.findElement(By.xpath("(//div[text()='"+product+"']//parent::*/parent::*)/following-sibling::div//div[@class='inventory_item_price']")).getAttribute("innerHTML");
		return value;
	}
}
