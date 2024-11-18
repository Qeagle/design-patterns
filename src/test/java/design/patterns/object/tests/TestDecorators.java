package design.patterns.object.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import design.patterns.decorators.ElementActions;
import design.patterns.decorators.LoggingDecoratorElement;
import design.patterns.decorators.SnapshotDecorator;
import design.patterns.decorators.WebElementActions;

public class TestDecorators {
	
	public static void main(String[] args) {
		
		WebElementActions actions = new ElementActions();
		LoggingDecoratorElement logging = new LoggingDecoratorElement(actions);
		SnapshotDecorator snap = new SnapshotDecorator(actions);

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		WebElement username = driver.findElement(By.id("username"));
		snap.sendKeys(username, "demosalesmanager");
		
		
	}

}
