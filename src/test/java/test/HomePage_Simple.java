package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.Pageobj_HomePage_Simple;

public class HomePage_Simple extends BaseRediffSimple{
	
	 @Test(priority = 1)
	 @Parameters({ "browser_simple,urlRediff" })
	 public void homepageAction() {
	 Pageobj_HomePage_Simple obj=new Pageobj_HomePage_Simple(driver);	 
		  obj.clickrediffHomepage();
		  driver.navigate().back();
 	}
 
 @Test(priority = 2)
 @Parameters({ "browser_simple,url_simple" })
 	public void signinAction() {
	 
	 Pageobj_HomePage_Simple obj=new Pageobj_HomePage_Simple(driver);	 
	  obj.clickmoneybtn();
	  driver.navigate().back();
	  obj.screen(driver, "D:");
	  obj.Linkclick();
	  driver.quit();
 	}

}

//  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000)); 
//  driver.manage().window().maximize();	 