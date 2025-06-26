package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features = {".//features/"}
		
		
		features = {".//features/tutorialsninja_login.feature"},
		//features = {".//features/accRegistration.feature"},
		//features = {".//features/loginDDTExcel.feature"},
		//features = {"@target/rerun.txt"}, 
		//features = {".//features/tutorialsninja_login.feature",".//features/accRegistration.feature"},
		//features = {".//features/loginDDTExcel.feature"},
		
		glue = {"cucumberDemoStepDef","hooks"},
		  
		plugin = {
				"pretty",
				"html:reports/myreport.html",
				// "rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		
		dryRun =  false,  // checks mappings between scenario steps and step definition methods 
		monochrome = true, // to avoid junk characters in output
		publish = true,    // to publish report in cucumber server 
		
		//tags = "@smoke"
		tags = "@sanity"  // to execute only sanity test cases 
		// tags ="@sanity and @regression 
		// tags = @sanity or @regression  
	
		) 

public class Testrunner_class {

}
