@tag
Feature: Purchase order from e-com website
	I want to use this template for my feature file
	
#	Background:
#	 Given I landed on login page of e-commerce website

  @placeOrder
  Scenario Outline: Positive test of submittig the order
  	Given I landed on login page of e-commerce website
    And I logged in with username <username> and password <password>
    When I add product <productName> to cart
    And I checkout <productName> and submit order
    Then "Order Placed Successfully" message is displayed on confirmation page

    Examples: 
      | username              | password   |  productName  |
      | golu123@gmail.com     | Golu@123   | ZARA COAT 3   |
      | siddhu@patil.com      | Siddhu@123 | IPHONE 13 PRO |
