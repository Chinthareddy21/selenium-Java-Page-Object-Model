package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class googleSearchObjects {

	/*
	Code for Google search box xpath and returning the element to the required location
	 */
	/**
	 * Constructors
	 */
	//	Web element constructor
	private static WebElement element;

	public static WebElement searchBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));
		return element;
	}
}