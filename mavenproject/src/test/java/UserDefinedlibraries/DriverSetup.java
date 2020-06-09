package UserDefinedlibraries;

 

import java.util.concurrent.TimeUnit;
 

 

import org.openqa.selenium.WebDriver; 

import org.openqa.selenium.chrome.ChromeDriver; 

import org.openqa.selenium.firefox.FirefoxDriver;

import UserDefinedlibraries.PropertiesFile; 

 

public class DriverSetup{ 
	
	public static WebDriver driver; 
	public static String exePath; 
	public static String browsertype; 
	
	public static WebDriver driverInstantiate() {
		
		ExcelReadWrite.readexcel();
		JSONReadWrite.read();
		XMLReadWrite.read();
		PropertiesFile.readpropertiesfile();
		browsertype = PropertiesFile.browser;
		
		if(browsertype.equalsIgnoreCase("chrome")) { 
			
			exePath = "C:\\Users\\NISHANTH\\Drivers\\chromedriver.exe"; 
			System.setProperty("webdriver.chrome.driver", exePath); 
			driver = new ChromeDriver();                 
			
		} 
		else if(browsertype.equalsIgnoreCase("firefox")) { 
			
			exePath = "C:\\Users\\NISHANTH\\Drivers\\geckodriver.exe"; 
			System.setProperty("webdriver.gecko.driver", exePath); 
			driver = new FirefoxDriver();                 
			
		}  
		
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get(PropertiesFile.url); 
		driver.manage().deleteAllCookies();
		return driver;   
		
	} 
	public static void driverClose() { 
		
		DriverSetup.driver.close();    
		
	} 
}