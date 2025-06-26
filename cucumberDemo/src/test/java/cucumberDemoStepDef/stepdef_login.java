package cucumberDemoStepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import org.junit.Assert;

public class stepdef_login {
/*	
	WebDriver dr;
	@Given("the user on the nopCommerce login page")
	public void logginginPage() {
		dr = new ChromeDriver();
		dr.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().window().maximize();
		
	   
	}

	@When("the user enters the valid credintials\\(username: {string}, password:{string})")
	public void enter_username_password(String username, String pwd) {
		dr.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		dr.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
	    
	}

	@When("user click on login button")
	public void login_button() {
		dr.findElement(By.xpath("//button[@type='submit']")).click();
	   
	}

	@Then("the user should be redirected to the My Account page")
	public void my_account_page() {
		boolean status = dr.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
		
		Assert.assertEquals(status, true);
		
	}

	@Then("the user should see a welcome message")
	public void welcome_message() throws InterruptedException {
		String admin = dr.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		Assert.assertEquals(admin, "Dashboard");
		Thread.sleep(12000);
		dr.quit();
	   
	}
*/

}
