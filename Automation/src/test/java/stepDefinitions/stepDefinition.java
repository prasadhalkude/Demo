package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.CheckOut;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.UserCart;
import io.cucumber.java.en.Then;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import Cucumber.Automation.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

public class stepDefinition extends Base {
	HomePage hp;
	LandingPage lp;
	UserCart uc;
	CheckOut co;
	
	ArrayList<String> itemPrice = new ArrayList<String>();
	ArrayList<String> itemName = new ArrayList<String>();
	
	
	@Given("^I am on Landing page$")
	public void I_am_on_Landing_page() throws Throwable {
//		System.out.println("I m on landing page");
		driver = Base.getDriver();
		hp = new HomePage(driver);
		lp = new LandingPage(driver);
		uc = new UserCart(driver);
		co = new CheckOut(driver);
	}
	
	@When("^user logs into appplication with username as (.+) and password as (.+)$") 
	public void user_logs_into_application_with_username_as_and_password_as_(String username, String password) throws Throwable{
		System.out.println("User login into appplication"+username+"_"+password);
		try {
			
			hp.getUserName().sendKeys(username);
			hp.getPassWord().sendKeys(password);
			hp.getLoginButton().click();	
			Thread.sleep(5000);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Then("^user checks that shopping cart is empty$")
	public void user_checks_that_shopping_cart_is_empty() {
		try {
			
			WebElement element = lp.getCartBadge();
			Assert.assertNull(element);
		} catch(Exception e) { }
	}
	
	@When("^user adds a product (.+) to cart$")
	public void user_adds_a_product_to_cart(String product) {
		try {
			lp.getProductToOrder(product).click();
			itemPrice.add(lp.getProductPrice(product));
			itemName.add(product);
		} catch(Exception e) { System.out.println(e);}
	}
	
	@Then("^user cart has the product (.+) added to it$")
	public void user_cart_has_the_product_added_to_it(String product) {
		try {
			lp.getShoppingCart().click();
			WebElement element = uc.getProductAdded(product);
			Assert.assertNotNull(element);
		} catch(Exception e) {}
	}
	
	@Then("^user continues to shop$")
	public void user_continues_to_shop() {
		try {
			uc.getContinueToShop().click();
		}catch(Exception e) {}
	}
	
	@When("^user navigates to checkout$")
	public void user_navigates_to_checkout(){
		try {
			Thread.sleep(5000);
			uc.getCheckOut().click();
		} catch(Exception e) {
			
		}
	}
	
	@Then("^cart has all the products added by user$")
	public void cart_has_all_the_products_added_by_user() {
		try {
			for (int i = 0; i < itemName.size(); i++) {
				WebElement element = uc.getProductAdded(itemName.get(i));
				Assert.assertNotNull(element);
//				System.out.println("price is as displayed on landing page?"+itemPrice.get(i).equals(uc.getPriceInCart(itemName.get(i))));
				Assert.assertTrue(itemPrice.get(i).equals(uc.getPriceInCart(itemName.get(i))));
			}
		}catch(Exception e) {}
	}
	
	@Then("^user fills in (.+) (.+) and (.+)$")
	public void user_fills_in_and(String firstName, String lastName, String zipCode) {
		try {
			co.getFirstName().sendKeys(firstName);
			co.getLastName().sendKeys(lastName);
			co.getZipCode().sendKeys(zipCode);
		}catch(Exception e) {
			
		}
	}
	
	@Then("^user selects continue$")
	public void user_selects_continue( ) {
		try {
			co.getContinue().click();
		}catch(Exception e) {
			
		}
	}
	
	@Then("^user selects finish$") 
	public void user_selects_finish() {
		try {
			co.getFinish().click();
			Thread.sleep(5000);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Then("^user gets the order confirmation$")
	public void user_gets_the_order_confirmation() {
		try {
			WebElement element = co.getOrderConfirmation();
			Assert.assertNotNull(element);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Then("^user navigates to landing page$")
	public void user_navigates_to_landing_page() {
		try {
			co.getBackToHome().click();
			itemPrice.clear();
			itemName.clear();
			Thread.sleep(5000);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
