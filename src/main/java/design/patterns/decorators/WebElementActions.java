package design.patterns.decorators;

import org.openqa.selenium.WebElement;

public interface WebElementActions {

	void click(WebElement ele);
	void sendKeys(WebElement ele, CharSequence text);
	
	// add more functions as you want
}
