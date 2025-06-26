package hooks;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks {
	
	WebDriver dr;
	Properties pr;
	
	
	@Before
	public void setUp() throws IOException {
		dr = BaseClass.initilizeBrowser();
		pr = BaseClass.getProperties();
		dr.get(pr.getProperty("appUrl"));
		dr.manage().window().maximize();
		
		
	}
	
	
	@After
	public void tearDown(Scenario scenario) throws InterruptedException {
		Thread.sleep(2000);
		dr.quit();
	}

	
	@AfterStep
	public void addScreenShot(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			TakesScreenshot ts = (TakesScreenshot)dr;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/jpeg", scenario.getName());
		}
	}
}
