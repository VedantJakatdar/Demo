package vedant.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import vedant.testcomponents.BaseTest;

public class Validations extends BaseTest {
	
	@Test //(groups = {"ErrorHandling"})
	public void errorValidation() {
		String username = "golu123@gmail.com";
		String password = "Golu@";
		loginPage.loginMethod(username, password);
		String errorMessage = loginPage.getErrorMessage();
		assertEquals(errorMessage, "Incorrect email or password.");
	}
	
}
