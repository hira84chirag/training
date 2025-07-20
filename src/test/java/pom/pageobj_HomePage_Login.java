package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class pageobj_HomePage_Login {
	@CacheLookup
	@FindBy(xpath  ="//a[@class='signin']")
	WebElement Signin;
	
	@CacheLookup
	@FindBy(id="login1")
	WebElement email;
	
	@CacheLookup
	@FindBy(id="password")
	WebElement pwd;

	@CacheLookup
	@FindBy(name="proceed")
	WebElement logbtn;

	@CacheLookup
	@FindBy(className ="forgotlink")
	WebElement forgotlink;
	
	public By passTxt = By.id("pass");
	private WebDriver driver;
	
	public pageobj_HomePage_Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void clicksignbtn()  {
		
		Signin.click();
	}
	public void enterUsername(String username) {
		Reporter.log("Username =" + username);
		email.sendKeys(username);		
	}
	public String getusername() {	
		return email.getAttribute("value");
	}
	
	public String getproceed() {	
		return logbtn.getAttribute("value");
	}
	public String getforget() {	
		Reporter.log(forgotlink.getText());
		return forgotlink.getAttribute("innerHTML");
	}
	public void enterPassword(String password) {
		// Reporter.log("Password =" + password);		passwd.clear();
		pwd.sendKeys(password);		
	}
	
	public void forgetPassword() {
		forgotlink.click();		
	}
	
	public void loginWithCredetials(String username,String password) {
		email.clear();
		pwd.clear();
		enterUsername(username);
		enterPassword(password);		
	}

	
	
}


