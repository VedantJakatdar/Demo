package vedant.pageobjects;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vedant.abstractcomponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> textElements;
	
	@FindBy(css = "li[class='totalRow'] button")
	WebElement checkOutButton;
	
	public SubmitOrderPage verifyAddedProductsToCart(String[] products) throws InterruptedException { //String[] products
		
		String[] prod = (String[]) products;
		List<String> prodList = Arrays.asList(prod);
		
		for(int i=0;i<textElements.size();i++) {
			String getText = textElements.get(i).getText();
			if(prodList.contains(getText)) {
				assertTrue(true);
			}
			else {
				assertTrue(false);
			}
		}
		
		scrollPageToBottom();
		SubmitOrderPage submitOrderPage = new SubmitOrderPage(driver);
		return submitOrderPage;
	}
	
public SubmitOrderPage verifyAddedProductToCart(String productName) throws InterruptedException { //String[] products
	    
		Boolean flag = textElements.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		assertTrue(flag);
		scrollPageToBottom();
		SubmitOrderPage submitOrderPage = new SubmitOrderPage(driver);
		return submitOrderPage;
	}
	
	public void scrollPageToBottom() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		checkOutButton.click();
	}

}
