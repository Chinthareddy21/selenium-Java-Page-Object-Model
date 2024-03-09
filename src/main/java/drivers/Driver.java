package drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	private static final Logger log = LogManager.getLogger();
	private static WebDriver driver;

	public WebDriver Browsers(String browser) {
		switch (browser) {
			case "chrome":
				log.info("Setting up the Chrome browser");
				//	Code for Chrome options
				ChromeOptions opt = new ChromeOptions();

				//	Code to Maximize windows and allow remote origins
				opt.addArguments("--start-maximized", "--remote-allow-origins=*");

				//	Returns code to test page along with the Chrome options
				driver = new ChromeDriver(opt);
				break;
			case "firefox":
				log.info("Setting up the firefox browser");

				//	Returns code to test page along with the Chrome options
				driver = new FirefoxDriver();
				break;
			case "edge":
				log.info("Setting up the edge browser");

				//	Returns code to test page along with the Chrome options
				driver = new EdgeDriver();
				break;
			default:
				System.out.print(browser + "is not supported please try other");
				return null;
		}
		return driver;
	}
}