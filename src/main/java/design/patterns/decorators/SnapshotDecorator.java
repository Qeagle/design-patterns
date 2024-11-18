package design.patterns.decorators;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;


public class SnapshotDecorator implements WebElementActions{
	
	private WebElementActions actions;
	private int i=1;
	private static final Logger logger = Logger.getLogger(SnapshotDecorator.class.getName());

	public SnapshotDecorator(WebElementActions actions) {
		this.actions = actions;
	}

	@Override
	public void click(WebElement ele) {
		actions.click(ele);
		takeSnap(ele);
		logger.info("Snap for click is done");
	}

	@Override
	public void sendKeys(WebElement ele, CharSequence text) {
		actions.sendKeys(ele, text);
		takeSnap(ele);
		logger.info("Snap for sendkeys is done");
	}
	
	private void takeSnap(WebElement ele) {
		File screenshotAs = ele.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs, new File(i+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
	}

}
