package test;

import org.testng.annotations.Test;
import pom.Pageobj_HomePage;
import java.time.Duration;
import org.testng.annotations.Parameters;

public class Homepage extends BaseRediff {
	Pageobj_HomePage obj;

	@Test
	@Parameters({ "urlRediff" })
	public void HomeRediff(String url) {
		obj=new Pageobj_HomePage(driver); 
		driver.manage().window().maximize();
		//obj.pageLoad();
		obj.clickcricketbtn();			
		obj.clickHometab();	
		obj.clicksporttab();
		driver.navigate().back();
		obj.CreateImage("results");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

	}
	
}
