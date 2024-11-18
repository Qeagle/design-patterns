package design.patterns.decorators;

import java.util.logging.Logger;
import org.openqa.selenium.WebElement;


public class LoggingDecoratorElement implements WebElementActions{
	
	private WebElementActions actions;
	private static final Logger logger = Logger.getLogger(LoggingDecoratorElement.class.getName());

	public LoggingDecoratorElement(WebElementActions actions) {
		this.actions = actions;
	}

	@Override
	public void click(WebElement ele) {
		logger.info("About to click");
		actions.click(ele);
		logger.info("Click is done");
	}

	@Override
	public void sendKeys(WebElement ele, CharSequence text) {
		logger.info("About to type");
		actions.sendKeys(ele, text);
		logger.info("Type is done");
	}

}
