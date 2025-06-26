package factory;



import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class BaseClass {
	
	static WebDriver dr;
	static Properties pr;
	static Logger logger;
	
	@SuppressWarnings("deprecation")
	public static WebDriver initilizeBrowser() throws IOException {
		
		pr = getProperties();
		
		String execution_env =pr.getProperty("execution_env");
		String browser =pr.getProperty("browser").toLowerCase();
		String os =pr.getProperty("os");
		
		if(execution_env.equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capbilities = new DesiredCapabilities();
			// OS 
	 		switch(os) {
				case "windows":
					capbilities.setPlatform(Platform.WINDOWS);
					break;
					
				case "mac":
					capbilities.setPlatform(Platform.MAC);
					break;
					
				case "linux":
					capbilities.setPlatform(Platform.LINUX);
					break;
				default:
					System.out.println("No matching OS FOUND");
					return null;
	
			}
			
			// Selecting the browser on remote execution
			switch(browser) {
			
				case "chrome":
					capbilities.setBrowserName("Chrome");
					break;
				case "edge":
					capbilities.setBrowserName("Edge");
					break;
				
				default:
					System.out.println("No Matching browser found");
					return null;
				
				
			}
			
			dr = new RemoteWebDriver(new URL("http://localhost::4444/wd/hub"), capbilities);
			
		}else if(execution_env.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase()) 
			{
				case "chrome":
					dr = new ChromeDriver();
					break;
					
				case "edge":
					dr = new EdgeDriver();
					break;
					
				default:
					System.out.println("No Matching browser found in Local");
			}
		}
		
		dr.manage().deleteAllCookies();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		return dr;
		
	}

	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		pr = new Properties();
		pr.load(file);
		return pr;
	}
	
	// For the Logger purpose
	public static Logger getLogger() {
		
		logger = LogManager.getLogger();
		return logger;
		
	}
	
	// Returning the driver
	public static WebDriver getDriver() {
		
		return dr;
		
	}
	 
	public static String randomString() {
		@SuppressWarnings("deprecation")
		String generatedSting = RandomStringUtils.randomAlphabetic(5);
		return generatedSting;
		
	}
	
	public static String randomNumber() {
		@SuppressWarnings("deprecation")
		String generatedSting = RandomStringUtils.randomNumeric(10);
		return generatedSting;
		
	}
	
	public static String randomeAlphaNumaric() {
		@SuppressWarnings("deprecation")
		String str = RandomStringUtils.randomAlphabetic(5);
		@SuppressWarnings("deprecation")
		String num = RandomStringUtils.randomNumeric(5);
		return str+num;
		
	}
	
	
	

}
