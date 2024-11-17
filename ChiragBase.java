package newtest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ChiragBase {
	ChiragCommon common;
	public static WebDriver  driver;
	
	@BeforeTest
	@Parameters({"browser_simple","url_simple"})
	public void beforetest(String browser,String url) {
		
		common =new ChiragCommon();		
		common.SetupBrowser(browser,url);
		driver=common.getDriver();
	}
	
			
	@AfterTest	
	public void aftertest() {
		//Quite the browser
		common.QuitBrowser();
	
	}
}

