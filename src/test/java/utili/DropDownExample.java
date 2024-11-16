package utili;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownExample extends Common{
	
	@SuppressWarnings("unlikely-arg-type")
	public void dropDownDemo() {
	//	Select month = new Select(driver.findElement(By.xpath("//select[@id='country']")));		
		Select month = new Select(driver.findElement(By.xpath("//tbody[1]//tr[1]//td[3]//select[1]")));			
		month.selectByValue("Baroda");

		
		//is multiple
//		boolean result = month.isMultiple();
//		System.out.println("is the month dropdown, multiple drop down - " + result);
		
		//select by index
//		month.selectByIndex(3);
		
		//select by value
//		month.selectByValue("6");
		
		//select by visible text
//		month.selectByVisibleText("Nov");
		
		//first selected value
//		System.out.println(month.getFirstSelectedOption().getText());
		
		//all the selected values
//		List<WebElement> allSelectedOptions = month.getAllSelectedOptions();
//		for (WebElement elem : allSelectedOptions) {
//			System.out.println(elem.getText());
//		}
		
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
