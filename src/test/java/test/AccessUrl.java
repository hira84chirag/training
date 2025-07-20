package test;


import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersetup.LocalDriverInstance;
import pom.Base;

public class AccessUrl extends BaseTest {
	
	AccessUrl obj;
	Base emailaddress;
	//Logger log;
	@Test(priority = 1)
	@Parameters({"browser","url"})
	public void siteTitle(String browser,String url) {
		obj=new AccessUrl();
		String str=driver.getTitle();
		Reporter.log(str);
	//	log = Logger.getLogger("devpinoyLogger");
	}
	
	@Test(priority = 2)
	public void enteremail() {
		//obj=new AccessUrl();
		Base emailaddress=new Base(driver);
		emailaddress.entername();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		Reporter.log("enter username");
		
	}
	
	@Test(priority = 3)
	public void enterpass() {
	//	log.debug("homePageShortCut method start");
		//obj=new AccessUrl();
		emailaddress=new Base(driver);
		emailaddress.clicklogin();
		emailaddress.enterpass();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		Reporter.log("enter password");
		
		driver.navigate().back();
	//	log.debug("homePageShortCut method end");
	}
	
}
