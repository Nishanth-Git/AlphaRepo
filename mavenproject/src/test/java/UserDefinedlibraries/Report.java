package UserDefinedlibraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report{
	
	public static ExtentReports extent;
	
	public static ExtentReports getReportInstance(){
		
		if(extent == null){
			
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\NISHANTH\\eclipse-workspace1\\Alpha\\Reports\\"+System.currentTimeMillis()+".html");
			extent =  new ExtentReports();
			extent.attachReporter(htmlReporter);

		}
		
		return extent;
	}

}