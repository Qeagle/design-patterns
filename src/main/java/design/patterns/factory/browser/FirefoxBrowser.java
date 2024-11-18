package design.patterns.factory.browser;

import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser implements Browser {

	private static final Logger logger = Logger.getLogger(FirefoxBrowser.class.getName());
	
	@Override
	public WebDriver launchBrowser(Capabilities capabilities) {
				
		FirefoxOptions options;
		if(capabilities instanceof FirefoxOptions) {
			options = (FirefoxOptions)capabilities;
		} else {
			// send default firefox options
			options = new FirefoxOptions();
			logger.warning("The provided firefox options were not compatible, hence reset to default");
		}
		logger.info("The firefox browser is launched with the firefoxoptions");
		return new FirefoxDriver(options);
	}
	
	

}
