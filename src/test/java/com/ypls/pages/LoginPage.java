package com.ypls.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ypls.base.BaseClass;
import com.ypls.utility.Utility;

public class LoginPage extends BaseClass
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
	
	public LoginPage()
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
	
	public AddCoursePage clickLMS()
	{
		lms.click();
		
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_wait, TimeUnit.SECONDS);
		
		Assert.assertTrue("Dashboard is not displyed.", ypback.isDisplayed());	
		
		return new AddCoursePage();
	}
}