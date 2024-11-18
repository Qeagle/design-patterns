package design.patterns.object.pool;

import org.openqa.selenium.WebDriver;

public class ChromeTest {

	static SimpleObjectPool drivers;

	public static void main(String[] args) {
		drivers = new SimpleObjectPool();
		test1();
		test2();
		
	}
	
	static void test1() {
		WebDriver driver = drivers.getDriver();
		driver.get("https://google.com");
		drivers.releaseDriver(driver);
	}
	
	static void test2() {
		WebDriver driver = drivers.getDriver();
		driver.get("https://testleaf.com");
		drivers.releaseDriver(driver);
	}
	
	// performance, reusability
	// 1000 tests --> 1000 in parallel (No) --> 8 browsers at a time (garbage collection)
	// open browser ---> do some action --> close browsers (all memory will not be released)
	// expensive --> when you use single browser object for every test
	
	// object pool design pattern 

}
