package ApiAssignment.ApiAssignment;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "DogMessageFeature", glue = "Dogs",
plugin = {"json:ApiAssignment/cucumber-reports/HTML$JSON/advanced.json","html:ApiAssignment/cucumber-reports/HTML$JSON/advanced.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/TestRunner/ExtentReport.html"}
)

public class TestRunner {
	
	
      
	}

	 

