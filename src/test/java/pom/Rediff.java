package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public class Rediff {

	@CacheLookup
	@FindBy(xpath = "//a[@title='Already a user? Sign in']")
	WebElement Signin;

	@CacheLookup
	@FindBy(xpath = "//input[@name='proceed']")
	WebElement proceed;

	@CacheLookup
	@FindBy(xpath = "//button[@id='tabButton']")
	WebElement tabbutn;

	@CacheLookup
	@FindBy(xpath = "//button[@id='windowButton']")
	WebElement winbtn;
	
	@CacheLookup
	@FindBy(xpath = "//h1[@id='sampleHeading']")
	WebElement wintext;


	@CacheLookup
	@FindBy(id = "messageWindowButton")
	WebElement messagewinbtn;

	private WebDriver driver;
	
	public Rediff(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void signInClick() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		Signin.click();
	}

	public void clickLoginbtn() {
		proceed.click();
	}

	public void clickTabbtn() {
			tabbutn.click();
	}

	public void clickWinbtn() {
		winbtn.click();					
	}

	public void clickmsgwinbtn() {
		messagewinbtn.click();
	}
	
	public void chidlwindow(WebDriver driver) {
		String parent1=driver.getWindowHandle();

		Set<String> s2 =driver.getWindowHandles();
		
		// Now iterate using Iterator
		Iterator <String> I2= s2.iterator();
		
		while(I2.hasNext())
		{

			String child_window1=I2.next();
			
			if(!parent1.equals(child_window1))
			{
			driver.switchTo().window(child_window1);	
			Reporter.log(driver.switchTo().window(child_window1).getTitle());
			
			WebElement element = driver.findElement(By.xpath("//body"));
			String htmlContent = element.getAttribute("innerHTML");
			Reporter.log(htmlContent);
			
			/*
			 * String a=driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
			 * Reporter.log(a);
			 */
			
	//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); 	
			driver.switchTo().window(child_window1).close();
			}
				
			
		}

	}

}
