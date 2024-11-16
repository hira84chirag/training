package pom;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utili.Common;

public class Pageobj_HomePage {
	
	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'CRICKET')]")
	WebElement crickettab;
	
	@CacheLookup
	@FindBy(xpath="//ul[@class='navbarul']//a[text()='HOME']")
	WebElement hometab;
	
	//$x("//ul[@class='navbarul']//a[text()='HOME']")
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'SPORTS')]")
	WebElement sporttab;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'Enterprise Email')]")
	WebElement Enterprisebtn;
	
	String Enterprisestr="//a[contains(text(),'Enterprise Email')]";
	private WebDriver driver;
	
	public Pageobj_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
		// Open Cricket tab button
	public void clickcricketbtn() {
		  // Define a wait time
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        String cric="//a[normalize-space()='CRICKET']";
        // Try to find the element that should be displayed
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cric)));

        boolean bolcric = crickettab.isEnabled();
        if(bolcric) { 
            pageLoadStop();
        	crickettab.click();
        	Reporter.log("Cricket tab is visible");
        }
		
	}		
	public void clickHometab() {		
		  // Define a wait time
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        String home="//ul[@class='navbarul']//a[text()='HOME']";
        // Try to find the element that should be displayed
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(home)));
		
		boolean bolhome = hometab.isDisplayed();
        if(bolhome) { 
            pageLoadStop();
            hometab.click();
        	Reporter.log("Home tab is visible");
         }        		
	}
	public void clicksporttab() {				
		  // Define a wait time
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        String sport="//a[text()='SPORTS']";
        // Try to find the element that should be displayed
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sport)));
        //WebElement element1 = wait.until(ExpectedConditions.el
		boolean bolsport = sporttab.isDisplayed();
        if(bolsport) { 
        	pageLoadStop();
            sporttab.click();	
        	Reporter.log("Sport tab is visible");

        }		
        
	}
	
	// Stop the page from loading
	public void pageLoadStop() {
		
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.stop();");
        Reporter.log("page load stopped");
	}
	// end pageload method
	public void pageLoad() {
		
		Instant startTime = Instant.now();
        System.out.println("Page load started at : " + startTime.toString());
        
        System.out.println("Navigating to the URL");
        driver.getCurrentUrl();
       
        Instant endTime = Instant.now();
        System.out.println("Page load ended at : " + endTime.toString());


        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Total PageLoad time : " + duration.toMillis() + " milli seconds");
        
		 // Wait for the DOM to be fully loaded
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 * wait.until(new ExpectedCondition<Boolean>() { public Boolean apply(WebDriver
			 * driver) { JavascriptExecutor js = (JavascriptExecutor) driver; return
			 * (Boolean) js.executeScript(
			 * "return document.readyState === 'complete' || document.readyState === 'interactive';"
			 * ); } });
			 */
	}
	
	public void CreateImage(String filePath) {
        try {
	        // Navigate to the desired web page
	        Reporter.log(driver.getCurrentUrl());
	
	        // Take a screenshot and store it as a file
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        long currentTimeMillis = System.currentTimeMillis();        	        
	        // Define the destination file path
	        // filePath = "D:/screenshot.png";
	        String filestr= "D:\\";
	        LocalTime filestr1 = LocalTime.now();
	        filePath=filestr + filePath + currentTimeMillis+ ".jpg";
	        // Copy the screenshot to the destination file
	        FileUtils.copyFile(screenshot, new File(filePath));
        	System.out.println("Screenshot saved at: " + filePath );
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        } finally {
            // Close the browser

        }
    }
	
}