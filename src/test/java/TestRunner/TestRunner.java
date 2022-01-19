package TestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import Config.CucumberReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(features = { "Feature" }, 
	glue = {"StepDefinition"}, 
	plugin = {"json:target/cucumber.json"},
	monochrome = true, 
	dryRun = false)


	public class TestRunner {
		
		@BeforeClass
		 public static void beforeClass()
		 {
			CucumberReport.initializeExtentReport();
		 }

		@AfterClass
		 public static void afterClass()
		 {
			CucumberReport.ReportCooldown();
		 }
	}

