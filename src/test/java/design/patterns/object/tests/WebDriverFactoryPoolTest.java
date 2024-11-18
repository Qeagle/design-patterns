package design.patterns.object.tests;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import design.patterns.factory.browser.BrowserType;
import design.patterns.factory.browser.FirefoxBrowser;
import design.patterns.factory.browser.WebDriverFactory;
import design.patterns.factory.browser.WebDriverFactoryInterface;
import design.patterns.object.pool.WebDriverPoolFactory;

public class WebDriverFactoryPoolTest {
	
	private static final Logger logger = Logger.getLogger(WebDriverFactoryPoolTest.class.getName());

	public static void main(String[] args) {
		
		// Initialize >> Factory
		WebDriverFactoryInterface factory = new WebDriverFactory();
		
		// Initialize >> Object Pool
		WebDriverPoolFactory pool = new WebDriverPoolFactory(factory);
		
		// Applications
		String url1 = "https://google.com";
		String url2 = "https://leafground.com";
		
		// Chrome Options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-fullscreen");
		options.addArguments("--headless");

		ChromeOptions options3 = new ChromeOptions();
		options3.addArguments("--headless");
		options3.addArguments("--start-fullscreen");
		
		FirefoxOptions options1 = new FirefoxOptions();
		//options1.addArguments("");
		
		// test 1 >> chrome >> url1 
		// test 2 >> chrome >> url2
		// test 3 >> firefox >> url1
		// test 3 >> firefox >> url2
		
		testOne(pool, BrowserType.CHROME, url1, options);
		testTwo(pool, BrowserType.CHROME, url2, options3);
		//testThree(pool, BrowserType.FIREFOX, url1, options);
		//testFour(pool, BrowserType.FIREFOX, url2, options);
		
		
	}

	private static void testFour(WebDriverPoolFactory pool, BrowserType browser, String url2, ChromeOptions options) {
		logger.info("The test 4 started");
		WebDriver driver = pool.getDriver(browser,url2, options);
		
		logger.info("Title >> "+driver.getTitle());
		pool.releaseDriver(driver);
		logger.info("The test 4 completed");
	}

	private static void testThree(WebDriverPoolFactory pool, BrowserType browser, String url1, ChromeOptions options) {
		logger.info("The test 3 started");
		WebDriver driver = pool.getDriver(browser,url1,options);
		logger.info("Title >> "+driver.getTitle());
		pool.releaseDriver(driver);
		logger.info("The test 3 completed");
	}

	private static void testTwo(WebDriverPoolFactory pool, BrowserType browser, String url2, ChromeOptions options) {
		logger.info("The test 2 started");
		WebDriver driver = pool.getDriver(browser,url2, options);
		logger.info("Title >> "+driver.getTitle());
		pool.releaseDriver(driver);
		logger.info("The test 2 completed");
		
	}

	private static void testOne(WebDriverPoolFactory pool, BrowserType browser, String url1, ChromeOptions options) {
		
		logger.info("The test 1 started");
		WebDriver driver = pool.getDriver(browser,url1,options);
		logger.info("Title >> "+driver.getTitle());
		pool.releaseDriver(driver);
		logger.info("The test 1 completed");
		
		
	}

}
