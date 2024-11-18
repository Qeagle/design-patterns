package design.patterns.object.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import design.patterns.factory.browser.BrowserType;
import design.patterns.factory.browser.ChromeBrowser;
import design.patterns.factory.browser.WebDriverFactory;
import design.patterns.factory.browser.WebDriverFactoryInterface;

public class WebDriverPoolFactory {

	private static final Logger logger = Logger.getLogger(WebDriverPoolFactory.class.getName());

	// Factory Object for Browser factory
	private WebDriverFactoryInterface driverFactory;
	
	// Store the Browser Type and Queue
	private ConcurrentMap<BrowserType, BlockingQueue<WebDriver>> driverPool;
	
	// Map to track : WebDriver, BrowserType
	private ConcurrentMap<WebDriver, BrowserType> driverToBrowserKey;
	
	// Constructor
	public WebDriverPoolFactory(WebDriverFactoryInterface factory) {
		this.driverFactory = factory;
		driverPool = new ConcurrentHashMap<BrowserType, BlockingQueue<WebDriver>>();
		driverToBrowserKey = new ConcurrentHashMap<WebDriver, BrowserType>();
		
		//  for every browser type, create new Blocking Queue
		for (BrowserType browserType : BrowserType.values()) {
			driverPool.put(browserType, new LinkedBlockingQueue<WebDriver>());
		}
	}
	
	
	public WebDriver getDriver(BrowserType browserType, String url, Capabilities capabilities) {
		BlockingQueue<WebDriver> queue = driverPool.get(browserType);
		WebDriver driver = queue.poll();
		if(driver == null) {
			driver = driverFactory.createDriver(browserType, capabilities);
			driverToBrowserKey.put(driver, browserType);
			logger.info("The driver did not exist before"+driver.hashCode()+". Added in the map after creating");
		} else {
			logger.info("Reusing the existing driver "+driver.hashCode());
		}
		driverFactory.setupDriver(url);
		return driver;
	}
	
	public void releaseDriver(WebDriver driver) {
		BrowserType browserType = driverToBrowserKey.get(driver);
		
		if(browserType != null) {
			BlockingQueue<WebDriver> queue = driverPool.get(browserType);
			queue.offer(driver);
		} else {
			driver.quit();
			logger.warning("Could not find the browser type "+browserType+" hence quit browser");
		}
	}
	
	
	
	
}
