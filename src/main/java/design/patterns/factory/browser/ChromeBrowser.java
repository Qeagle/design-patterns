package design.patterns.factory.browser;

import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser implements Browser {

	private static final Logger logger = Logger.getLogger(ChromeBrowser.class.getName());
	
	@Override
	public WebDriver launchBrowser(Capabilities capabilities) {
				
		ChromeOptions options;
		if(capabilities instanceof ChromeOptions) {
			options = (ChromeOptions)capabilities;
		} else {
			// send default chrome options
			options = new ChromeOptions();
			logger.warning("The provided chrome options were not compatible, hence reset to default");
		}
		logger.info("The chrome browser is launched with the chromeoptions");
		return new ChromeDriver(options);
	}

}
