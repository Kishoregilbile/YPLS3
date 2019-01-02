package com.ypls.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ypls.base.BaseClass;
import com.ypls.utility.CaptureScreen;
import com.ypls.utility.Utility;

public class ManageCoursesPage extends BaseClass
{
	@FindBy(how=How.XPATH, using="//*[@id=\"UserName\"]")
	WebElement username;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"Password\"]")
	WebElement password;
	
	@FindBy(how=How.XPATH, using="//*[@onclick='submitshowLoader();']")
	WebElement login;
	
	@FindBy(how=How.XPATH,using="//*[@title='Learning Management System']/span[contains(text(),'Launch')]")
	WebElement lms;
	
	@FindBy(how=How.XPATH,using="//*[@class='yp-back']")
	WebElement ypback;
	
	/*@FindBy(how=How.XPATH,using="//*[@class='yp-back']")
	WebElement ypback;*//*===============================================*/
	
	@FindBy(how=How.ID, using="showLeftPush")
	WebElement menuButton;
	
	@FindBy(how=How.XPATH, using="//*[@class='itemName'][contains(text(),'Content Management')]")
	WebElement contentMgmt;
	
	@FindBy(how=How.XPATH, using="//*[@class='submenu']/li/a[contains(text(),'Manage Courses')]")
	WebElement manageCourseMenu;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnAddCourse")
	WebElement addCourseButton;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_txtCourseName")
	WebElement courseName;
	
	@FindBy(how=How.XPATH, using="//*[@class='select-dropdown']")
	WebElement coursedropdown;
	
	//@FindBy(how=How.XPATH, using="//*[@class='dropdown-content select-dropdown  active']/li/span[contains(text(),'Scorm 1.2')]") 
	@FindBy(how=How.XPATH, using="//*[starts-with(@id,'select-options')]/li[4]/span")
	WebElement coursedropdownValue;
	
	/*@FindBy(how=How.ID, using="ctl00_cphContent_flUpload")
	WebElement chooseFile;*/
	@FindBy(how=How.XPATH, using="//*[@id='ctl00_cphContent_flUpload']")
	WebElement chooseFile;
	
	@FindBy(how=How.XPATH, using="//*[@for='ctl00_cphContent_chkKeepZipFile']")
	WebElement zipFile;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnUploadCourse")
	WebElement uploadCourse;
	
	@FindBy(how=How.XPATH, using="//*[@id='ctl00_cphContent_lblPackageMsg']")
	WebElement courseMessage;
	
	@FindBy(how=How.XPATH, using="//*[@for='ctl00_cphContent_rbltarget_1']")
	WebElement newWindowRadio;
	
	@FindBy(how=How.XPATH, using="//*[@class='radio hrzntl p-left-0']/li/span/label[contains(text(),'Print')]") 
	WebElement printCertificate;
	
	@FindBy(how=How.XPATH, using="//*[@class='radio hrzntl p-left-0']/li/span/label[contains(text(),'Is HTML')]") 
	WebElement html;
	
	@FindBy(how=How.XPATH, using="//*[@for='ctl00_cphContent_rblprotocol_1']\r\n") 
	WebElement https;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnSave")
	WebElement saveButton;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_txtSearchCourse")
	WebElement searchCourseName;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnSearchCourses")
	WebElement searchCourseButton;
	
	@FindBy(how=How.XPATH, using="//*[@id='ctl00_cphContent_gvCourseList']/tbody/tr[3]/td[3]")
	WebElement 	searchCourseText;

	@FindBy(how=How.ID, using="ctl00_cphContent_btnCancel")
	WebElement cancelButton;
	
	@FindBy(how=How.XPATH, using="//*[@class='zmdi zmdi-eye zmdi-hc-fw']")
	WebElement previewButton;
	
	@FindBy(how=How.ID, using="ctl00_lblUserName")
	WebElement logoutlink;
	
	@FindBy(how=How.ID, using="ctl00_btnLogout")
	WebElement logout;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_cphContent_gvCourseList\"]/tbody/tr[2]/td/span")
	WebElement noRecordMessage;
	
	public ManageCoursesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void provideLoginDetails()
	{
		username.sendKeys(prop.getProperty("username"));
		
		password.sendKeys(prop.getProperty("password"));
	}
	
	public void clickLogin()
	{
		login.click();
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
	}
	
	public void verifyLogin()
	{
		Assert.assertTrue("User is Not logged in.", lms.isDisplayed());
	}
	
	public void clickLMS()
	{
		lms.click();
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		
		Assert.assertTrue("Dashboard is not displyed.", ypback.isDisplayed());	
		
		//return new AddCoursePage();
	}
	
	public void verifyUser()
	{
		if(ypback.isDisplayed())
			System.out.println("User logged In.");
	}
	
	public void clickMenu()
	{
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		
		menuButton.click();

		contentMgmt.click();
		
		manageCourseMenu.click();
	}
	
	public void AddNewCourse()
	{
		addCourseButton.click();
	}
	
	public void FillCourseDetails() throws IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		
		courseName.sendKeys(Utility.Course_Name);
		
		coursedropdown.click();
		
		driver.manage().timeouts().implicitlyWait(Utility.long_implicit_wait, TimeUnit.SECONDS);
		
		try {
			coursedropdownValue.click();
			driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		} catch (Exception e) {
			//driver.manage().timeouts().implicitlyWait(Utility.long_implicit_wait, TimeUnit.SECONDS);
			Thread.sleep(10000);
			coursedropdownValue.click();
		}
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		chooseFile.sendKeys("C:\\Users\\kishore.gilbile\\Documents\\Test Documents\\YPLS\\Course\\Adaptive Solution - Demo Course Updated.zip");
		
		zipFile.click();
		
		newWindowRadio.click();
		
		printCertificate.click();
		
		html.click();
		
		https.click();
		
		try {
			uploadCourse.click();
		} catch (Exception e1) {
			driver.findElement(By.id("ctl00_cphContent_txtCourseDesc")).click();
			uploadCourse.click();
		}
		
		WebDriverWait w1 = new WebDriverWait(driver, 300);
		w1.until(ExpectedConditions.textToBePresentInElement(courseMessage, "Course uploaded successfully."));
		
		saveButton.click();
		
		Thread.sleep(30000);
		String alertText;
		Alert alert;
		try {
			alert = driver.switchTo().alert();
			alertText = alert.getText();
			System.out.println("Alert text is: " + alertText);
			alert.accept();
			} catch (UnhandledAlertException e) {
			alert = driver.switchTo().alert();
			alertText = alert.getText();
			System.out.println("Alert text is: " + alertText);
			alert.accept();
		}
		if(alertText.contains("Course name already exists."))
		{
			//alert.accept();
			cancelButton.click();
		}
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
	}
	
	public void saveCourse() throws InterruptedException, AWTException
	{	
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);

		searchCourseName.sendKeys(Utility.Course_Name);
		
		searchCourseButton.click();
		
		driver.manage().timeouts().implicitlyWait(Utility.long_implicit_wait, TimeUnit.SECONDS);
		
		
			/*Assert.assertEquals("Did not find the course", noRecordMessage.getText(), "No records found.");
		
			Assert.assertEquals("Found the Course. Course is added successfully.", Utility.Course_Name, Utility.Course_Name);*/
		
				String courseText = searchCourseText.getText();
				System.out.println("course text is::::::" + courseText);
				
				if(Utility.Course_Name.equals(courseText))
					System.out.println("Found the Course which was uploaded." +Utility.Course_Name);
				else
				{
					if(!Utility.Course_Name.equals(courseText))
						System.out.println("Course is added successfully, but found different course." +courseText);
					else
						System.out.println("Did not find the course at all.");
				}
	}
	
	public void verifyCourse()
	{
		Boolean a = previewButton.isDisplayed();
		System.out.println(a);
		Assert.assertTrue("Course is displayed", a);
	}
	
	public void clickPreview()
	{
		previewButton.click();
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
	}
	
	public void verifyCourseLauch() throws IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		
		for(String c_window : driver.getWindowHandles())
		{
			driver.switchTo().window(c_window);

			System.out.println("The URL is: " +driver.getCurrentUrl());
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Utility.long_implicit_wait, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("ContentSrvFrame");
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainFrame");
		
		String timestamp = null;
		try {
			driver.findElement(By.xpath("//*[@class='clsEnterBtn']")).click();
			Set<String> handles = driver.getWindowHandles();
			for(String handle : handles)
			{
				driver.switchTo().window(handle);
			}
			System.out.println("The current URL of the launched course is: " +driver.getCurrentUrl());
			CaptureScreen.CourseScreenCapture(timestamp);
			driver.close();
			driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
			} catch (Exception e) {
				System.out.println("Cannot launch the course.");
				timestamp = Utility.DateTime();
				CaptureScreen.CourseScreenCapture(timestamp);
				driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
			}
	}
}
