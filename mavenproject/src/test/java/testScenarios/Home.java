package testScenarios;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import UserDefinedlibraries.DriverSetup;
import UserDefinedlibraries.ExcelReadWrite;
import UserDefinedlibraries.PropertiesFile;
import UserDefinedlibraries.Report;
import UserDefinedlibraries.ScreenShot;
import UserDefinedlibraries.Utility;

public class Home extends DriverSetup {

	public static WebDriver driver;
	public static List<WebElement> Auto;
	public static ExtentTest logger;
	public static ExtentReports extent;
	public static boolean retry = false;
	
    /*
	 * Team    : ALPHA
     * Date    : 26-05-2020
     *  
	 */
	
	//Browser Instatiation
	@BeforeClass(groups={"Smoke"})
	public static void Driverconfig() {		
		extent = Report.getReportInstance(); 
		driver = DriverSetup.driverInstantiate();
	}
	
	//Menu->Cabs 
	@Test(priority = 1,groups={"Smoke"})
	public void loginpage_cab() {	
		//Conditions for re-running the test
		if(!(UserDefinedlibraries.RetryFailedTestCases.retryCnt == 0)) {
			logger.log(Status.INFO,"Re-Runing Cab");
			driver.navigate().to(PropertiesFile.url);
		}
		logger = extent.createTest("Cab");
        if(("Cabs".equalsIgnoreCase(ExcelReadWrite.Menu1))) {
         	 logger.log(Status.PASS, "Test Passed - MENU -> Cabs");
         }else {
         	 logger.log(Status.FAIL, "Test Failed");
         }
		Cab_Login.main();	
   	   
	}
	
	//Cab details and selection 
	@Test(priority = 2,groups={"Regression"})
	public void cab_selection() {
		//Conditions for re-running the test
		if(!(UserDefinedlibraries.RetryFailedTestCases.retryCnt == 0)) {
			logger.log(Status.INFO,"Re-Runing Cab");
			driver.navigate().to(PropertiesFile.url);
		}
		Cab_Selection.Cabtype();
		ScreenShot.finalscreenshot();
	}
	
	@Test(priority = 3,groups={"Regression"})
	public void navigation() {
		//to navigate back to home url
		UserDefinedlibraries.RetryFailedTestCases.retryCnt = 0;
		driver.navigate().to(PropertiesFile.url);
	}
	
	//Menu->Giftcards
	@Test(priority = 4,groups={"Regression"})
	public void Giftcards() {
		logger = extent.createTest("Giftcards");
		//Conditions for re-running the test
		if(!(UserDefinedlibraries.RetryFailedTestCases.retryCnt == 0)) {
			logger.log(Status.INFO,"Re-Runing Giftcards");
			driver.navigate().to(PropertiesFile.url);
		}
        if(("Giftcards".equals(ExcelReadWrite.Menu2))) {
          	 logger.log(Status.PASS, "Test Passed - MENU -> GIFTCARDS");
          }else {
          	 logger.log(Status.FAIL, "Test Failed");
          }
		
		Giftcard_Application.main();
		ScreenShot.finalscreenshot();
	}
	
	@Test(priority = 5,groups={"Regression"})
	public void backtohotel() {
		UserDefinedlibraries.RetryFailedTestCases.retryCnt = 0;
		driver.navigate().to(PropertiesFile.url);
	}
	
	//Menu->Hotel
	@Test(priority = 6,groups={"Regression"})
	public void Hotel() {
		//Conditions for re-running the test
		if(!(UserDefinedlibraries.RetryFailedTestCases.retryCnt == 0)) {
			logger.log(Status.INFO,"Re-Runing Hotel");
			driver.navigate().to(PropertiesFile.url);
		}
		logger = extent.createTest("Hotel");
        if(("Hotels".equals(ExcelReadWrite.Menu3))) {
         	 logger.log(Status.PASS, "Test Passed - MENU -> HOTEL");
         }else {
         	 logger.log(Status.FAIL, "Test Failed");
         }
		Hotel_Application.main();
		ScreenShot.finalscreenshot();
	}
	
    @AfterMethod(groups={"Regression"}) 
    public void tearDown(ITestResult result) { 
     
   	 //screenshot is attached in the report for the failed testcases.
   	 if(result.getStatus()==ITestResult.FAILURE) { 
   		 String temp=Utility.getScreenshot(driver); 
            try {
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
            
   	 }  extent.flush();  	 
     
    } 
	
	@AfterClass(groups={"Smoke"})
	public static void Driverclose() {
		DriverSetup.driverClose();
	}
}
