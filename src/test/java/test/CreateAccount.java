package test;

import org.testng.annotations.Test;

import pom.Pageobj_HomePage;
import pom.pageobj_HomePage_registerPage;
import org.openqa.selenium.devtools.v128.filesystem.model.File;
import org.testng.annotations.Parameters;

public class CreateAccount extends BaseRediff {
	pageobj_HomePage_registerPage obj;

	@Test
	@Parameters({ "urlRediff" })
	public void CrtAccount(String url) {
		obj=new pageobj_HomePage_registerPage(driver); // driver.manage().window().maximize();
		obj.clickCreatbtn();
		obj.crateAccount();
		obj.inspectEle();
		Pageobj_HomePage obj1=new Pageobj_HomePage(driver);
		obj1.CreateImage("NewAccount");
	}
	
}