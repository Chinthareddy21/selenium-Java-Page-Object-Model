package pageRepository;

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

	/**
	 * Code for test actions
	 * Returns actions code to the test page
	 */

	/*
	This block contains code for navigation
	The code will be returned to test page
	 */
	public void navigation(WebDriver driver) {
		driver.get(URL.baseURL());
	}

	/*
	This block contains code for asserting user is navigated to google search page
	by verifying the search box is visible or not
	The code will be returned to test page
	 */
	public void searchBoxAssertion(WebDriver driver) {
		assert googleSearchObjects.searchBox(driver).isDisplayed();
	}

	/*
	This block contains code for sending search text into the search box for
	searching
	The code will be returned to test page
	 */
	public void enterSearchText(WebDriver driver, String string) {
		googleSearchObjects.searchBox(driver).sendKeys(string);
	}

	/*
	This block contains code for clicking enter after entering search text
	The code will be returned to test page
	 */
	public void clickingEnter(WebDriver driver) {
		googleSearchObjects.searchBox(driver).sendKeys(Keys.RETURN);
	}

	/*
	This block contains code for asserting results are displayed as per the search
	by verifying the search box text
	The code will be returned to test page
	 */
	public void navigationAssertion(WebDriver driver, String string) {
		//	This code is for getting the text in the search box of results page
		String searchText = googleSearchObjects.searchBox(driver).getText();

		//  This code is for asserting the text in the search box of results page
		assert Objects.equals(searchText, string);
	}
}