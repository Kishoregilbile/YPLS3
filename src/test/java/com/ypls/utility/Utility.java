package com.ypls.utility;

import java.text.SimpleDateFormat;

public class Utility 
{
	//...............................Wait Time.........................
	public static long Implicit_wait = 10;
	public static long long_implicit_wait = 30;
	
	//..................Assessment Management.........................
	public static String Assessment_Name = "Auto Assessment A10";
	public static String Question_Count =  "5"; 
	public static String Assessment_Time = "2";
	public static String Alert_Time = "1"; 
	public static String Assessment_ApprovalEmail = "kishore.gilbile10@indecomm.net";
	
	//.....................Asset Management.......................
	public static String Folder_Name = "AutoFolder10";
	public static String Asset_Name = "Auto pdfAsset A10";
	
	//............Course Management.....................
	public static String CourseName = "Auto Course A10";
	public static String CoursePath = "C:\\Users\\kishore.gilbile\\Documents\\Test Documents\\YPLS\\Course\\Adaptive Solution - Demo Course Updated.zip";
	
	//............................................Add User Form..........................................................
	public static String First_Name = "Automation";
	public static String Last_Name = "TestUserTen";
	public static String Login_ID = "Automationuserten";
	public static String Email_Address = "kishore.gilbile10@indecomm.net";
	public static String Phone_Number = "9988776655";
	public static String City = "Pune";
	public static String State = "AL";
	public static String Address = "Pune";
	public static String ZIP = "34322";
	public static String Password = "P@ssw0rd";
	public static String Confirm_Password = "P@ssw0rd";
	public static String jobRole = "Executive";
	public static String areaofResponsibility = "Marketing";
		
	//....................................................One Time Assignment........................................................
	public static String Search_Activity = "Auto";
	public static  String Search_User = "Automationuserten";
		
	//.................................................Manage Email Distributions List.......................................
	public static String DL_Title = "Auto DL10";
	public static String DL_Email =  "kishore.gilbile10@indecomm.net";
		
	//...........................Capturing time-stamp for Screenshot...........................
	public static String DateTime()
	{
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy-HHMMSS");
		String timestamp = sdf.format(date);
		return timestamp;
	}
}
