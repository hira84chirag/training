package newtest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
driver.navigate().forward();
public class ChiragCommon {
	static WebDriver driver; 
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
	
}
