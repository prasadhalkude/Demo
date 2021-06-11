package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut {
	public WebDriver driver;
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");	
	By zipCode = By.id("postal-code");
	By buttonContinue = By.id("continue");
	By finish = By.id("finish");
	By orderConfirmation = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");
	By backToHome = By.id("back-to-products");
	
	public CheckOut(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement getZipCode() {
		return driver.findElement(zipCode);
	}
	
	public WebElement getContinue() {
		return driver.findElement(buttonContinue);
	}
	
	public WebElement getFinish()
	{
		return driver.findElement(finish);
	}
	
	public WebElement getOrderConfirmation() {
		return driver.findElement(orderConfirmation);
	}
	
	public WebElement getBackToHome() {
		return driver.findElement(backToHome);
	}
	
}
