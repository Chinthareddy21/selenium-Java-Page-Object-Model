package pageRepository;

import com.aventstack.extentreports.ExtentTest;
import extentReports.extentReporter;
import objectRepository.googleSearchObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	//	logger set up constructor
	private static final Logger log = LogManager.getLogger();
	private static final extentReporter extent = new extentReporter();

	//	Extent test dialog constructor
	private static ExtentTest test;

	/**
	 * Code for test actions
	 * Returns actions code to the test page
	 */

	/*
	This block contains code for navigation
	The code will be returned to test page
	 */
	public void navigation(WebDriver driver) {
		log.info("Entering url");
		driver.get(URL.baseURL());
		log.info("Entered url");
		if (Objects.equals(driver.getCurrentUrl(), URL.baseURL())) {
			test = extent.extentTest("Navigation");
			test.pass("Successfully navigated to the basePage");
		} else {
			test = extent.extentTest("Navigation");
			test.fail("failed to navigate to the basePage");
		}
	}

	/*
	This block contains code for asserting user is navigated to google search page
	by verifying the search box is visible or not
	The code will be returned to test page
	 */
	public void searchBoxAssertion(WebDriver driver) {
		log.info("Asserting Search box is visible or not");
		if (googleSearchObjects.searchBox(driver).isDisplayed()) {
			test = extent.extentTest("Search Box assertion");
			test.pass("Search Box is visible");
			log.info("Search box is visible");
		} else {
			test = extent.extentTest("Search Box assertion");
			test.pass("Search Box isn't visible");
			log.error("Search box isn't visible");
		}
	}

	/*
	This block contains code for sending search text into the search box for
	searching
	The code will be returned to test page
	 */
	public void enterSearchText(WebDriver driver, String string) {
		if (googleSearchObjects.searchBox(driver).isEnabled()) {
			log.info("Entering search text");
			googleSearchObjects.searchBox(driver).sendKeys(string);
			log.info("Entered text");
		} else {
			log.error("Failed to enter the text");
		}

	}

	/*
	This block contains code for clicking enter after entering search text
	The code will be returned to test page
	 */
	public void clickingEnter(WebDriver driver, Keys enter) {
		log.info("Pressing enter key to search");
		googleSearchObjects.searchBox(driver).sendKeys(enter);
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
		log.info("Asserting search results page");
		assert Objects.equals(searchText, string);
	}
}