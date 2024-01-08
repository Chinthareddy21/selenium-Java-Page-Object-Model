package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class googleSearchObjects {
	private static WebElement element;

	public static WebElement searchBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));
		return element;
	}
}