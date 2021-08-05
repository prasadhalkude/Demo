Feature: Verify that user is able to order the desired products successfully
	Scenario: Order Products Successfully
		Given I add four different products to my wish list
		|Evening trousers|
		|Bikini|
		|Black trousers|
		|Hard top|
		When I view my wishlist table
		Then I find total four selected items in my wishlist
		When I search for "lowest" price product
		And I am able to add the lowest price item to my cart
		Then I am able to verify the item in my cart