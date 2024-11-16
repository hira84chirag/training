package utili;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWithLog4j extends Common {

    // Initialize Log4j logger
    private static final Logger logger = LogManager.getLogger(TestWithLog4j.class);

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
    	Common cm=new Common();

        // Initialize WebDriver
    		
        try {
            // Open a website

        	cm.SetupBrowser("chrome", "https://www.facebook.com");
            logger.info("Navigated to https://example.com");

            // Locate the username field
            WebElement usernameField = driver.findElement(By.id("email"));
            logger.info("Username field located.");

            // Interact with the username field
            usernameField.sendKeys("testuser");
            logger.info("Entered username 'testuser'.");

            // Additional interactions can be added here

        } catch (Exception e) {
            logger.error("An error occurred: ", e);
        } finally {
            // Close the browser
            driver.quit();
            logger.info("Browser closed.");
        }
    }
}
