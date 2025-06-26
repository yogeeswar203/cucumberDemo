package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

		public RegisterPage(WebDriver dr) {
			super(dr);
		}
		
		
		// Registration Page elements of the https://tutorialsninja.com/demo/index.php?route=common/home
		
		@FindBy(xpath="//input[@name='firstname']")
		WebElement txt_firstName;
		
		@FindBy(xpath="//input[@name='lastname']")
		WebElement txt_lastName;
		
		@FindBy(xpath="//input[@name='email']")
		WebElement txt_email;
		
		@FindBy(xpath="//input[@name='telephone']")
		WebElement txt_Telephone;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement txt_pwd;
		
		@FindBy(xpath="//input[@name='confirm']")
		WebElement txt_cpwd;
		
		@FindBy(xpath="//input[@value='1'][@name='newsletter']")
		WebElement radio_click;
		
		@FindBy(xpath="//input[@value='1'][@name='agree']")
		WebElement chk_click;
		
		
		public void txt_enter_first_name(String fname) {
			
			txt_firstName.sendKeys(fname);
		}
		
		
		public void txt_enter_last_name(String lname) {
					
			txt_lastName.sendKeys(lname);
		}
		
		public void txt_enter_eMail(String eMail) {
			
			txt_email.sendKeys(eMail);
		}
		
		public void txt_enter_telephone_num(String telephone) {
			
			txt_Telephone.sendKeys(telephone);
		}
		
		public void txt_enter_password(String pswd) {
			
			txt_pwd.sendKeys(pswd);
		}
		
		public void txt_enter_cnf_password(String cnf_pwd) {
			
			txt_cpwd.sendKeys(cnf_pwd);
		}
		
		public void radio_news_letter() {
			
			radio_click.click();
		}
		
		public void check_policy() {
					
			chk_click.click();
		}
			
			
}
