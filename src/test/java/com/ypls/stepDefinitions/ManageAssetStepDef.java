package com.ypls.stepDefinitions;

import com.ypls.base.BaseClass;
import com.ypls.pages.ManageAssetPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class ManageAssetStepDef extends BaseClass
{
	public ManageAssetPage manageassetpage;
	
	/*@After
	public void screenshot() throws IOException
	{
		System.out.println("Executing After hook.....");
		CaptureScreen.AssetScreenCapture(Utility.DateTime());
	}*/
	
	@Given("^the application URL$")
	public void the_application_URL() throws Throwable {
		Init();
		
		LaunchBrowser();
	}

	@When("^the user enters username and password$")
	public void the_user_enters_username_and_password() throws Throwable {
		manageassetpage = new ManageAssetPage();
		
		manageassetpage.provideLoginDetails();
	}

	@When("^clicks Login Button$")
	public void clicks_Login_Button() throws Throwable {
		manageassetpage.clickLogin();
	}

	@When("^clicks LMS option$")
	public void clicks_LMS_option() throws Throwable {
		manageassetpage.clickLMS();
	}

	@When("^clicks Menu option$")
	public void clicks_Menu_option() throws Throwable {
		manageassetpage.clickMenu();
	}

	@When("^clicks Content Management$")
	public void clicks_Content_Management() throws Throwable {
		manageassetpage.clickContentManagement();
	}

	@When("^clicks Manage Asset Library$")
	public void clicks_Manage_Asset_Library() throws Throwable {
		manageassetpage.clickAssetMenu();
	}

	@When("^clicks Asset Link$")
	public void clicks_Asset_Link() throws Throwable {
		manageassetpage.clickAssetLink();
	}

	@When("^clicks Add Folder$")
	public void clicks_Add_Folder() throws Throwable {
		manageassetpage.addFolder();
	}	

	@When("^types in the folder name$")
	public void types_in_the_folder_name() throws Throwable {
		manageassetpage.typeFolderName();
	}

	@When("^clicks Save button$")
	public void clicks_Save_button() throws Throwable {
		manageassetpage.clickSaveFolder();
	}
	
	@When("^clicks Add Asset Button$")
	public void clicks_Add_Asset_Button() throws Throwable {
		manageassetpage.AddAsset();
	}

	@When("^types Asset Name$")
	public void types_Asset_Name() throws Throwable {
		manageassetpage.TypeAssetName();
	}

	@When("^clicks PDF option$")
	public void clicks_PDF_option() throws Throwable {
		manageassetpage.selectAssetType();
	}

	@When("^clicks BROWSE button$")
	public void clicks_BROWSE_button() throws Throwable {
		manageassetpage.uploadPDF();
	}

	@When("^clicks SAVE button$")
	public void clicks_SAVE_button() throws Throwable {
		manageassetpage.saveAsset();
	}

	@Then("^PDF asset gets created$")
	public void pdf_asset_gets_created() throws Throwable {
		manageassetpage.VerifyAsset();
	}
}
