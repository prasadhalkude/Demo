package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	By userName = By.id("user-name");
	By passWord = By.id("password");
	By loginButton = By.id("login-button");
	
	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	
	public WebElement getPassWord() {
		return driver.findElement(passWord);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
}
