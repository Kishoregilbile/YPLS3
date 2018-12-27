package com.ypls.stepDefinitions;

import com.ypls.base.BaseClass;
import com.ypls.pages.ManageAssessmentsPage;

import cucumber.api.java.en.And;

public class ManageAssessmentsStepDef extends BaseClass
{
	public ManageAssessmentsPage manageassessmentspage;
	
	@And("^clicks Manage Assessments menu$")
	public void clicks_Manage_Assessments_menu()
	{
		manageassessmentspage = new ManageAssessmentsPage();
		
		manageassessmentspage.ClickMenu();
	}
	
	@And("^clicks Add New Assessment Button$")
	public void clicks_Add_New_Assessment_Button()
	{
		manageassessmentspage.clickAddButton();
	}
	
	@And("^types in the assessment name$")
	public void types_in_the_assessment_name()
	{
		manageassessmentspage.addAssessmentDetails();
	}
	
	@And("^fills up the infomation$")
	public void fills_up_the_infomation() throws InterruptedException
	{
		manageassessmentspage.addOptionsDetails();
	}
	
	@And("^clicks Questions menu$")
	public void clicks_Questions_menu()
	{
		manageassessmentspage.addQuestionDetails();
	}
	
	@And("^selects the questions and clicks AddQuestions$")
	public void selects_the_questions_and_clicks_AddQuestions()
	{
		manageassessmentspage.addQuestions();
	}

	@And("^clicks DesignSave and Cancel Button$")
	public void clicks_DesignSave_and_Cancel_Button()
	{
		manageassessmentspage.addDesignDetails();
	}

	@And("^mentions the email address and click Send For Approval$")
	public void mentions_the_email_address_and_click_Send_For_Approval()
	{
		manageassessmentspage.searchAssessment();
	}
	@And("^clicks Approve link$")
	public void clicks_Approve_link() throws InterruptedException
	{
		manageassessmentspage.approveAssessment();
	}
}
