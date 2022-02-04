package Academy;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class homePage extends base {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test (dataProvider ="getData")
	public void basePageNavigation(String Username, String Password) throws IOException {
		driver.get(prop.getProperty("url"));
		landingPage lgb = new landingPage(driver);
		lgb.getLogin().click();
		loginPage logPO = new loginPage(driver);
		logPO.getEmail().sendKeys(Username);
		logPO.getPassword().sendKeys(Password);
		logPO.getLoginButton().click();
		log.info("Successfully landed filled the username and password");

	}
	
	@Test 
	
	public void getMobileNumber() {
		System.out.println("check my number");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		// Object[row][column]
		
		Object[][] data = new Object[2][2];
		// 1st row 
		data[0][0] = "nonrestrikteduser@yopmail.com";
		data[0][1] = "12345678";
		
		// 2nd row 
		data[1][0] = "restrikteduser@yopmail.com";
		data[1][1] = "12345678";
		
		return data;
	}
}
	