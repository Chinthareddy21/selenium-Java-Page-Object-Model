package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class googleSearchObjects {

	/**
	 * Constructors
	 */

	//	Web element constructor
	private static WebElement element;

	/*
	Code for Google search box xpath and returning the element to the required location
	 */
	public static WebElement searchBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));
		return element;
	}
}