package com.ypls.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.Scenario;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public static void Init() throws IOException
	{
		FileInputStream fis = new FileInputStream("src\\test\\java\\com\\ypls\\config\\config.properties");
		
		prop = new Properties();
		
		prop.load(fis);
	}
	
	public static void LaunchBrowser()
	{
		if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "Drivers\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Drivers\\Firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "Drivers\\IE\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("tenanturl"));
		
		driver.manage().window().maximize();
	}
	
	@After
	public static void TakeScreenShot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); 
			scenario.embed(screenshot, "image/png");
		}
	}
}
