package design.patterns.factory.browser;

import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory implements WebDriverFactoryInterface{
	
	private WebDriver driver;

	@Override
	public WebDriver createDriver(BrowserType browserType,Capabilities capabilities) {
	
		Browser browser;
		
		switch(browserType) {
			case CHROME:
				browser = new ChromeBrowser();
				break;
			case FIREFOX:
				browser = new FirefoxBrowser();
				break;
			default:
				throw new IllegalArgumentException("Unsupported Browser Type :"+browserType);
		}
		
		driver = browser.launchBrowser(capabilities);
		return driver;
	}

	

	@Override
	public void setupDriver(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
	}

	
}