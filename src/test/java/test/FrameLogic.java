package test;

import org.testng.annotations.Test;

import pom.Oracle;
import pom.Rediff;
import utili.Common;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FrameLogic extends BaseTest {
	Oracle obj;

	@Test
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("Before Method= ");
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("Actual Result= ");
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("Actual Result= ");

	}

	@Test
	@Parameters({ "url" })
	public void method(String url) {
		obj=new Oracle(driver); // driver.manage().window().maximize();
		obj.packageListframeclick();
		obj.packageframeclick();
		obj.classframeclick();
		driver.quit();
	}
	@AfterClass
	public void afterClass() {
		Reporter.log("Actual Result= ");
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("Actual Result= ");
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("Actual Result= ");

	}

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Actual Result= ");

	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("Actual Result= ");
		driver.quit();

	}

}
