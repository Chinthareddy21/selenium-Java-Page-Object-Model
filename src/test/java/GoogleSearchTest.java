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
import org.openqa.selenium.Keys;
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
	private static ExtentTest test;

	/**
	 * Runs before the test method to start the browser
	 */
	@BeforeTest
	public void setUp() {
		//	Chrome browser setup
		driver = drivers.Browsers("edge");
		extent.extentSetUp();
		test = extent.extentTest("Browser SetUp");
		test.pass("Successfully started the browser");
	}

	/**
	 * Test class
	 */
	@Test(priority = 1)
	public void googleSearchNavigation() {
		//	Navigating to search page
		google.navigation(driver);
		//	Asserting google search box is visible
		google.searchBoxAssertion(driver);
	}

	@Test(priority = 3)
	public void googleSearchResults() {
		//	Asserting navigated to results page
		google.navigationAssertion(driver, text.searchText());
		test = extent.extentTest("Search results test");
		test.pass("Assertion passed");
	}

	@Test(priority = 2)
	public void googleSearchSearching() {
		//	Entering search text
		google.enterSearchText(driver, text.searchText());
		//	Clicking enter
		google.clickingEnter(driver, Keys.RETURN);
		test = extent.extentTest("Searching test");
		test.pass("Successfully started searching");
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
			log.error(e);
			log.error("Failed to close the browser");
		}
		extent.extentTearDown();
	}
}