package utili;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;



public class CommonTest {


	private WebDriver driver; 
	
		
	public void SetupBrowser(String browser,String url) {
	
		if (browser.equalsIgnoreCase("chrome")) 
			driver=new ChromeDriver();		
		else if(browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();			
		else if(browser.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();		
	
		else {
			System.out.println("valid browser no provided,hence quitting the automation run");	
			System.exit(0);
		}
		
		// open the domain
		if(url!="")	driver.get(url);
		else driver.get("about:blank");
	}
	
	// return the driver
	public WebDriver getDriver() {
		return driver;
	}
	// Close the tab	
	public void CloseTab() {
		driver.close();	
	}
	// Quit the browser
	public void QuitBrowser() {
		driver.quit();	
	}
	
	
	
	/*
	 * public static void takeSnapShot(WebDriver webdriver,String fileWithPath)
	 * throws Exception{ //Convert web driver object to TakeScreenshot
	 * TakesScreenshot scrShot =((TakesScreenshot)webdriver); //Call getScreenshotAs
	 * method to create image file File
	 * SrcFile=scrShot.getScreenshotAs(OutputType.FILE); //Move image file to new
	 * destination File DestFile=new File(fileWithPath); //Copy file at destination
	 * FileUtils.copyFile(SrcFile, DestFile); }
	 */	
}


