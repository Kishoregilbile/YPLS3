package com.ypls.utility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import com.ypls.base.BaseClass;

public class CaptureScreen extends BaseClass
{
	public static void CourseScreenCapture(String timestamp1) throws IOException
	{
		TakesScreenshot tsh = ((TakesScreenshot) driver);
		
		File source = tsh.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(source, new File("D:\\Kishore\\Technology Projects\\Automation\\Workspaces\\YPLS\\YPLS\\Reports\\Screenshots\\Course"+timestamp1+".png"));
	}
	
	public static void AssetScreenCapture(String timestamp1) throws IOException
	{
		TakesScreenshot tsh = ((TakesScreenshot) driver);
		
		File source = tsh.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(source, new File("D:\\Kishore\\Technology Projects\\Automation\\Workspaces\\YPLS\\YPLS\\Reports\\Screenshots\\Asset"+timestamp1+".png"));
	}
}