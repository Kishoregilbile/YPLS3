package com.ypls.stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;
import com.ypls.base.BaseClass;
import com.ypls.pages.AddCoursePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCourseStepDef extends BaseClass
{
	public AddCoursePage addcoursepage;
	
	/*@After
	public void screenshot() throws IOException
	{
		//System.out.println("Executing After hook.....");
		CaptureScreen.CourseScreenCapture(Utility.DateTime());
	}*/
	
	@Given("^the user is logged in$")
	public void the_user_is_logged_in()
	{
		addcoursepage = new AddCoursePage();
		
		addcoursepage.verifyUser();
	}
	
	@And("^the user clicks on the Manage Course option$")
	public void the_user_clicks_on_the_Manage_Course_option()
	{
		addcoursepage.clickMenu();
	}
	
	@And("^clicks on the Add New Course$")
	public void clicks_on_the_Add_New_Course()
	{
		addcoursepage.AddNewCourse();
	}
	
	@When("^Fills the Course Details and Saves it$")
	public void Fills_the_Course_Details_and_Saves_it() throws IOException, InterruptedException
	{
		addcoursepage.FillCourseDetails();
	}
	
	@Then("^the course is added and is displayed on the Course List Page$")
	public void the_course_is_added_and_is_displayed_on_the_Course_List_Page() throws InterruptedException, AWTException
	{	
		addcoursepage.saveCourse();
	}
}
