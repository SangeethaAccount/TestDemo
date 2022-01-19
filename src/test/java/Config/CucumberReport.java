package Config;


import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CucumberReport {

	protected static ExtentReports extent;
	protected static ExtentTest feature;
	protected static ExtentTest scenario;


	public static void initializeExtentReport()
	{
		File OutputFolder = new File("./test-output");
		if (!OutputFolder.exists()) {
			if (OutputFolder.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create Directory");
			}
		} else {
			System.out.println("Directory already exists");
		}

		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output/IEBReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Report");
		spark.config().setReportName("Extent Reports Demo");
		extent.attachReporter(spark);
	}	

	public static void ReportCooldown() {
		extent.flush();
	}

	public static void ReportCreateFeatureTest(String Title) throws ClassNotFoundException {
		feature = extent.createTest(new GherkinKeyword("Feature"), Title);
	}

	public static void ReportCreateScenarioTest(String Title) throws ClassNotFoundException {
		scenario = feature.createNode(new GherkinKeyword("Scenario"), Title);
	}

	public static void Givenlogpass(String givendetails, String passdetails, String imgpath)
			throws ClassNotFoundException, IOException {

		scenario.createNode(new GherkinKeyword("Given"), givendetails).pass(passdetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(imgpath).build());

	}

	public static void Whenlogpass(String whendetails, String passdetails, String imgpath)
			throws ClassNotFoundException, IOException {
		scenario.createNode(new GherkinKeyword("When"), whendetails).pass(passdetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(imgpath).build());

	}

	public static void Thenlogpass(String thendetails, String passdetails, String imgpath)
			throws ClassNotFoundException, IOException {
		scenario.createNode(new GherkinKeyword("Then"), thendetails).pass(passdetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(imgpath).build());


	}

	public static void Andlogpass(String anddetails, String passdetails, String imgpath)
			throws ClassNotFoundException, IOException {

		scenario.createNode(new GherkinKeyword("And"), anddetails).pass(passdetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(imgpath).build());

	}

	public static void Givenlogfail(String givendetails, String faildetails, String imgpath)
			throws ClassNotFoundException, IOException {

		scenario.createNode(new GherkinKeyword("Given"), givendetails).fail(faildetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(imgpath).build());
	}

	public static void Whenlogfail(String whendetails, String faildetails, String imgpath)
			throws ClassNotFoundException, IOException {
		scenario.createNode(new GherkinKeyword("When"), whendetails).fail(faildetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(imgpath).build());
	}

	public static void Thenlogfail(String thendetails, String faildetails, String imgpath)
			throws ClassNotFoundException, IOException {
		scenario.createNode(new GherkinKeyword("Then"), thendetails).fail(faildetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(imgpath).build());

	}

	public static void Andlogfail(String anddetails, String faildetails, String imgpath)
			throws ClassNotFoundException, IOException {

		scenario.createNode(new GherkinKeyword("And"), anddetails).fail(faildetails,
				MediaEntityBuilder.createScreenCaptureFromBase64String(imgpath).build());

	}

}

