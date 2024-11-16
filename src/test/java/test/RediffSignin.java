package test;

import org.testng.annotations.Test;
import pom.pageobj_HomePage_Login;

import static org.testng.Assert.assertNotNull;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class RediffSignin extends BaseRediff {
	pageobj_HomePage_Login obj;
	
	@Test
	@Parameters({ "urlRediff" })
	public void HomeRediff(String url) {
		obj=new pageobj_HomePage_Login(driver); // driver.manage().window().maximize();
		driver.get(url);
		obj.clicksignbtn();
		obj.loginWithCredetials("softwaretesting@gmail.com", "edurekatesting");
		Reporter.log(obj.getusername());
		Reporter.log(obj.getproceed());
		Reporter.log(obj.getforget());
		assertNotNull(obj.getusername(), "email field is blanked");
	}	

}
