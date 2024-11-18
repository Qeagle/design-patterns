package design.patterns.factory.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface Browser {
	
	/**
	 * Launches the browser with the specific URL and capabilities
	 * @param url	The URL to load the application
	 * @param capabilities The desired capabilities for the browser
	 * @return The instance of the browser as WebDriver
	 * @since v1.1
	 */
	
	WebDriver launchBrowser(Capabilities capabilities);

}
