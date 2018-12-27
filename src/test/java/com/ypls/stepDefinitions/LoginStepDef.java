package com.ypls.stepDefinitions;

import java.io.IOException;

import com.ypls.base.BaseClass;
import com.ypls.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef extends BaseClass
{
	public LoginPage adduser;
	
	/*@After
	public void screenshot() throws IOException
	{
		//System.out.println("Executing After hook.....");
		CaptureScreen.CourseScreenCapture(Utility.DateTime());
	}*/
	
	@Given("^the application url$")
	public void the_application_url() throws IOException
	{
		Init();
		LaunchBrowser();
	}
	
	@When("^I enter username and password$")
	public void I_enter_username_and_password() throws Throwable
	{
		adduser = new LoginPage();
		
		adduser.provideLoginDetails();
	}
	
	@And("^clicks Login button$")
	public void clicks_Login_button() throws Throwable
	{
		adduser.clickLogin();
	}
	
	@Then("^I should be logged In$")
	public void I_should_be_logged_In() throws Throwable
	{
		adduser.verifyLogin();
	}
	
	@And("^I should select proper LMS option$")
	public void I_should_select_proper_LMS_option()
	{
		adduser.clickLMS();
	}
}
