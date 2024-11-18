package design.patterns.object.tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import design.patterns.factory.browser.BrowserType;
import design.patterns.factory.browser.WebDriverFactory;

public class BrowserFactory {
	
	public static void main(String[] args) {
		
		WebDriverFactory factory = new WebDriverFactory();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		factory.createDriver(BrowserType.CHROME, options);
		factory.setupDriver("");
		
		FirefoxOptions options1 = new FirefoxOptions();
		options1.addArguments("--headless");
		factory.createDriver(BrowserType.FIREFOX, options1);
		factory.setupDriver("");

	}

}
