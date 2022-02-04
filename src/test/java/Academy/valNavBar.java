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

public class valNavBar extends base {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());

	
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void basePageNavigation() throws IOException {
		landingPage lgb = new landingPage(driver);
		Assert.assertTrue(lgb.getNavigationBar().isDisplayed());
		log.info("Navigation Bar Validated");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

	
}
		