package ApiAssignment.ApiAssignment;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "SubbreedsFeature", glue = "SubBreeds",
plugin = {"json:ApiAssignment/cucumber-reports/HTML$JSON/advanced.json","html:ApiAssignment/cucumber-reports/HTML$JSON/advanced.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/Subbreeds/ExtentReport.html"})

public class SubbreedsTest {

}
