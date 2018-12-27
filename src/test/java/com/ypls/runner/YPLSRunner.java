package com.ypls.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.ExtentProperties;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features="src\\test\\resources\\CourseManagement\\AddCourse.feature",
		//features="src\\test\\resources\\CourseManagement\\AddAsset.feature",
		//features= "src\\test\\resources\\CourseManagement\\AddAssessment.feature", 
		features= "src\\test\\resources\\CourseManagement",
		tags="@asset, @course, @assessment",
		glue="com.ypls.stepDefinitions",
		strict = true, 
        dryRun = false,
        monochrome = true,
        plugin = {
        					"pretty", "html:target/cucumber-reports",
        					"com.cucumber.listener.ExtentCucumberFormatter:output/YPLSReport.html"
				   		}
	)

public class YPLSRunner 
{
	@AfterClass
	public static void RunAssetExtentReport()
	{
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("output/myreport.html");
	}
}