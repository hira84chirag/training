package test;

import org.testng.annotations.Test;

import pom.Rediff;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest extends BaseTest{
	Rediff obj;
	static int cd;
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
  @Test (priority=1)
  @Parameters({"urlRediff"})
public void method1(String url) {
	  	
	  	obj=new Rediff(driver);
	 	driver.manage().window().maximize();
	 	obj.signInClick();
//	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000)); 	 	 
	 	obj.clickLoginbtn();	 	
	 	String msg=driver.switchTo().alert().getText();
		Reporter.log(msg);	
		driver.switchTo().alert().accept();
			
  }
//  @Test
  @Parameters({"url"})
  public void method2(String url) {
	String msg1,msg3;
	cd=0;
	obj=new Rediff(driver);
	url="https://demoqa.com/browser-windows";
	driver.get(url);
	
	obj.clickWinbtn();
	cd++;
	obj.clickmsgwinbtn();
	cd++;
	//obj.chidlwindow(driver);
	
	driver.getCurrentUrl();
	String MainWindow = driver.getWindowHandle();
    System.out.println("Main window handle is " + MainWindow);

    // To handle all new opened window
    Set<String> s1 = driver.getWindowHandles();
    System.out.println("Child window handle is" + cd);
    Iterator<String> i1 = s1.iterator();

	while (i1.hasNext()) {
  	  
        String ChildWindow = i1.next();
        if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
            driver.switchTo().window(ChildWindow);
            cd++;              
            driver.close();
            
        }
     }
    	Reporter.log("Total window =" + cd);	
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

  }

}
