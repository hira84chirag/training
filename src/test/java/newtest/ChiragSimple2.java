package newtest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ChiragSimple2 extends ChiragBase {
	
	 @Test
	 @Parameters({"browser_simple","url_simple"})
	 public void signinAction() {		 
		 System.out.println(driver.getTitle());
		 driver.navigate().back();
		 System.out.println("chiragss3");

	 	}


}
