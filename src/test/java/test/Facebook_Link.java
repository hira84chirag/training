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
import pom.Rediff_CreateAccount;
import utili.WaitUtils;

public class Facebook_Link extends BaseTest {
	
	Facebook_Link obj;
	Pom_Homepage_Link pagelink;
//	private WebDriver driver;
 //   private WaitUtils waitUtils;
    
	//public static WebDriver driver;
    
	
	@Test(priority = 1)
	@Parameters({"browser","url"})
	public void siteTitle(String browser,String url) {
		obj=new Facebook_Link();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		String str=driver.getTitle();
		Reporter.log(str);
	}
	
	@Test(priority = 2)
	public void pagelink() {
		//obj=new AccessUrl();
		
		Rediff_CreateAccount link=new Rediff_CreateAccount(driver);
	//	link.facebooklinks();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		Reporter.log("check links");		
		
	//	link.googlelinks();
		
	/*	waitUtils = new WaitUtils(driver, 20); 
		driver.get("https://rolls-royce.com/");
		WebElement element= driver.findElement(By.xpath("//a[@class='dynamic-signpost-link']"));
		waitUtils.waitForElementToBeVisible(element);
		element.click();
	*/

		
	}
	
	
}
