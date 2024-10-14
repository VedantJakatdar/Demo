package vedant.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vedant.pageobjects.CartPage;
import vedant.pageobjects.HomePage;
import vedant.pageobjects.LoginPage;
import vedant.pageobjects.SubmitOrderPage;
import vedant.testcomponents.BaseTest;

public class StepDefinitionImpl extends BaseTest {
	
	LoginPage loginPage; 
	HomePage homePage;
	CartPage cartPage;
	SubmitOrderPage submitOrderPage;
	
	@Given("I landed on login page of e-commerce website") 
	public void i_landed_on_login_page_of_ecommerce_website() throws IOException
	{
		loginPage = launchApplication();
	}
	
	@And("^I logged in with username (.+) and password (.+)$") 
	public void i_logged_in_with_username_and_password(String username, String password) throws IOException {
		loginPage.loginMethod(username, password);
	}
	
	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) {
		homePage = new HomePage(driver);
		cartPage = homePage.addProductToCart(productName);
	}
	
	@And("^I checkout (.+) and submit order$")
	public void i_checkout_and_submit_order(String productName) throws InterruptedException {
		submitOrderPage = cartPage.verifyAddedProductToCart(productName);
	}
	
	@Then("{string} message is displayed on confirmation page")
	public void order_placed(String message) {
		String orderText = submitOrderPage.placeOrder("india");
		assertEquals(message, orderText);
		tearDown();
	}
	
	@When("^I log in with username (.+) and password (.+)$")
	public void login_in(String username, String password) {
		loginPage.loginMethod(username, password);
	}
	
	@Then("^(.+) message is displayed$")
	public void message_is_displayed(String message) {
		String errorMessage = loginPage.getErrorMessage();
		assertEquals(message , errorMessage);
	}
}
