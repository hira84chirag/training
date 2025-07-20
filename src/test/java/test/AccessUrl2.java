package test;


import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.Base;

public class AccessUrl2 extends BaseTest {
	
	AccessUrl2 obj;
	Base emailaddress;
	
	@Test(priority = 1)
	@Parameters({"browser","url"})
	public void siteTitle(String browser,String url) {
		obj=new AccessUrl2();
		String str=driver.getTitle();
		Reporter.log(str);
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
		//obj=new AccessUrl();
		emailaddress=new Base(driver);
		emailaddress.clicklogin();
		emailaddress.enterpass();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		Reporter.log("enter password");

		driver.navigate().back();
	}
	
}
