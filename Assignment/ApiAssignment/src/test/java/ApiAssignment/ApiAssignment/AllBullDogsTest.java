package ApiAssignment.ApiAssignment;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "DogFeatures", glue = "AllBullDogs",
plugin = {"json:ApiAssignment/cucumber-reports/HTML$JSON/advancedAlBullDogs.json","html:ApiAssignment/cucumber-reports/HTML$JSON/advancedAlBullDogs.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/AllBulls/ExtentReport.html"})
public class AllBullDogsTest {

}
