package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

	public loginPage(WebDriver dr) {
		super(dr);
		 
	}

	// Log in Page elements of the https://tutorialsninja.com/demo/index.php?route=common/home
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_login;
	 
	
	
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		btn_login.click();
	}
}
