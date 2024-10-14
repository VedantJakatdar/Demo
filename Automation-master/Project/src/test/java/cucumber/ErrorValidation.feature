@tag
Feature: Error validation of login page of ecommerce website
  I want to use this template for my feature file

  @verifyMessage
  Scenario Outline: Negative scenario of validation
    Given I landed on login page of e-commerce website
    When I log in with username <username> and password <password>
    Then <message> message is displayed

    Examples: 
      | 	username      | password |  				message 					 |
      |siddhu@patil.com | Siddhu@  | Incorrect email or password.|
