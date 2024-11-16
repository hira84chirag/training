package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utili.Common;


public class BaseTest {
	Common common;
	public static WebDriver  driver;
	
	@BeforeTest
	@Parameters({"browser","url"})
	public void beforetest(String browser,String url) {
		
		common =new Common();		
		common.SetupBrowser(browser,url);
		driver=common.getDriver();
	}
	
			
	@AfterTest	
	public void aftertest() {
		//Quite the browser
		common.QuitBrowser();
	
	}
}
