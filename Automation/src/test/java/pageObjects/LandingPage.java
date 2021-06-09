package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	By cartBadge = By.className("shopping_cart_badge");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartBadge() {
		return driver.findElement(cartBadge);
	}

}