/**
 * This is document for testing google search functionality Automation
 * Date of creation: January 8th 2024,
 * Author: Bhargava reddy Chinthareddy,
 * Purpose: for Learning, Training and Reference
 */

import com.aventstack.extentreports.ExtentTest;
import credentials.keywords;
import drivers.Driver;
import extentReports.extentReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageRepository.googleSearchPage;


public class GoogleSearchTest {
	/**
	 * Constructors
	 */
	//	logger set up constructor
	private static final Logger log = LogManager.getLogger();
	/*
	Browser set up constructor
	Import browser setup data commands
	*/
	private static final Driver drivers = new Driver();
	private static final googleSearchPage google = new googleSearchPage();
	private static final keywords text = new keywords();
	private static final extentReporter extent = new extentReporter();
	//	Web driver constructor
	private static WebDriver driver;
	//	Extent test dialog constructor
	ExtentTest test;

	/**
	 * Runs before the test method to start the browser
	 */
	@BeforeTest
	public void setUp() {
		try {
			//	Chrome browser setup
			driver = drivers.chrome();
			log.info("Browser started");
			extent.extentSetUp();
			test = extent.extentTest("Browser SetUp");
			test.pass("Successfully started the browser");
		} catch (Exception e) {
			test.fail(e);
			test.fail("Fail to start the browser");
		}
	}

	/**
	 * Test class
	 */
	@Test(priority = 1)
	public void googleSearchNavigation() {
		try {
			//	Navigating to search page
			google.navigation(driver);
			log.info("Navigation successful");
			//	Asserting google search box is visible
			google.searchBoxAssertion(driver);
			log.info("Search box is visible");
			test = extent.extentTest("Navigation test");
			test.pass("Successfully navigated");
		} catch (Exception e) {
			test.fail(e);
			test.fail("Failed to Navigate");
		}
	}

	@Test(priority = 3)
	public void googleSearchResults() {
		//	Asserting navigated to results page
		try {
			google.navigationAssertion(driver, text.searchText());
			log.info("Successfully navigated to results page");
			test = extent.extentTest("Search results test");
			test.pass("Assertion passed");
		} catch (Exception e) {
			test.fail(e);
			test.fail("Search failed");
		}
	}

	@Test(priority = 2)
	public void googleSearchSearching() {
		try {
			//	Entering search text
			google.enterSearchText(driver, text.searchText());
			log.info("Entered search text");
			//	Clicking enter
			google.clickingEnter(driver);
			log.info("Clicked enter");
			test = extent.extentTest("Searching test");
			test.pass("Successfully started searching");
		} catch (Exception e) {
			test.fail(e);
			test.fail("Failed to navigate to search page");
		}
	}

	/**
	 * Runs after the test method to close the browser
	 */
	@AfterTest
	public void tearDown() {
		try {
			//	Quiting the browser
			driver.quit();
			log.info("Quiting the browser");
			test = extent.extentTest("Closing the browser");
			test.pass("Successfully closed the browser");
		} catch (Exception e) {
			test.fail(e);
			test.fail("Failed to close the browser");
		}
		extent.extentTearDown();
	}
}