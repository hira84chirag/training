package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utils.MethodTest;

public class Pom_Homepage_Link {
	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'')]")
	WebElement links;
	
	@CacheLookup
	@FindBy(xpath = "//div/textarea['gLFyf']")
	WebElement searchtxt;
	
	String path="";
	
	public static WebDriver driver;
	
	public Pom_Homepage_Link(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);		
	}
	
	public void googlelinks() {
		String url="https://www.google.com/";
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		driver.get(url);	
		searchtxt.sendKeys("SDLC Cycle and STLC");
		searchtxt.sendKeys(Keys.ENTER);
		path="//a[@jsname='UWckNb']";
		getlinks();
	}
	
	public void facebooklinks() {		
		path="//a[contains(text(),'')]" ;
		getlinks();		
	}
	public void getlinks() {
	//	links.findElements(By.linkText("Groups"));
		
		 { 	int i=0;  
		 		Reporter.log(driver.getCurrentUrl());
			// Create object from object Repository 
				List<WebElement> links =  driver.findElements(By.xpath(path));    
			
			for (WebElement element : links) {
				String linkText = element.getText();
				String href = element.getAttribute("href"); 
				
		     //   if (href != null && !href.isEmpty()) {
	              Reporter.log("Text: " + linkText + "  - :Link=" + href );
	              i++;
		      //  }    		 
			}
				  Reporter.log("Total links=" + i);

		}


	}
	

}
