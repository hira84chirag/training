package pom;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter; 

public class pageobj_HomePage_registerPage {

	@CacheLookup
	@FindBy(partialLinkText = "Create Account")
	WebElement createAccnBtn;

	@CacheLookup
	@FindBy(xpath = "//td[@width='200']//input[@type='text']") ////tbody[1]//tr[3]//td[3]//input
	WebElement fullname;
	
	@CacheLookup
	@FindBy(xpath = "//td[@valign='bottom']//input[@type='text']")
	WebElement selectRediffID;
	
//	"//table[2]//tbody[1]//tr[7]//td[3]//input[1]"
	
	@CacheLookup
	@FindBy(xpath = "//input[@id='newpasswd']")
	WebElement pwd;

	@CacheLookup
	@FindBy(xpath = "//input[@id='newpasswd1']")
	WebElement repwd;


	
	@CacheLookup
	@FindBy(xpath = "//div[@id='div_altemail']//td//input")
	WebElement alternetemail;

	@CacheLookup
	@FindBy(xpath = "//input[(@type='checkbox' and @class='nomargin')]") 	//tbody//tbody[1]//td[1]//input
	WebElement chkboxalternetid;
	
	
	@CacheLookup
	@FindBy(xpath = "//input[@id='mobno']") //tbody//tbody[1]//td[3]
	WebElement mobilenumber;

	String daypath = "//table[2]//tbody[1]//tr[22]//td[3]//select[1]";
	String monpath = "//table[2]//tbody[1]//tr[22]//td[3]//select[2]";
	String yrpath = "//table[2]//tbody[1]//tr[22]//td[3]//select[3]";

	Select daysel, yrsel;
	String countryPath = "//select[@id='country']";
	String cityPath = "//td[@colspan='3']//select[contains(@name,'city')]";  //tbody[1]//tr[1]//td[3]//select[1]
	String secquestion = "//td[@colspan='3']//select[contains(@name,'hintq')]"; //tbody//tr[2]//td[3]//select

	@CacheLookup
	@FindBy(xpath = "//input[contains(@name,'hinta')]")
	WebElement enterAns;
	
	@CacheLookup
	@FindBy(xpath = "//input[contains(@name,'mothername')]")
	WebElement monthername;

	
	@CacheLookup
	@FindBy(xpath = "//input[@value='f']")
	WebElement chkfemale;

	Object wait;
	private WebDriver driver;

	public pageobj_HomePage_registerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void getfullname() {
		Reporter.log(fullname.getAttribute("name"));
	}

	public void clickCreatbtn() {
		createAccnBtn.click();
	}

	public void crateAccount() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		fullname.sendKeys("chiragpatel");
		selectRediffID.sendKeys("chirapatelrediff");
		pwd.sendKeys("patelchirag");
		repwd.sendKeys("patelchirag");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		alternetemail.sendKeys("alternetemail@es.com");
		mobilenumber.sendKeys("973-237-6785");
		daysel = new Select(driver.findElement(By.xpath(daypath)));
		daysel.selectByValue("24");
		Select monsel = new Select(driver.findElement(By.xpath(monpath)));
		monsel.selectByValue("11");
		Select yrsel = new Select(driver.findElement(By.xpath(yrpath)));
		yrsel.selectByValue("1989");

		Select country = new Select(driver.findElement(By.xpath(countryPath)));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement countryElem = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(cityPath))));

		Select city = new Select(driver.findElement(By.xpath(cityPath)));
		city.selectByValue("Bangalore");
		chkboxalternetid.click();	
		Select city1 = new Select(driver.findElement(By.xpath(secquestion)));
		city1.selectByIndex(1);
		chkfemale.click();
		WebElement daysel1= ((Select) daysel).getFirstSelectedOption();		
		WebElement monsel1= ((Select) monsel).getFirstSelectedOption();
		WebElement yrsel1= ((Select) yrsel).getFirstSelectedOption();		
		Reporter.log("Date of birth :" + daysel1.getAttribute("value") + "-" +monsel1.getAttribute("value") + "-"+ yrsel1.getAttribute("value"));
		enterAns.sendKeys("Vibhag High School");
		monthername.sendKeys("Vinoba");
	}

	public void inspectEle() {
		Reporter.log("FullName: " + fullname.getAttribute("name"));		
		Reporter.log("selectRediffID: " + selectRediffID.getAttribute("name"));		
		Reporter.log("Password: " + pwd.getAttribute("name"));
		Reporter.log("Alternet address name: " + alternetemail.getAttribute("name"));
		Reporter.log("mobile name: " + mobilenumber.getAttribute("name"));

	}
	public void screen(File filepath) {
        try {
            // Navigate to the desired web page
            driver.getCurrentUrl();
            // Take a screenshot and store it as a file
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Define the destination file path
         //   filePath = "D:/screenshot.png";
            FileHandler.copy(srcFile, filepath);
            // Copy the screenshot to the destination file
           // FileUtils.copy(srcFile, filePath);

            //FileUtils.copyFile(screenshot, new File(filePath));

    //        System.out.println("Screenshot saved at: " + string);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser

        }
    }

}
