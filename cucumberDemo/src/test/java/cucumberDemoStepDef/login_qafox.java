package cucumberDemoStepDef;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.HomePage;
import pageObjects.MyAccocuntPage;
import pageObjects.loginPage;
import utilities.DataReaderfile;

public class login_qafox {
	
	WebDriver dr;
	HomePage hp;
	loginPage lp;  
	MyAccocuntPage macc;
	
	List<HashMap<String, String>> dataMap;
	
	
	@Given("the user navigate to home page")
	public void the_user_navigate_to_home_page() {
		BaseClass.getLogger().info("Go to Home page and click on the login button");
		
		hp = new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		
		
	   
	}

	@Given("click on login button")
	public void click_on_login_button() {
		BaseClass.getLogger().info("User is clicking on the Login button");
		hp = new HomePage(BaseClass.getDriver());
		hp.clickLogin();
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) throws IOException {
		
		
		lp = new loginPage(BaseClass.getDriver());
		lp.enterUsername(username); 
		lp.enterPassword(password);
		BaseClass.getLogger().info("User has entered the user name and password");
		
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		
		lp.clickOnLogin();
		BaseClass.getLogger().info("User is has clicked on the Login button");
	   
	}

	@Then("user navigated to MyAccount Page")
	public void user_navigated_to_my_account_page() {
		
		macc = new MyAccocuntPage(BaseClass.getDriver());
		boolean targetPage = macc.isMyAccountPageExists();
		
	    Assert.assertEquals(targetPage, true);
	    
	    BaseClass.getLogger().info("Script has validated the My Account Login Test ");
	}
	
	
	@Then("the user enters the username and password by using the excelrow {string}")
	public void enter_username_pswd_withExcel(String rows) {
		
		try {
			dataMap = DataReaderfile.data(System.getProperty("user.dir")+"\\testData\\opencart_loginData.xlsx", "Sheet1");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		int index = Integer.parseInt(rows)-1;
		String email = dataMap.get(index).get("username");
		String password = dataMap.get(index).get("password");
		String exp_res = dataMap.get(index).get("res");
		
		lp = new loginPage(BaseClass.getDriver());
		lp.enterUsername(email);
		lp.enterPassword(password);
		lp.clickOnLogin();
		
		macc = new MyAccocuntPage(BaseClass.getDriver());
		
		try {
			boolean targetPage = macc.isMyAccountPageExists();
			System.out.println("target page: "+ targetPage);
			
			
			if(exp_res.equalsIgnoreCase("Valid")) 
			{
				
				if(targetPage==true) 
				{
					MyAccocuntPage myAcPag = new MyAccocuntPage(BaseClass.getDriver());
					myAcPag.click_logout();
					Assert.assertTrue(true);
				}
				else 
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp_res.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true) {
					macc.click_logout();
					Assert.assertTrue(false);
					
				}else
				{
					Assert.assertTrue(true);
				}
			}
			
		}catch(Exception e){
			
		}
		
		
		
		
		
	}

}
