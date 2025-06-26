package cucumberDemoStepDef;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class registration_qafox { 
	
	WebDriver dr;
	HomePage hp;
	RegisterPage rp;
	
	
	@Given("navigate to Home page")
	public void navigate_to_home_page() {
		hp = new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
	   
	}

	@Given("click on the Register button")
	public void click_on_the_register_button() {
		
		hp.clickRegister();
	}

	@When("the user enters the below registartion fields")
	public void the_user_enters_the_below_registartion_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		rp = new RegisterPage(BaseClass.getDriver());
		rp.txt_enter_first_name(dataMap.get("firstName"));
		rp.txt_enter_last_name(dataMap.get("lastName"));
		rp.txt_enter_eMail(dataMap.get("eMail"));
		//rp.txt_enter_eMail(BaseClass.randomeAlphaNumaric()+"@gmail.com");
		rp.txt_enter_telephone_num(dataMap.get("telephone"));
		rp.txt_enter_password(dataMap.get("password"));
		rp.txt_enter_cnf_password(dataMap.get("cnf_pswd"));
		
 	}

	@When("user select subscribe button")
	public void user_select_subscribe_button() {
		rp.radio_news_letter();
	   
	}

	@When("user accepted the policy button")
	public void user_accepted_the_policy_button() {
	  rp.check_policy();
	}

}
