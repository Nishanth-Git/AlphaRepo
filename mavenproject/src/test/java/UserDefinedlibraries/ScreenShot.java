package UserDefinedlibraries; 

 

import java.io.File; 

import java.io.IOException; 

 

import org.apache.commons.io.FileUtils; 

import org.openqa.selenium.OutputType; 

import org.openqa.selenium.TakesScreenshot; 

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

import testScenarios.Home; 

 

public class ScreenShot extends Home { 

	public static void screenShotTC(WebDriver ldriver){ 
		
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);        
		try {  
			FileUtils.copyFile(src, new File("C:\\Users\\NISHANTH\\eclipse-workspace1\\Alpha\\TCScreenshot\\"+System.currentTimeMillis()+".png")); 
			
		}catch (IOException e){ 
			
			System.out.println(e.getMessage());       
			
		} 
		
	}
	
	public static void finalscreenshot() {
		 String temp=Utility.getScreenshot(driver); 
         try {
			logger.pass("Final SnapShot", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
	
	public static void errorscreenshot() {
		 String temp=Utility.getScreenshot(driver); 
        try {
			logger.pass("Error SnapShot", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
	
}