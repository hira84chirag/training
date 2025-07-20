package newtest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ChiragSimple extends ChiragBase {
	
	 @Test
	 @Parameters({"browser_simple","url_simple"})
	 public void signinAction() {		 
		 System.out.println("Browser Title name="+driver.getTitle());
		 driver.navigate().back();
		 driver.navigate().forward();

	 	}


}
