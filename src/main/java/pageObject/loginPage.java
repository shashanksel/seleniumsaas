package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;
	
	By email = By.cssSelector("[id='user_email']");
	By pwd = By.cssSelector("[id='user_password']");
	By submitB = By.cssSelector("[value='Log In']");
	
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(pwd);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(submitB);
	}
	
	
}
