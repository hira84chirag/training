package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class MethodTest {

	public static WebDriver driver;
	
	public void waitforElemnt(int time) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		System.out.println("Called implicitait session");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
}
