package vedant.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vedant.data.Data;
import vedant.pageobjects.CartPage;
import vedant.pageobjects.HomePage;
import vedant.pageobjects.OrderPage;
import vedant.pageobjects.SubmitOrderPage;
import vedant.testcomponents.BaseTest;

public class Testing extends BaseTest {
	
	@Test(dataProvider = "getData") //String username, String password, String[] products
	public void standAloneTest(HashMap<String, String[]> input) throws InterruptedException, IOException {
		
//		String[] products = {"ZARA COAT 3", "IPHONE 13 PRO"};
		String countryName = "india";
		
		loginPage.login(input.get("username"),input.get("password"));
		Thread.sleep(200);
		String successText = loginPage.waitForElementToBeVisible();
		Assert.assertEquals(successText, "Login Successfully");		
		HomePage homePage = new HomePage(driver);
		
		CartPage cartPage = homePage.addProductsToCart(input.get("products"));
		SubmitOrderPage submitOrderPage = cartPage.verifyAddedProductsToCart(input.get("products"));
		
		String orderText = submitOrderPage.placeOrder(countryName);
		Assert.assertEquals(orderText, "Order Placed Successfully");
		
	}
	
	@Test(dependsOnMethods = {"standAloneTest"}) //,dataProvider = "getData" 
	public void productsDeletion() {
		String username = "golu123@gmail.com";
		String password = "Golu@123";
		String[] products = {"ZARA COAT 3", "IPHONE 13 PRO"};
		loginPage.loginMethod(username, password);
		loginPage.waitForElementToBeVisible();
		OrderPage orderPage = new OrderPage(driver);
		orderPage.deleteOrderedProductsOnMyOrdersPage(products);
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException { // Object[][] //HashMap<Object, Object>
		
//		HashMap<String, String[]> map = new HashMap<String, String[]>();
//		
//		map.put("username", new String[] {"golu123@gmail.com"});
//		map.put("password", new String[] {"Golu@123"});
//		map.put("products", new String[] {"ZARA COAT 3","IPHONE 13 PRO"});
//		
//		HashMap<String, String[]> map1 = new HashMap<String, String[]>();
//		
//		map1.put("username", new String[] {"siddhu@patil.com"});
//		map1.put("password", new String[] {"Siddhu@123"});
//		map1.put("products", new String[] {"ZARA COAT 3","ADIDAS ORIGINAL"});
		
		List<HashMap<String, String[]>> data = Data.getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//vedant//data//Testing.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
//		return new Object[][] {{map},{map1}};
		
//		return new Object[][] {{"golu123@gmail.com","Golu@123", new String[]{"ZARA COAT 3","IPHONE 13 PRO"}},{"siddhu@patil.com","Siddhu@123", new String[]{"ZARA COAT 3","ADIDAS ORIGINAL"}}};
	}
}
