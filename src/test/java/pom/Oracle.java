package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import utili.Common;

public class Oracle {

	
	String packageListframe = "//ul[@title='Packages']//li//a"; 
	String packageframe = "//div[@class='indexContainer']//li//a"; 
	String classframe = "//table[@class='overviewSummary']//tbody[2]//tr";
	int cd=0;
	@CacheLookup
	@FindBy(xpath = "//div[@class='indexContainer']//li//a")
	WebElement Packageframe;
	
			

	private WebDriver driver;
	
	public Oracle(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void packageListframeclick() {
		countLink("packageListFrame",packageListframe);
		cd++;
	}
	public void packageframeclick() {
		countLink("packageFrame",packageframe);	
		cd++;
	}
	public void classframeclick() {
		countLink("classFrame",classframe);	
		// count Total number of frame
		cd++;
		Reporter.log("Count total number of frame ==  "+cd);	
	}


	public void countLink(String framename,String path) {
	    Reporter.log("----------" + framename+ "--------------------");
		int count=0;
		driver.switchTo().frame(framename);		
		Reporter.log("URL'" + driver.getCurrentUrl());
		List<WebElement> allLinks = driver.findElements(By.xpath(path));
		Iterator<WebElement> iterator = allLinks.iterator();

        // Iterate over each element and print its 'id' attribute
        while (iterator.hasNext()) {
            WebElement element = iterator.next();
            Reporter.log(element.getText() + " =  " + element.getAttribute("href"));
            count++;
        }
        Reporter.log("Total number of links: ===" +  count);
 
        driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	}

}


