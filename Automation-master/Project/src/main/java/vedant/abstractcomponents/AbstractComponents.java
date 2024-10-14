package vedant.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement myOrderButton;
	
	public String waitForElementToBeVisible(By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String toastText = wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator)).getText();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		return toastText;
	}
	
	public String waitForWebElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}
	
	public void clickOnCartButton() {
		cartButton.click();
	}
	
	public void clickOnMyOrderButton() {
		myOrderButton.click();
	}
	
}
