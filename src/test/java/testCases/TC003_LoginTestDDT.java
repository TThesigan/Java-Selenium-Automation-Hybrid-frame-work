package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTestDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriven")
	public void verifyLoginDDT(String email, String pwd, String result) {
		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		home.clickLogin();

		LoginPage login = new LoginPage(driver);
		login.setEmail(email);
		login.setPassword(pwd);
		login.clickLogin();

		MyAccountPage account = new MyAccountPage(driver);
		boolean accountPageLoaded = account.isAccountExists();

		/*
		 * Data is valid - login success - test pass logout - login failed - test fail
		 */
		if (result.equalsIgnoreCase("valid")) {
			if (accountPageLoaded == true) {
				Assert.assertTrue(true);
				account.clickLogout();
				account.clickConfirmLogout();
			} else {
				Assert.assertTrue(false);
			}
		}

		/*
		 * Data is invalid - login success - test fail - logout - login failed - test
		 * pass
		 */
		if (result.equalsIgnoreCase("invalid")) {
			if (accountPageLoaded == true) {
				Assert.assertTrue(false);
				account.clickLogout();
				account.clickConfirmLogout();
			} else {
				Assert.assertTrue(true);
			}
		}
	}

}
