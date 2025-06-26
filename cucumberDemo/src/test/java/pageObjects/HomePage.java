package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver dr) {
		super(dr);
		
	}
	
	// Home page elements of the https://tutorialsninja.com/demo/index.php?route=common/home
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnk_myAccDrp;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement lnk_login;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnk_register;
	
	
	public void clickMyAccount() {
		lnk_myAccDrp.click();
	}

	
	public void clickLogin() {
		lnk_login.click();
	}
	
	public void clickRegister() {
		lnk_register.click();
	}

}
