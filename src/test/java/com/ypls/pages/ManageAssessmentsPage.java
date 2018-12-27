package com.ypls.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ypls.base.BaseClass;
import com.ypls.utility.Utility;

public class ManageAssessmentsPage extends BaseClass
{ 
	@FindBy(how=How.XPATH, using="//*[contains(text(), 'Manage Assessments')]")
	WebElement ManageAssessmentMenu;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnAddAssessment")
	WebElement AddAssessmentButton;
	
	@FindBy(how=How.XPATH,using="//*[@id='cke_1_contents']//*[@class='cke_wysiwyg_frame cke_reset']")
	WebElement assessmentEditor;
	
	@FindBy(how=How.XPATH, using="//body[@contenteditable='true']")
	WebElement assessmentTextEditor;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnGoBack")
	WebElement mainSaveButton;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_hrefOptions")
	WebElement optionsMenu;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_txtQuestionCount")
	WebElement questionCount;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_txtAssessmentTime")
	WebElement assessmentTime;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_txtAlert")
	WebElement alertTime;
	
	@FindBy(how=How.XPATH, using="//*[@class='select-dropdown' and @value = 'Please Select']")
	WebElement assessmentResult;
	
	@FindBy(how=How.XPATH, using="//*[@class='select-wrapper autodivlistauto']/ul/li")
	List<WebElement> assessmentDropdown;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tab-1\"]/div/div[9]/div[1]/div/div/label")
	WebElement printCertificate;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tab-1\"]/div/div[9]/div[6]/div/div/label")
	WebElement answerAllQuestions;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnUpdate")
	WebElement optionsSaveButton;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_hrefSections")
	WebElement questionsMenu;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnAddSection")
	WebElement addQuestionButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_cphContent_gvQuestions\"]/tbody/tr[2]/th[1]/label")
	WebElement selectAllQuestions;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnSaveQuestion")
	WebElement addSelectedQuestions;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_hRefDesign")
	WebElement designMenu;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnUpdate")
	WebElement saveDesign;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_Button1")
	WebElement cancelButton;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_txtAssessmentName")
	WebElement provideAssessmentName;
	@FindBy(how=How.ID, using="ctl00_cphContent_btnSubmit")
	WebElement clickSearch;
	@FindBy(how=How.XPATH, using="//*[@class='table custGrid']/tbody/tr[3]/td[2]")
	WebElement searchedText;
	@FindBy(how=How.XPATH, using="//*[@title='Send for Approval']")
	WebElement sendForApprovalLink;
	@FindBy(how=How.ID, using="ctl00_cphContent_txtAdminReviewEmail")
	WebElement adminReviewEmail;
	@FindBy(how=How.ID, using="ctl00_cphContent_btnSendForApproval")
	WebElement sendForApproval;
	@FindBy(how=How.XPATH, using="//*[@title='Approve']")
	WebElement approvalLink;
	
	
	public ManageAssessmentsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickMenu()
	{
		System.out.println("Clicking the manage assessment menu.............");
		
		int submenus = driver.findElements(By.xpath("//li[@class='open']/ul/li")).size();
		for(int i=1;i<submenus;i++)
		{
			driver.findElement(By.xpath("//li[@class='open']/ul/li["+i+"]/a")).getText();
		}
		ManageAssessmentMenu.click();
	}
	
	public void clickAddButton()
	{
		AddAssessmentButton.click();
	}
	
	public void addAssessmentDetails()
	{
		driver.switchTo().frame(assessmentEditor);
		assessmentTextEditor.sendKeys("Assessment K1");
		driver.switchTo().defaultContent();
		mainSaveButton.click();
		//Thread.sleep(10000);
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text is: " + alert.getText());
			alert.accept();
		} catch (UnhandledAlertException e) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text is: " + alert.getText());
			alert.accept();
		}
		//driver.switchTo().defaultContent();
	}
	
	public void addOptionsDetails() throws InterruptedException
	{
		optionsMenu.click();
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		questionCount.sendKeys("5");
		assessmentTime.sendKeys("2");
		alertTime.sendKeys("1");
		driver.manage().timeouts().implicitlyWait(Utility.long_implicit_wait, TimeUnit.SECONDS);
		assessmentResult.click();
		//driver.manage().timeouts().implicitlyWait(Utility.long_implicit_wait, TimeUnit.SECONDS);
		Thread.sleep(5000);
		assessmentDropdown.size();
		for(int i=1;i<=assessmentDropdown.size();i++)
		{
			driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
			String resultOption = driver.findElement(By.xpath("//*[@class='select-wrapper autodivlistauto']/ul/li["+i+"]")).getText();
			//System.out.println("The options value is: " +resultOption);
			if(resultOption.contains("On Last Attempt"))
			{
				driver.findElement(By.xpath("//*[@class='select-wrapper autodivlistauto']/ul/li["+i+"]")).click();
			}
		}
		printCertificate.click();
		answerAllQuestions.click();
		optionsSaveButton.click();
		Thread.sleep(5000);
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text is: " + alert.getText());
			alert.accept();
			} catch (UnhandledAlertException e) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text is: " + alert.getText());
			alert.accept();
		}
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", questionsMenu);
	}
	
	public void addQuestionDetails()
	{
		questionsMenu.click();
		addQuestionButton.click();
	}
	
	public void addQuestions()
	{
		selectAllQuestions.click();
		addSelectedQuestions.click();
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text is: " + alert.getText());
			alert.accept();
			} catch (UnhandledAlertException e) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text is: " + alert.getText());
			alert.accept();
		}
	}
	
	public void addDesignDetails()
	{
		designMenu.click();
		saveDesign.click();
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text is: " + alert.getText());
			alert.accept();
			} catch (UnhandledAlertException e) {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text is: " + alert.getText());
			alert.accept();
		}
		cancelButton.click();
	}
	
	public void searchAssessment()
	{
		provideAssessmentName.sendKeys("Assessment K1");
		clickSearch.click();
		System.out.println("Assessment Found");
		if(searchedText.getText().contains("Assessment K1"))
		{
			System.out.println("Reuqired Assessment found.");
			sendForApprovalLink.click();
			adminReviewEmail.sendKeys("abc@testmail.com");
			sendForApproval.click();
			try {
				Alert alert = driver.switchTo().alert();
				System.out.println("Alert text is: " + alert.getText());
				alert.accept();
				} catch (UnhandledAlertException e) {
				Alert alert = driver.switchTo().alert();
				System.out.println("Alert text is: " + alert.getText());
				alert.accept();
			}
		}
	}
	
	public void approveAssessment() throws InterruptedException
	{
		provideAssessmentName.sendKeys("Assessment K1");
		clickSearch.click();
		System.out.println("Assessment Found");
		if(searchedText.getText().contains("Assessment K1"))
		{
			approvalLink.click();
			Thread.sleep(10000);
			try {
				Alert alert = driver.switchTo().alert();
				System.out.println("Alert text is: " + alert.getText());
				alert.accept();
				} catch (UnhandledAlertException e) {
				Alert alert = driver.switchTo().alert();
				System.out.println("Alert text is: " + alert.getText());
				alert.accept();
			}
		}
		else
			System.out.println("Assessment Not Found.");
	}
}
