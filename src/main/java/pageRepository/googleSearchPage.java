package pageRepository;

import com.aventstack.extentreports.ExtentTest;
import credentials.keywords;
import extentReports.extentReporter;
import objectRepository.googleSearchObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import url.url;
import utils.utils;

import java.util.Objects;

public class googleSearchPage extends utils {
	/*
	Urls set up constructor
	Import urls from urls page in the main module
	*/
	private static final url URL = new url();

	//	logger set up constructor
	private static final Logger log = LogManager.getLogger();
	private static final extentReporter extent = new extentReporter();
	private static final keywords keywords = new keywords();
	public static utils utils = new utils(driver);
	//	Extent test dialog constructor
	private static ExtentTest test;

	public googleSearchPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Code for test actions
	 * Returns actions code to the test page
	 */

	public void init() {
		PageFactory.initElements(driver, this);
	}

	/*
	This block contains code for navigation
	The code will be returned to test page
	 */
	public void navigation(WebDriver driver) {
		log.info("Entering url");
		utils.navigationToUrl(driver, URL.baseURL());
		log.info("Entered url");
		if (Objects.equals(driver.getCurrentUrl(), URL.baseURL())) {
			utils.navigationAssertions(driver, URL.baseURL());
			System.out.println(driver.getCurrentUrl());
			log.info("Successfully navigated to the basePage");
			test = extent.extentTest("Navigation");
			test.pass("Successfully navigated to the basePage");
		} else {
			test = extent.extentTest("Navigation");
			test.fail("failed to navigate to the basePage");
			log.error("Failed to navigate to base page");
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
			test.fail("Search Box isn't visible");
			log.error("Search box isn't visible");
		}
	}

	/*
	This block contains code for sending search text into the search box for
	searching
	The code will be returned to test page
	 */
	public void enterSearchText(WebDriver driver) {
		if (googleSearchObjects.searchBox(driver).isDisplayed()) {
			log.info("Entering search text");
			utils.sendingKeys(googleSearchObjects.searchBox(driver), keywords.searchText());
			log.info("Entered text");
			test = extent.extentTest("Entering search keys");
			test.pass("Successfully entered search keys");
		} else {
			test = extent.extentTest("Entering search keys");
			test.fail("Failed to enter search keys");
			log.error("Failed to enter the text");
		}

	}

	/*
	This block contains code for clicking enter after entering search text
	The code will be returned to test page
	 */
	public void clickingEnter(WebDriver driver) {
		log.info("Pressing enter key to search");
		googleSearchObjects.searchBox(driver).sendKeys(Keys.RETURN);
	}

	/*
	This block contains code for asserting results are displayed as per the search
	by verifying the search box text
	The code will be returned to test page
	 */
	public void navigationAssertion(WebDriver driver, String string) {
		//	This code is for getting the text in the search box of results page
		String searchText = driver.getTitle();

		//  This code is for asserting the text in the search box of results page
		log.info("Asserting search results page");
		if (googleSearchObjects.searchBox(driver).isDisplayed()) {
			utils.textAssertion(string, searchText);
			test = extent.extentTest("Search results page");
			test.pass("Successfully navigated to search results page");
		} else {
			test = extent.extentTest("Search results page");
			test.fail("Failed to navigate to search results page");
			log.error("Failed to navigate to search results page");
		}
	}
}