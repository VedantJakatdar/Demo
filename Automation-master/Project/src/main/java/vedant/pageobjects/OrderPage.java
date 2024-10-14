package vedant.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vedant.abstractcomponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tr/td[2]")
	WebElement orderElements;
	
	@FindBy(xpath = "//tr/td[6]/button")
	WebElement deleteButtons;
	
	By toast = By.id("toast-container");
	
	public void deleteOrderedProductsOnMyOrdersPage(String[] products) {
		
		clickOnMyOrderButton();
		List<String> prodList = Arrays.asList(products);
		
//		for(int i=0;i<products.length;i++) {
//			String getOrderedProductName = orderElements.getText();
//			if(prodList.contains(getOrderedProductName)) {
//				deleteButtons.click();
//				System.out.println(waitForElementToBeVisible(toast));
//			}	
//		}
		int i=0;
		while(i<products.length) {
			String getOrderedProductName = orderElements.getText();
			if(prodList.contains(getOrderedProductName)) {
				deleteButtons.click();
				i++;
				System.out.println(waitForElementToBeVisible(toast));
			}
		}
	}
	
	
}
