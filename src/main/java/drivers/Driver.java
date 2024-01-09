package drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
	private static final Logger log = LogManager.getLogger();

	/**
	 * Set up code for chrome
	 * Includes browser windows size and remote origins	 *  allow
	 * remote origins	 *  allow helps in allowing chrome to run on any port
	 */

	public WebDriver chrome() {
		log.info("Setting up the Chrome browser");
		//	Code for Chrome options
		ChromeOptions opt = new ChromeOptions();

		//	Code to Maximize windows and allow remote origins
		opt.addArguments("--start-maximized", "--remote-allow-origins=*");

		//	Returns code to test page along with the Chrome options
		return new ChromeDriver(opt);
	}
}