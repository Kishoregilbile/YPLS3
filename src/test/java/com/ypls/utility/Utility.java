package com.ypls.utility;

import java.text.SimpleDateFormat;

public class Utility 
{
	//...............................Wait Time.........................
	public static long Implicit_wait = 10;
	public static long long_implicit_wait = 30;
	
	//............Course Management.....................
	public static String Course_Name = "Auto Course A6";
	
	//.....................Asset Management.......................
	public static String Folder_Name = "AutoFolder3";
	public static String Asset_Name = "pdfAsset1";
	
	//...........................Capturing time-stamp for Screenshot...........................
	public static String DateTime()
	{
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy-HHMMSS");
		String timestamp = sdf.format(date);
		return timestamp;
	}
}
