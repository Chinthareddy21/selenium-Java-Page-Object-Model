package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class utils {
	protected static WebDriver driver;

	public utils(WebDriver driver) {
		utils.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigationToUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public boolean navigationAssertions(WebDriver driver, String navURL) {
		Assert.assertEquals(driver.getCurrentUrl(), navURL);
		return false;
	}

	public boolean textAssertion(String Expected, String Actual) {
		Assert.assertEquals(Actual, Expected);
		return false;
	}

	public boolean visibilityAssertion(WebElement locator) {
		Assert.assertTrue(locator.isDisplayed());
		return false;
	}

	public void sendingKeys(WebElement locator, String textWord) {
		locator.sendKeys(textWord);
	}
}