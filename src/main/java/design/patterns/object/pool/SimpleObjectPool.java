package design.patterns.object.pool;

import java.util.LinkedList;
import java.util.Queue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleObjectPool {
	
	// What is the preferred data structure ??
	
	// You like to store ?? WebDriver Object -- This is enough ??
	// Single Dimensional  (Good)
	// Set, List, Queue, Stack 
	// Parallel tests --> 4 drivers --> 4 tests --> release driver for next test to start !!
	// FI (Released) --> FO (Picked) :: Queue
	
	private Queue<WebDriver> driverQueue;
	
	// Create a new queue
	public SimpleObjectPool() {
		driverQueue = new LinkedList<WebDriver>();
	}
	
	// Create a chrome driver
	private WebDriver createDriver() {
		return new ChromeDriver();
	}
	
	// method --> getDriver
	public WebDriver getDriver() {
		
		if(!driverQueue.isEmpty()) {
			WebDriver driver = driverQueue.poll();
			System.out.println(driver.hashCode());
			return driver;
		} else {
			return createDriver();
		}
	}
	
	
	// method --> releaseDriver
	public void releaseDriver(WebDriver driver) {
		// condition, when I should not push
		if(driver != null) {
			driverQueue.offer(driver);
			System.out.println(driver.hashCode());
		}
		
	}
	
	// anything else
	public void closeAllDrivers() {
		while(!driverQueue.isEmpty()) {
			driverQueue.poll().quit();
		}
	}
	
	
	
	
	
	
	
	
	
}
