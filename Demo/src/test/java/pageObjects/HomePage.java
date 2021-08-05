package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	public WebDriver driver;
	By searchProduct = By.name("s");
	By search = By.className("header-search-button");
	By shop = By.xpath("//a[@Title='Shop']");
	By addToCart = By.xpath("//button[contains(@class,'single_add_to_cart_button')]");
	By productsAddedToCart;
	By viewCart = By.className("cart-contents");
	By orderBy = By.xpath("//select[@name='orderby']");
	By orderCriteria;
	By acceptAll = By.xpath("//a[text()='Accept all']");
	By firstProduct = By.xpath("//li[contains(@class,'type-product')]");
	By chooseOptions = By.xpath("//table[@class='variations']//select");
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAcceptAll() {
		return driver.findElement(acceptAll);
	}
	
	public WebElement getSearchProduct() {
		return driver.findElement(searchProduct);
	}
	
	public WebElement getSearch() {
		return driver.findElement(search);
	}
	
	public WebElement getShop() {
		return driver.findElement(shop);
	}
	
	public WebElement getProductToadd() {
		return driver.findElement(addToCart);
	}
	
	public WebElement getProductsAddedToCart(String count)
	{
		return driver.findElement(By.xpath("(//span[@class='count' and text()='"+count+"'])[1]"));
	}
	
	public WebElement getViewCart() {
		return driver.findElement(viewCart);
	}
	
	public WebElement getOrderBy()
	{
		return driver.findElement(orderBy);
	}
	
	public Select getOrderCriteria() {
		Select orders = new Select(driver.findElement(orderBy));
		return orders;
	}
	
	public WebElement getFirstProduct() {
		return driver.findElement(firstProduct);
	}
	
	public Select getOptions() {
		Select orders=null;
		try {
			orders = new Select(driver.findElement(chooseOptions));
		} catch (NoSuchElementException e) {
			
		}
		return orders;
	}
	
	public String getProductName() {
		String productName = driver.findElement(By.tagName("h1")).getText();
		return productName;
	}
}
