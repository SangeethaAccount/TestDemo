package StepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import ExcelRead.ExcelRead;
import PageObject.Validation;
import TestBase.BaseClass;
import TestUtil.Utilies;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupStepDefinition extends BaseClass{


	@Given("user is on signup screen")
	public void user_is_on_signup_screen() throws Throwable{
		ReportCreateFeatureTest("SignUp Test");	
		ReportCreateScenarioTest("user is on signup screen");
		try {
			Thread.sleep(3000);
			BaseClass.setUp();
			Thread.sleep(2000);
			WebElement signuptext=getElement("SignupText",SignupXpath);
			explicitwaitclickable(driver, signuptext);
			signuptext.click();
			
			Thread.sleep(2000);
			String s=captureScreenshot();
			Givenlogpass("user is on signup screen","Successfully redirected to Signup screen",s);
		
			System.out.println("on signup screen");

			WebElement SignupPage = getElement("SignupTitle",SignupXpath);
			explicitwaitclickable(driver, SignupPage);
		
			try {
				if (SignupPage.isDisplayed()) {
					String validationText = SignupPage.getText().trim();
					Assert.assertEquals(validationText, Validation.expectedSignupTitle);
					System.out
							.println("Actual Value:" + validationText + " Expected value:" + Validation.expectedSignupTitle);
					Thread.sleep(2000);
					String s1=captureScreenshot();
					Givenlogpass("user is on signup screen","Actual Value:" + validationText + " Expected value:" + Validation.expectedSignupTitle,s1);
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
			Givenlogfail("user is on Signup screen","Not redirected to signup screen",s);
			Assert.fail("Failure");
		}
		System.out.println("Landing to signup screen");
	}

	@When("user enter the valid firstname lastname DOB email mobilenumber password and click on check box")
	public void user_enter_the_valid_firstname_lastname_dob_email_mobilenumber_password_and_click_on_check_box() throws Throwable {

		ReportCreateScenarioTest("Enter the user details");
		try {
			waitForElement("Firstname", SignupXpath);
			//Firstname
			sendKeystoElement("Firstname", SignupXpath, ExcelRead.readData(1, 0, "signup"));
			//Lastname
			waitForElement("Lastname", SignupXpath);
			sendKeystoElement("Lastname", SignupXpath, ExcelRead.readData(1, 1, "signup"));
		
			//DOB
			waitForElement("DOB", SignupXpath);
			getElement("DOB",SignupXpath).click();		
			waitForElement("Currentyear", SignupXpath);
			getElement("Currentyear",SignupXpath).click();
			Thread.sleep(2000);
			scrollby(driver, "434", "723", ExcelRead.readData(1, 5, "signup"), ExcelRead.readData(1, 6, "signup"),
					ExcelRead.readData(1, 7, "signup"));
			waitForElement("Email", SignupXpath);
			//Email
			sendKeystoElement("Email", SignupXpath, ExcelRead.readData(1, 2, "signup"));
			waitForElement("Mobile", SignupXpath);
			//Mobile
			sendKeystoElement("Mobile", SignupXpath, ExcelRead.readData(1, 3, "signup"));
			waitForElement("Password", SignupXpath);
			//Password
			sendKeystoElement("Password", SignupXpath, ExcelRead.readData(1, 4, "signup"));
			waitForElement("Eyeicon", SignupXpath);
			//Password view
			getElement("Eyeicon",SignupXpath).click();
			Thread.sleep(2000);
			String s=captureScreenshot();
			Whenlogpass("Enter the user details","Entered the User details",s);

		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			Thread.sleep(2000);
			String s=captureScreenshot();
			Whenlogfail("Enter the user details","Not able to enter the user details",s);
			Assert.fail("Failure");
		}
		System.out.println("Entered the Registration Details");
	}

	@Then("user click on signup button")
	public void user_click_on_signup_button() throws Throwable {

		ReportCreateScenarioTest("user click on signup button");
		try {
			waitForElement("FirstCheck",SignupXpath);
			scrolldown(driver);
			getElement("FirstCheck",SignupXpath).click();
			waitForElement("SecondCheck",SignupXpath);
			getElement("SecondCheck",SignupXpath).click();
			waitForElement("ThirdCheck",SignupXpath);
			getElement("ThirdCheck",SignupXpath).click();
			waitForElement("SignupBtn",SignupXpath);
			getElement("SignupBtn",SignupXpath).click();
			Thread.sleep(2000);
			String s=captureScreenshot();
			Thenlogpass("user click on signup button","User successfully registered into account",s);

		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			Thread.sleep(2000);
			String s=captureScreenshot();
			Thenlogfail("user click on signup button","Not registered successfully",s);
			Assert.fail("Failure");
			
		}
		System.out.println("Successfully Registered into app");
		closeDriver();
	}


}
