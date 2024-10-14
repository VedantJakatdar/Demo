package vedant.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vedant.abstractcomponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userEmail")
	WebElement userName;
	
	@FindBy(id = "userPassword")
	WebElement userPass;
	
	@FindBy(id = "login")
	WebElement loginButton;
	
	@FindBy(id = "toast-container")
	WebElement errorPopUp;
	
	By toastElement = By.id("toast-container");
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	
	public void login(String[] username, String[] password) { //String username, String password
		String name = username[0];
		String pass = password[0];
		userName.sendKeys(name);
		userPass.sendKeys(pass);
		loginButton.click();
	}
	
	public void loginMethod(String username, String password) { //String username, String password
		userName.sendKeys(username);
		userPass.sendKeys(password);
		loginButton.click();
	}
	
	public String waitForElementToBeVisible() {
		String message = waitForElementToBeVisible(toastElement);
		return message;
	}
	
	public String getErrorMessage() {
		String errorMessage = waitForWebElementToBeVisible(errorPopUp);
		return errorMessage;
	}
}
