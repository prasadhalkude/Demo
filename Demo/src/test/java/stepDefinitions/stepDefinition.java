package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.UserCart;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Cucumber.Demo.Base;

public class stepDefinition extends Base {
	HomePage hp;
	UserCart uc;
	
	ArrayList<String> itemPrice = new ArrayList<String>();
	ArrayList<String> itemName = new ArrayList<String>();
	ArrayList<String> productList = new ArrayList<String>();
	List<String> products;
	
	
	@Given("^I add four different products to my wish list$")
	public void I_add_four_differnt_products_to_my_wish_list(DataTable table) throws Throwable {
//		System.out.println("I m on landing page");
		driver = Base.getDriver();
		hp = new HomePage(driver);
		uc = new UserCart(driver);
		hp.getAcceptAll().click();
		products = table.asList();
		for(int i=0;i<products.size();i++) 
		{
			hp.getSearchProduct().sendKeys(products.get(i));
			hp.getSearch().click();
			hp.getProductToadd().click();
			productList.add(products.get(i));
		}
		Assert.assertNotNull(hp.getProductsAddedToCart(""+products.size()));
//		System.out.println(products.get(1));
	}
	
	
	@When("^I view my wishlist table$")
	public void I_view_my_wishlist_table() {
		hp.getViewCart().click();
	}
	
	@When("I search for {string} price product")
	public void I_search_for_price_product(String order) {
		try {
		hp.getShop().click();
//		hp.getOrderBy().click();
		String criteria="";
		if(order.equals("lowest")) {
			criteria = "price";
		}
		Select lst = hp.getOrderCriteria();
		lst.selectByValue(criteria);
		Thread.sleep(2000);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Then("^I find total four selected items in my wishlist$") 
	public void I_find_total_four_selected_items_in_my_wishlist() {
		checkCart();
	}
	
	@When("^I am able to add the lowest price item to my cart$") 
	public void I_am_able_to_add_the_lowest_price_item_to_my_cart() {
		try {
			hp.getFirstProduct().click();
			Select lst = hp.getOptions();
			if(lst.equals(null)) {
				
			} else {
				lst.selectByIndex(1);
				Thread.sleep(1000);
			}
			hp.getProductToadd().click();
			productList.add(hp.getProductName());
		} catch(Exception e) {
			System.out.print(e);
		}
	}
	
	@Then("^I am able to verify the item in my cart$") 
	public void I_am_able_to_verify_the_item_in_my_cart() {
		viewCart();
		checkCart();
	}
	
	public void viewCart()
	{
		hp.getViewCart().click();
	}
	
	public void checkCart()
	{
		try {
			List<WebElement> totalProducts = uc.getProductsCountInTable();
			Assert.assertEquals(totalProducts.size(), productList.size());
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}