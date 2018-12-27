package com.ypls.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ypls.base.BaseClass;
import com.ypls.utility.CaptureScreen;
import com.ypls.utility.Utility;

public class ManageAssetPage extends BaseClass
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
	
	@FindBy(how=How.ID, using="showLeftPush")
	WebElement menuButton;
	
	@FindBy(how=How.XPATH, using="//*[@class='itemName'][contains(text(),'Content Management')]")
	WebElement contentMgmt;
	
	@FindBy(how=How.XPATH, using="//*[@class='submenu']/li/a[contains(text(),'Manage Asset Library')]")
	WebElement manageAssetMenu;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_tvAssetFoldert0")
	WebElement assetLink;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnAddFolder")
	WebElement addFolder;
	
	@FindBy(how=How.ID, using="ctl00_ContentPlaceHolder1_txtFolderName")
	WebElement folderName;
	
	@FindBy(how=How.ID, using="ctl00_ContentPlaceHolder1_btnAddFolderOk")
	WebElement saveFolder;
	
	@FindBy(how=How.XPATH, using="//*[@id='ctl00_cphContent_tvAssetFoldern0Nodes']/table")
	WebElement folderNames;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_btnAddNewAssets")
	WebElement addNewAsset;
	
	@FindBy(how=How.ID, using="ctl00_cphContent_txtAssestName")
	WebElement newAssetName;
	
	@FindBy(how=How.XPATH, using="//*[@for=\"ctl00_cphContent_chkAllowPrinting\"]")
	WebElement printCert;
	
	@FindBy(how=How.XPATH, using="//*[@class='select-wrapper autodivlist2']")
	WebElement newAssetType;
	
	@FindBy(how=How.XPATH, using="//*[starts-with(@id,'select-options-')]/li[2]/span[contains(text(),'PDF')]")
	WebElement selectPDFAssetType;

	@FindBy(how=How.ID, using="ctl00_cphContent_UploadAsset_Html5InputFile")
	WebElement uploadNewAsset;
	
	@FindBy(how=How.XPATH, using="//*[@class='form-horizontal form-elmnts']/div[@class='btn-wrap btn-wrap--pl mrgTop40']")
	WebElement saveBar;
	
	@FindBy(how=How.XPATH, using="//*[@name='ctl00$cphContent$btnSave']")
	WebElement saveNewAsset;
	
	public ManageAssetPage()
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
	}
	
	public void clickMenu()
	{
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		
		menuButton.click();
	}
	
	public void clickContentManagement()
	{
		contentMgmt.click();
	}
	
	public void clickAssetMenu()
	{
		manageAssetMenu.click();
	}
	
	public void clickAssetLink()
	{
		assetLink.click();
	}
	
	public void addFolder() throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(Utility.long_implicit_wait, TimeUnit.SECONDS);
		
		Thread.sleep(10000);

		addFolder.click();	
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
	}
	
	public void typeFolderName() throws Exception 
	{
		driver.switchTo().frame("ctl00_iframeModal");
		
		folderName.sendKeys(Utility.Folder_Name);
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
	}
	
	public void clickSaveFolder() throws InterruptedException
	{
		saveFolder.click();
		
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
		
		driver.switchTo().defaultContent();
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
	}
	
	public void AddAsset() throws Exception
	{
		List<WebElement> table = driver.findElements(By.xpath("//*[@id='ctl00_cphContent_tvAssetFoldern0Nodes']/table/tbody/tr/td[4]/a"));
		
		for(WebElement tab : table)
		{
			if(tab.getText().equalsIgnoreCase(Utility.Folder_Name))
			{
				tab.click();
				break;
			}
		}
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		
		Thread.sleep(10000);
		
		addNewAsset.click();
	}
	
	public void TypeAssetName()
	{
		newAssetName.sendKeys(Utility.Asset_Name);
		
		//printCert.click();
	}
	
	public void selectAssetType() throws InterruptedException
	{
		newAssetType.click();
		
		//driver.manage().timeouts().implicitlyWait(Utility.long_implicit_wait, TimeUnit.SECONDS);
		Thread.sleep(10000);
		List<WebElement> assetTypes = driver.findElements(By.xpath("//*[@class='select-wrapper autodivlist2']/ul/li/span"));
		
		for(WebElement asset : assetTypes)
		{
			System.out.println("Asset Type is: " +asset.getText());
			if(asset.getText().contains("PDF")) {
				
				selectPDFAssetType.click();
				
				break;
			}
		}
	}
	
	public void uploadPDF() throws IOException, Exception
	{
		uploadNewAsset.click();
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		
		Runtime.getRuntime().exec("D:\\Kishore\\Technology Projects\\Automation\\Workspaces\\YPLS\\UploadAsset.exe");
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		
		printCert.click();
	}
	
	public void saveAsset() throws Exception
	{
		Thread.sleep(20000);
		
		saveNewAsset.click();
		
		Thread.sleep(20000);

		try {
			Alert alert = driver.switchTo().alert();

			System.out.println("Alert text is: " + alert.getText());
			
			alert.accept();
			
		} catch (UnhandledAlertException e) {
			
			Alert alert = driver.switchTo().alert();

			System.out.println("Alert text is: " + alert.getText());
			
			alert.accept();
		}
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
	}
		
	public void VerifyAsset() throws IOException
	{
		List<WebElement> assets = driver.findElements(By.xpath("//*[@id='ctl00_cphContent_gvAssetGrid']/tbody/tr/td[2]"));
		
		String timestamp = Utility.DateTime();
		
		for(WebElement asset : assets)
		{	
						Assert.assertTrue("Asset verified", asset.getText().equalsIgnoreCase(Utility.Asset_Name));
						
						CaptureScreen.AssetScreenCapture(timestamp);
		}
	}
}
