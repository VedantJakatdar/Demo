package vedant.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vedant.abstractcomponents.AbstractComponents;

public class HomePage extends AbstractComponents {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By toastElement = By.id("toast-container");
	
	@FindBy(css = ".card-body h5")
	List<WebElement> elements;
	
	@FindBy(xpath = "//button[@class='btn w-10 rounded']")
	List<WebElement> buttons;
	
	public CartPage addProductsToCart(String[] products) { //String[] products
		
		List<String> prodList = Arrays.asList(products);
		
		for(int i=0;i<elements.size();i++) {
			String getText = elements.get(i).getText();
			if(prodList.contains(getText)) {
				buttons.get(i).click();
				System.out.println(waitForElementToBeVisible(toastElement));
			}
		}
		
		clickOnCartButton();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public CartPage addProductToCart(String productName) { //String[] products
		
		for(int i=0;i<elements.size();i++) {
			String getText = elements.get(i).getText();
			if(productName.equals(getText)) {
				buttons.get(i).click();
				System.out.println(waitForElementToBeVisible(toastElement));
				break;
			}
		}
			clickOnCartButton();
			CartPage cartPage = new CartPage(driver);
			return cartPage;
	}

}
