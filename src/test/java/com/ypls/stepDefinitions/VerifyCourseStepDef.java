package com.ypls.stepDefinitions;

import com.ypls.pages.VerifyCoursePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyCourseStepDef 
{
	public VerifyCoursePage verifycoursepage;
	
	/*@After
	public void screenshot() throws IOException
	{
		//System.out.println("Executing After hook.....");
		CaptureScreen.CourseScreenCapture(Utility.DateTime());
	}*/
	
	@Given("^The course is displayed on the page$")
	public void The_course_is_displayed_on_the_page() throws Throwable 
	{
		verifycoursepage = new VerifyCoursePage();
		
		verifycoursepage.verifyCourse();
	}

	@When("^I launch the course$")
	public void I_launch_the_course() throws Throwable 
	{
		verifycoursepage.clickPreview();
	}

	@Then("^it launches properly$")
	public void it_launches_properly() throws Throwable 
	{
		verifycoursepage.verifyCourseLauch();
	}
	
}
