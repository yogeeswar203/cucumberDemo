package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccocuntPage extends BasePage{

	public MyAccocuntPage(WebDriver dr) {
		super(dr);
		
	}

	// Log in Page elements of the https://tutorialsninja.com/demo/index.php?route=common/home
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement logo_heading;
	
	@FindBy(xpath="//aside//a[text()='Logout']")
	WebElement btn_logout;
	
	
	public boolean isMyAccountPageExists() {
		boolean status = logo_heading.isDisplayed();
		
		return status;
		
	}
	
	public void click_logout() {
		btn_logout.click();
		
	}
	
}
