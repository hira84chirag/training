package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rediff_CreateAccount {

	
	@CacheLookup
	@FindBy(xpath = "//div/textarea['gLFyf']")
	WebElement searchtxt;
	
	String path="";
	
	public static WebDriver driver;
	
	public Rediff_CreateAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);		
	}
	
	public void CreateAccountEle() {
		
	}
	
}
