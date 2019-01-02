package com.ypls.stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import com.ypls.base.BaseClass;
import com.ypls.pages.ManageCoursesPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class ManageCoursesStepDef extends BaseClass
{
	public ManageCoursesPage managecoursespage;
	
	@Given("^the application url$")
	public void the_application_url() throws IOException
	{
		Init();
		LaunchBrowser();
	}
	
	@And("^the username and password$")
	public void the_username_and_password()
	{
		managecoursespage =new ManageCoursesPage();
		
		managecoursespage.provideLoginDetails();
	}
	
	@When("^the user clicks Login button$")
	public void the_user_clicks_Login_button()
	{
		managecoursespage.clickLogin();
	}
	
	@And("^selects proper LMS option$")
	public void selects_proper_LMS_option()
	{
		managecoursespage.clickLMS();
	}
	
	@And("^clicks on the Manage Course option$")
	public void clicks_on_the_Manage_Course_option()
	{
		managecoursespage.clickMenu();
	}
	
	@And("^clicks on the Add New Course$")
	public void clicks_on_the_Add_New_Course()
	{
		managecoursespage.AddNewCourse();
	}
	
	@And("^Fills the Course Details and Saves it$")
	public void And_Fills_the_Course_Details_and_Saves_it() throws IOException, InterruptedException
	{
		managecoursespage.FillCourseDetails();
	}
	
	@Then("^the course is added and is displayed on the Course List Page$")
	public void the_course_is_added_and_is_displayed_on_the_Course_List_Page() throws InterruptedException, AWTException
	{
		managecoursespage.saveCourse();
	}
	
	@And("^The course is displayed on the page$")
	public void The_course_is_displayed_on_the_page()
	{
		managecoursespage.verifyCourse();
	}

	@When("^the user launchs the course$")
	public void the_user_launchs_the_course()
	{
		managecoursespage.clickPreview();
	}
	@Then("^it launches properly$")
	public void it_launches_properly() throws IOException, InterruptedException
	{
		managecoursespage.verifyCourseLauch();
	}
}
