package vedant.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vedant.abstractcomponents.AbstractComponents;

public class SubmitOrderPage extends AbstractComponents {
	
	WebDriver driver;
	
	public SubmitOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement selectCountryTextBox;
	
	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button")
	List<WebElement> selectCountryDropDown;
	
	@FindBy(css =  "a[class='btnn action__submit ng-star-inserted']")
	WebElement placeOrderButton;
	
	By byLocator = By.id("toast-container");
	
	public String placeOrder(String countryName) {
		selectCountryTextBox.sendKeys(countryName);
		selectCountryDropDown.stream().filter(dropDown->dropDown.getText().equalsIgnoreCase("india")).forEach(dropDown->dropDown.click());
		placeOrderButton.click();
		String orderText = waitForElementToBeVisible(byLocator);
		return orderText;
	}
	
}
