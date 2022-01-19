package StepDefinition;

import java.util.List;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import ExcelRead.ExcelRead;
import PageObject.Validation;
import TestBase.BaseClass;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PosterStepDefinition extends BaseClass {

	@Given("user see the list of post")
	public void user_see_the_list_of_post() throws Throwable {
		ReportCreateFeatureTest("Post Test");	
		ReportCreateScenarioTest("user see the list of post");
		try {
			Thread.sleep(3000);
			BaseClass.setUp();
			Thread.sleep(2000);
			System.out.println("Created");
			elementlist();
			waitForElement("OKbtn",PosterXpath);

			//OkayBtn
			if(getElement("OKbtn",PosterXpath).isDisplayed()) {
				WebElement OkBtn = getElement("OKbtn",PosterXpath);
				Thread.sleep(2000);
				try {
					if (OkBtn.isDisplayed()) {
						OkBtn.click();
					} else {
						System.out.println("Element is not present");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}}
			else {
				System.out.println("Element is not present");
			}
			System.out.println("completed");
			Thread.sleep(2000);
			String s=captureScreenshot();
			Givenlogpass("user see the list of post","Clicked on the post creation link",s);
	
		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			Thread.sleep(2000);
			String s=	captureScreenshot();
			Givenlogfail("user see the list of post","unable to click on the post creation link",s);
			Assert.fail("Failure");
		}
		System.out.println("Selected the post");
	}

	@When("user click on post for create a task")
	public void user_click_on_post_for_create_a_task() throws Throwable {
		ReportCreateScenarioTest("user click on post for create a task");
		try {
			waitForElement("Task", PosterXpath);
			sendKeystoElement("Task", PosterXpath, ExcelRead.readData(1, 1, "post"));
			waitForElement("Description", PosterXpath);
			sendKeystoElement("Description", PosterXpath, ExcelRead.readData(1, 2, "post"));
			waitForElement("TaskType",PosterXpath);
			//Location
			//getElement("Location",PosterXpath).click();
			//Thread.sleep(3000);
			//getElement("SaveBtn",PosterXpath).click();
			//Thread.sleep(3000);
			WebElement TaskType = getElement("TaskType",PosterXpath);
			Thread.sleep(1000);
			try {
				if (TaskType.isDisplayed()) {
					if(ExcelRead.readData(1, 0, "post").equalsIgnoreCase(ExcelRead.readData(1, 4, "post")));
					{
						TaskType.click();
					}
				} else {
					System.out.println("Task Type is Person not remote work");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			waitForElement("Addthings", PosterXpath);
			sendKeystoElement("Addthings", PosterXpath, ExcelRead.readData(1, 3, "post"));
			waitForElement("ContinueBtn",PosterXpath);
			getElement("ContinueBtn",PosterXpath).click();
			
			Thread.sleep(2000);
			String s=captureScreenshot();
			Whenlogpass("user click on post for create a task","Entered the task details",s);

		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			Thread.sleep(2000);
			String s=captureScreenshot();
			Whenlogfail("user click on post for create a task","Unable to entered the task details",s);
			Assert.fail("Failure");
		}
		System.out.println("Added the task details");
	}

	@And("user create a task description and user enter date,time and budget")
	public void user_create_a_task_description_and_user_enter_date_time_and_budget() throws Throwable {
		ReportCreateScenarioTest("user create a task description and user enter date,time and budget");
		try {
			waitForElement("StartDate",PosterXpath);
			getElement("StartDate",PosterXpath).click();
			waitForElement("Currentyear",SignupXpath);
			getElement("Currentyear",SignupXpath).click();
			Thread.sleep(2000);
			scrollby(driver, "0", "0", ExcelRead.readData(1, 6, "post"), ExcelRead.readData(1, 7, "post"),
					ExcelRead.readData(1, 8, "post"));
			waitForElement("StartTime",PosterXpath);
			getElement("StartTime",PosterXpath).click();
			waitForElement("Keypad",PosterXpath);
			getElement("Keypad",PosterXpath).click();
			waitForElement("Hours", PosterXpath);
			sendKeystoElement("Hours", PosterXpath, ExcelRead.readData(1, 9, "post"));
			waitForElement("Minutes", PosterXpath);
			sendKeystoElement("Minutes", PosterXpath, ExcelRead.readData(1, 10, "post"));
			waitForElement("OKbtn",PosterXpath);
			getElement("OKbtn",PosterXpath).click();
			
			Thread.sleep(2000);
			String s=captureScreenshot();
			Andlogpass("user click on post for create a task","Successfully entered the Date and time",s);
		
			waitForElement("ContinueBtn",PosterXpath);
			getElement("ContinueBtn",PosterXpath).click();
			waitForElement("Budget", PosterXpath);
			
			System.out.println("Added the Date and time for the post");
			
			Thread.sleep(1000);
			System.out.println("Excel value:"+ExcelRead.readData(1, 11, "post"));
			//Budget
			
			getElement("Budgetfield",PosterXpath).click();
			Thread.sleep(1000);
			sendKeystoElement("Budget", PosterXpath, ExcelRead.readData(1, 11, "post"));
			System.out.println("Budget added");
			
			hideCloudDeviceKeyboard();
			Thread.sleep(2000);
			String s1=captureScreenshot();
			Andlogpass("user click on post for create a task","Successfully entered the Budget amount",s1);
			
			waitForElement("Continue",PosterXpath);
			System.out.println("Continue btn");
			Thread.sleep(3000);
			getElement("Continue",PosterXpath).click();
			clickElement("Continue",PosterXpath);
			
			System.out.println("Added the Budget amount");
			
			Thread.sleep(2000);
			waitForElement("CongratsMsg",PosterXpath);
			
			WebElement CongratsMsg = getElement("CongratsMsg",PosterXpath);
			WebElement AlertMsg = getElement("EnableNotifyMsg",PosterXpath);
			Thread.sleep(2000);
			try {
				if (CongratsMsg.isDisplayed()) {
					String validationText = CongratsMsg.getText().trim();
					String validationText1 = AlertMsg.getText().trim();
					Assert.assertEquals(validationText, Validation.expectedCongratsMsg);
					System.out
							.println("Actual Value:" + validationText + " Expected value:" + Validation.expectedCongratsMsg);
					
					Thread.sleep(2000);
					String s2=captureScreenshot();
					Andlogpass("user click on post for create a task",
							"Actual Value:" + validationText + " Expected value:" + Validation.expectedCongratsMsg,s2);
					
					Assert.assertEquals(validationText1, Validation.expectedAlertMsg);
					System.out
							.println("Actual Value:" + validationText1 + " Expected value:" + Validation.expectedAlertMsg);
					
					Thread.sleep(2000);
					String s3=captureScreenshot();
					Andlogpass("user click on post for create a task",
							"Actual Value:" + validationText1 + " Expected value:" + Validation.expectedAlertMsg,s3);
					
				} else {
					System.out.println("Element not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			waitForElement("DoneBtn",PosterXpath);
			getElement("DoneBtn",PosterXpath).click();
			Thread.sleep(2000);
			String s4=captureScreenshot();
			Andlogpass("user click on post for create a task","Successfully created the post",s4);
		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			Thread.sleep(2000);
			String s=captureScreenshot();
			Andlogfail("user click on post for create a task","Unable to create the post",s);
			Assert.fail("Failure");
		}
System.out.println("Successfully created the post");
	}


//	@Then("click on the continue and Check the post created or not")
//	public void click_on_the_continue_and_check_the_post_created_or_not() throws Throwable {
//		ReportCreateScenarioTest("click on the continue and Check the post created or not");
//		try {
//			Thread.sleep(2000);
//			waitForElement("Browse",PosterXpath);
//			getElement("Browse",PosterXpath).click();
//			
//			Thread.sleep(2000);
//			String s=captureScreenshot();
//			Thenlogpass("Check the post created or not","View the list of post on browser",s);
//			
//			waitForElement("SearchIcon",PosterXpath);
//			getElement("SearchIcon",PosterXpath).click();
//			waitForElement("SearchField", PosterXpath);
//			sendKeystoElement("SearchField", PosterXpath, ExcelRead.readData(1, 12, "post"));
//			Thread.sleep(2000);
//			Tasklist();
//			
//			Thread.sleep(2000);
//			String s1=captureScreenshot();
//			Thenlogpass("Check the post created or not","Successfully the post is created",s1);
//			
//		}catch(Exception e) {
//			System.out.println("Failed due to Exception:: "+e);
//			Thread.sleep(2000);
//			String s=captureScreenshot();
//			Thenlogpass("Check the post created or not","Post is not created",s);
//			Assert.fail("Failure");
//		}
//
//	}

	public void elementlist() throws Throwable {
		try {
			List<WebElement> allrow = getElements("listview",PosterXpath);
			int rowcount = allrow.size();
			for (WebElement rows : allrow) {
				String text = rows.getText().toString();
				if (ExcelRead.readData(1, 0, "post").equalsIgnoreCase(text)) {
					Thread.sleep(1000);
					rows.click();
					break;
				}
			} }catch (Exception e) {
				System.out.println("exception" + e);
			}}
	
	public void Tasklist() throws Throwable {
		try {
			List<WebElement> allrow = getElements("TaskList",PosterXpath);
			int rowcount = allrow.size();
			for (WebElement rows : allrow) {
				String text = rows.getText().toString();
					Thread.sleep(1000);
					System.out.println(text);
					Assert.assertEquals(text, ExcelRead.readData(1, 1, "post"));
					System.out
							.println("Actual Value:" + text + " Expected value:" + ExcelRead.readData(1, 1, "post"));
					
			} }catch (Exception e) {
				System.out.println("exception" + e);
			}}

}
