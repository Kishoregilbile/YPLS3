package com.ypls.pages;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ypls.base.BaseClass;
import com.ypls.utility.CaptureScreen;
import com.ypls.utility.Utility;

public class VerifyCoursePage extends BaseClass
{
	@FindBy(how=How.XPATH, using="//*[@class='zmdi zmdi-eye zmdi-hc-fw']")
	WebElement previewButton;
	
	@FindBy(how=How.ID, using="ctl00_lblUserName")
	WebElement logoutlink;
	
	@FindBy(how=How.ID, using="ctl00_btnLogout")
	WebElement logout;
	
	public VerifyCoursePage()
	{
		PageFactory.initElements(driver, this);
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
		
		/*timestamp = Utility.DateTime();
		
		CaptureScreen.CourseScreenCapture(timestamp);
		
		Set<String> handles = driver.getWindowHandles();
		
		for(String handle : handles)
		{
			driver.switchTo().window(handle);
		}
		
		System.out.println("The current URL of the launched course is: " +driver.getCurrentUrl());
		
		CaptureScreen.CourseScreenCapture(timestamp);
		
		driver.close();
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		*/
		//driver.switchTo().defaultContent();
		
		//logoutlink.click();
		
		//logout.click();
	}
}