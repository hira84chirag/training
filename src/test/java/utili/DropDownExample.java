package utili;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownExample extends Common{
	
	@SuppressWarnings("unlikely-arg-type")
	public void dropDownDemo() {
	//	Select month = new Select(driver.findElement(By.xpath("//select[@id='country']")));		
		Select month = new Select(driver.findElement(By.xpath("//select[contains(@name, 'city')]")));			
		month.selectByValue("Baroda");
		
		//get all options
		List<WebElement> allOptions1 = month.getOptions();
		for (WebElement elem : allOptions1) {
			System.out.println(elem.getText());
		}
				
	}

	public static void main(String[] args) {
		DropDownExample obj = new DropDownExample();
		obj.SetupBrowser("chrome", "https://register.rediff.com/register/register.php?FormName=user_details");
		obj.dropDownDemo();
	}

}
