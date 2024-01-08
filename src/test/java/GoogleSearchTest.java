/**
 * This is document for testing google search functionality Automation
 * Date of creation: January 8th 2024,
 * Author: Bhargava reddy Chinthareddy,
 * Purpose: Learning, Training and for Reference
 */

import drivers.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import url.url;


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
	/*
	Urls set up constructor
	Import urls from urls page in the main module
	*/
	private static final url URL = new url();
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
	@Test
	public void googleSearch() {
		//	Navigating to search page
		driver.get(URL.baseURL());
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