package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//div[@id='alert']")
	WebElement alertMsg;
	
	@FindBy(xpath = "//button[@class='btn-close']")
	WebElement closeAlertWindow;

	public void setEmail(String email) {
		txtEmailAddress.clear();
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	public void closeAlert() {
		closeAlertWindow.click();
	}

}
