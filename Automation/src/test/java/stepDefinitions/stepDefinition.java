package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import Cucumber.Automation.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

public class stepDefinition extends Base {
	HomePage hp;
	LandingPage lp;
	
	@Given("^I am on Landing page$")
	public void I_am_on_Landing_page() throws Throwable {
		System.out.println("I m on landing page");
		driver = Base.getDriver();
	}
	
	@When("^user logs into appplication with username as (.+) and password as (.+)$") 
	public void user_logs_into_application_with_username_as_and_password_as_(String username, String password) throws Throwable{
		System.out.println("User login into appplication"+username+"_"+password);
		try {
			hp = new HomePage(driver);
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
			lp = new LandingPage(driver);
			WebElement element = lp.getCartBadge();
			Assert.assertNull(element);
		} catch(Exception e) { }
	}
	
}
