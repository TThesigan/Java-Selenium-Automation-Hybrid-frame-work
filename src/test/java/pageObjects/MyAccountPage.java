package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement pageHeading;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement confirmLogoutBtn;

	public boolean isAccountExists() {
		try {
			return (pageHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {
		Actions actions = new Actions(driver);
		actions.moveToElement(lnkLogout).click().perform();
	}

	public void clickConfirmLogout() {
		confirmLogoutBtn.click();
	}
}
