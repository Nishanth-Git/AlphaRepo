package UserDefinedlibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageWait {
	
	public static boolean waitForPageLoaded(WebDriver driver){
		return ((JavascriptExecutor) driver).executeScript(
				"return document.readyState").toString().equals("complete");
	}
	
	public static void wait(WebDriver driver, int seconds){
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

}
