package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class validateTitle extends base {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());

	
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialised");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	
	
	@Test
	public void pageTitleValidation() throws IOException {
		landingPage lgb = new landingPage(driver);
		Assert.assertEquals(lgb.getTitle().getText(), "FEATURED COURSES 123");
		log.info("Successfully Validated Page Title");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

	
}
	