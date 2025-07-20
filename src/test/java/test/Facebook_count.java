package test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.Pom_Homepage_Link;
import utili.WaitUtils;

public class Facebook_count extends BaseTest {
	
	Facebook_count obj;
	Pom_Homepage_Link pagelink;
//	private WebDriver driver;
 //   private WaitUtils waitUtils;
    
	//public static WebDriver driver;
    
	
	@Test(priority = 1)
	@Parameters({"browser","url"})
	public void siteTitle(String browser,String url) {
		obj=new Facebook_count();
		String str=driver.getTitle();
		Reporter.log(str);
	}
	
	@Test(priority = 2)
	public void pagelink() {
		//obj=new AccessUrl();
		
		Pom_Homepage_Link link=new Pom_Homepage_Link(driver);
		link.facebooklinks();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
		Reporter.log("check links");		
		
		link.googlelinks();
		

		
	}
	
	
}
