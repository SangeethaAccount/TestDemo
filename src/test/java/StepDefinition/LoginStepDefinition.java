package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import ExcelRead.ExcelRead;
import PageObject.Validation;
import TestBase.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends BaseClass{
	
	@Given("user is on login screen")
	public void user_is_on_login_screen() throws Throwable {
		ReportCreateFeatureTest("Login Test");	
		ReportCreateScenarioTest("user is on login screen");	
		try {
			Thread.sleep(3000);
			BaseClass.setUp();
			Thread.sleep(1000);
			WebElement LoginPage = getElement("LoginTitle",LoginXpath);
			explicitwaitclickable(driver, LoginPage);
			Thread.sleep(1000);
			try {
				if (LoginPage.isDisplayed()) {
					String validationText = LoginPage.getText().trim();
					Assert.assertEquals(validationText, Validation.expectedLoginTitle);
					System.out
							.println("Actual Value:" + validationText + " Expected value:" + Validation.expectedLoginTitle);
					Thread.sleep(2000);
					String s1=captureScreenshot();
					Givenlogpass("user is on login screen","Actual Value:" + validationText + " Expected value:" + Validation.expectedLoginTitle,s1);
				
				} else {
					System.out.println("Element not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			Thread.sleep(2000);
			String s=	captureScreenshot();
			Givenlogfail("user is on login screen","Not redirected to Login screen",s);
			Assert.fail("Failure");
		}
		System.out.println("Landing to Login screen");
	}

	@When("user enter the valid email or mobile and Password")
	public void user_enter_the_valid_email_or_mobile_and_password() throws Throwable {
		ReportCreateScenarioTest("Enter the valid login credentials");
		try {
		waitForElement("EmailMob", LoginXpath);
		sendKeystoElement("EmailMob", LoginXpath, ExcelRead.readData(1, 0, "login"));
		waitForElement("Password", LoginXpath);
		sendKeystoElement("Password", LoginXpath, ExcelRead.readData(1, 2, "login"));
		waitForElement("Eyeicon",LoginXpath);
		getElement("Eyeicon",LoginXpath).click();
		Thread.sleep(2000);
		String s1=captureScreenshot();
		Whenlogpass("Enter the valid login credentials","Succesfully enter the user credentials",s1);
	
		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			Thread.sleep(2000);
			String s1=captureScreenshot();
			Whenlogfail("user is on login screen","Not able to enter the login credentials",s1);
			Assert.fail("Failure");
		}  
		System.out.println("Entered the Login credentials");
	}

	@Then("user click on login button")
	public void user_click_on_login_button() throws Throwable {
		ReportCreateScenarioTest("user click on login button");
		try {
			waitForElement("LoginBtn",LoginXpath);
			getElement("LoginBtn",LoginXpath).click();
			System.out.println("Successfully logged into app");
			Thread.sleep(2000);
			String s1=captureScreenshot();
			Whenlogpass("user click on login button","Succesfully logged into application",s1);
		
		Thread.sleep(2000);
		String s2=captureScreenshot();
		Thenlogpass("user click on login button","Successfully logged into application",s2);
		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			Thread.sleep(2000);
			String s1=captureScreenshot();
			Thenlogfail("user click on login button","Not able to logged into app",s1);
			Assert.fail("Failure");
		}
		System.out.println("Successfully Logged into app");
	}

}
