package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups="Regression")
	public void verifyLogin() {
		HomePage home =new HomePage(driver);
		home.clickMyAccount();
		home.clickLogin();
		
		LoginPage login = new LoginPage(driver);
		login.setEmail(property.getProperty("email"));
		login.setPassword(property.getProperty("password"));
		login.clickLogin();
		
		MyAccountPage account = new MyAccountPage(driver);
		boolean isExist = account.isAccountExists();
		Assert.assertTrue(isExist);
	}
}
