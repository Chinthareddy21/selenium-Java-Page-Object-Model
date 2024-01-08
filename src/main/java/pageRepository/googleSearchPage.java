package pageRepository;

import credentials.keywords;
import objectRepository.googleSearchObjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import url.url;

import java.util.Objects;

public class googleSearchPage {
	/*
	Urls set up constructor
	Import urls from urls page in the main module
	*/
	private static final url URL = new url();
	/*
	Urls set up constructor
	Import urls from urls page in the main module
	*/
	private static final keywords text = new keywords();

	public void navigation(WebDriver driver) {
		driver.get(URL.baseURL());
	}

	public void searchBoxAssertion(WebDriver driver) {
		assert googleSearchObjects.searchBox(driver).isDisplayed();
	}

	public void enterSearchText(WebDriver driver) {
		googleSearchObjects.searchBox(driver).sendKeys(text.searchText());
	}

	public void clickingEnter(WebDriver driver) {
		googleSearchObjects.searchBox(driver).sendKeys(Keys.RETURN);
	}

	public void navigationAssertion(WebDriver driver) {
		String searchText = googleSearchObjects.searchBox(driver).getText();
		assert Objects.equals(searchText, text.searchText());
	}
}