package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utili.Common;



public class BaseRediffSimple {
	Common common;
	//String  browser="chrome";
	//String url="http://wwww.facebook.com";
	public static WebDriver  driver;
	
	// String browser,String url
	
	@BeforeTest
	@Parameters({"browser","urlRediff"})
	public void beforetest(String browser,String url) throws Exception {
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
