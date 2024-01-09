/**
 * This is document for testing google search functionality Automation
 * Date of creation: January 8th 2024,
 * Author: Bhargava reddy Chinthareddy,
 * Purpose: for Learning, Training and Reference
 */

import credentials.keywords;
import drivers.Driver;
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
	//	Web driver constructor
	private static WebDriver driver;

	/**
	 * Runs before the test method to start the browser
	 */
	@BeforeTest
	public void setUp() {
		//	Chrome browser setup
		driver = drivers.chrome();
		log.info("Browser started");
	}

	/**
	 * Test class
	 */
	@Test(priority = 1)
	public void googleSearchNavigation() {
		//	Navigating to search page
		google.navigation(driver);
		log.info("Navigation successful");
		//	Asserting google search box is visible
		google.searchBoxAssertion(driver);
		log.info("Search box is visible");
	}

	@Test(priority = 3)
	public void googleSearchResults() {
		//	Asserting navigated to results page
		google.navigationAssertion(driver, text.searchText());
		log.info("Successfully navigated to results page");
	}

	@Test(priority = 2)
	public void googleSearchSearching() {
		//	Entering search text
		google.enterSearchText(driver, text.searchText());
		log.info("Entered search text");
		//	Clicking enter
		google.clickingEnter(driver);
		log.info("Clicked enter");
	}

	/**
	 * Runs after the test method to close the browser
	 */
	@AfterTest
	public void tearDown() {
		//	Quiting the browser
		driver.quit();
		log.info("Quiting the browser");
	}
}