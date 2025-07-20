package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Base {
	@CacheLookup
	@FindBy(name = "email")
	WebElement name;
	
	@CacheLookup
	@FindBy(name = "pass")
	WebElement password;
	
	@CacheLookup
	@FindBy(name = "login")
	WebElement login;
	
	public static WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		
	}
	public void entername() {
		name.sendKeys("softwaretesting");
		password.sendKeys("dsagaafdsfsd");
		
	}
	public void enterpass() {
		name.sendKeys("2chiragtest");		
	}
	public void clicklogin() {
		login.click();
		
	}
	

}
