Feature: Login to sauce demo site and order a product
	Scenario Outline: Login
		Given I am on Landing page
		When user logs into appplication with username as <username> and password as <password>
		Then user checks that shopping cart is empty
	Examples:
		|username|password|
		|performance_glitch_user|secret_sauce|
		