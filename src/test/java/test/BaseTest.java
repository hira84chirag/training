package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public  class BaseTest {

	BaseBrowser common;
	// if you want to run more than 1 test case then need to define public static driver.
	public static WebDriver  driver; 
	
//	String browser="chrome";
//	String url="https://www.google.com";
	
	@BeforeTest
	@Parameters({"browser","url"})
	public void beforetest(String browser,String url) {		
		common =new BaseBrowser();		
		common.SetupBrowser(browser,url);		
		driver=common.getDriver();
	}
				
	@AfterTest	
	public void aftertest() {
		//Quite the browser
		common.QuitBrowser();
	
	}
}

