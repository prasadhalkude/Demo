Feature: Login to sauce demo site and order a product
	Scenario Outline: Login
		Given I am on Landing page
		When user logs into appplication with username as <username> and password as <password>
		Then user checks that shopping cart is empty
		When user adds a product <product> to cart
		Then user cart has the product <product> added to it
		And user continues to shop
		When user adds a product <another_product> to cart
		Then user cart has the product <another_product> added to it
		And cart has all the products added by user
		When user navigates to checkout
		Then user fills in <firstName> <lastName> and <zipcode>
		And user selects continue
		When user selects finish
		Then user gets the order confirmation
		And user navigates to landing page
	Examples:
		|username|password|product|another_product|firstName|lastName|zipcode|
		|performance_glitch_user|secret_sauce|Sauce Labs Backpack|Sauce Labs Fleece Jacket|Prasad|Halkude|411013|
		