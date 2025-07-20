package utili;

import java.nio.channels.spi.SelectorProvider;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

public class facebook extends Common {

	public void locatordemo() {
		driver.get("https://www.facebook.com/reg/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); 
		Select mon1=new Select(driver.findElement(By.id("month")));
		//is muliple dropdown
		boolean result=mon1.isMultiple();
		System.out.println("is multiple option="+result);
		mon1.selectByIndex(2);
		mon1.selectByValue("1");
		mon1.selectByVisibleText("Nov");
	//	mon1.selectByValue("Feb");
		
		
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		facebook obj = new facebook();	
		obj.SetupBrowser("chrome", "https://www.facebook.com/reg/");
		obj.locatordemo();
	}

}
