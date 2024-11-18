package design.patterns.factory.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface WebDriverFactoryInterface {

	WebDriver createDriver(BrowserType browserType, Capabilities capabilities);
	void setupDriver(String url);
}
