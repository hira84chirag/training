package pom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Pageobj_HomePage_Simple {
	
	@CacheLookup
	@FindBy(xpath  ="//a[text()='Rediffmail']")
	//@FindBy(partialLinkText = "Rediffmail")
	WebElement rediffmailLink;

	@CacheLookup
	@FindBy(partialLinkText = "Money")
	WebElement moneyLink;

	@CacheLookup
	@FindBy(partialLinkText = "Enterprise")
	WebElement enterpriseLink;

	@CacheLookup
	@FindBy(partialLinkText = "Business")
	WebElement businessLink;

	@CacheLookup
	@FindBy(partialLinkText = "Create Account")
	WebElement createaccountLink;

	
	private WebDriver driver;

	public Pageobj_HomePage_Simple(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickmoneybtn() {
		moneyLink.click();
	}
	
	public void clickrediffHomepage() {

		String rediffname = rediffmailLink.getAttribute("title");
		Reporter.log("Class name="+rediffname);	
		rediffmailLink.click();
	}
	public void Linkclick() {

		if(rediffmailLink.isDisplayed())
				Reporter.log("Rediffmail Link is displayed");
		
	}	
	public void screen(WebDriver webdriver,String filePath) {
        try {
            // Navigate to the desired web page
            driver.get("https://www.rediffmail.com");

            // Take a screenshot and store it as a file
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define the destination file path
         //   filePath = "D:/screenshot.png";

            // Copy the screenshot to the destination file
            FileUtils.copyFile(screenshot, new File(filePath));

            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        } finally {
            // Close the browser

        }
    }

}
