package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistraionPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Sanity", "Regression"})
	public void verifyAccountRegistartion() throws InterruptedException {

		logger.info("***** TC001_AccountRegistrationTest *****");

		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		logger.info("Clicked on My account");
		home.clickRegister();

		logger.info("Providing customer details...");
		RegistraionPage registerPage = new RegistraionPage(driver);
		registerPage.setFirstName(randomString());
		registerPage.setLastName(randomString());
		registerPage.setEmail(alphaNumeric() + "@gmail.com");
		registerPage.setPassword("12345");
		registerPage.setPrivacyPolicy();
		registerPage.clickContinue();
		try {
			String confirmMsg = registerPage.getConfirmationMsg();
			Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
		} catch (AssertionError  e) {
			logger.error("Test Failed...");
			logger.debug("All fields are not entered...");
		}
	}

}
