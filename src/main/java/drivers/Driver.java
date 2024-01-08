package drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
	private static final Logger log = LogManager.getLogger();

	public WebDriver chrome() {
		log.info("Setting up the Chrome browser");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--start-maximized", "--remote-allow-origins=*");
		return new ChromeDriver(opt);
	}
}