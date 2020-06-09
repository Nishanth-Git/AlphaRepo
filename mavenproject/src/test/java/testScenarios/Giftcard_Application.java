package testScenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import TestObjectRepository.Giftcard_Repository;
import UserDefinedlibraries.ExcelReadWrite;
import UserDefinedlibraries.PageWait;
import UserDefinedlibraries.ScreenShot;
import UserDefinedlibraries.XMLReadWrite;

public class Giftcard_Application extends Home{

	  static Giftcard_Repository objgift = new Giftcard_Repository(driver);
	  public static String error;
	  
	  @SuppressWarnings("static-access")
	  public static void giftcard() {
		  PageWait.wait(driver, 30);
		  for(WebElement element : objgift.menu) {
	   	    	
				if ((element).getText().equals(ExcelReadWrite.Menu2)) {
					
					(element).click();
					break;
				}
	   	    }
	  }
	  
	  @SuppressWarnings("static-access")
	  public static void groupgift() {
		  WebDriverWait wait = new WebDriverWait(driver,30);
	      wait.until(ExpectedConditions.elementToBeClickable(objgift.groupgifting));
	      objgift.groupgifting.click();
		  WebDriverWait wait1 = new WebDriverWait(driver,30);
	      wait1.until(ExpectedConditions.elementToBeClickable(objgift.Ecard));
	      objgift.Ecard.click();
	  }
	  
	  @SuppressWarnings({ "static-access"})
	  public static void carddetails() {

		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	       logger.log(Status.INFO, "Valid card details are passed");
	      
	      objgift.amount.sendKeys(XMLReadWrite.amount);
		  
		  WebDriverWait wait1 = new WebDriverWait(driver,30);
	      wait1.until(ExpectedConditions.elementToBeClickable(objgift.deadline));

	      objgift.deadline.click();
		  
	    	String gettext = objgift.month.getText();
			month: do {
				gettext = objgift.month.getText();
				if (gettext.contains(XMLReadWrite.TargetMonth)) {
					break month;
				} else {
					objgift.next_month.click();
				}
			} while (!(gettext.contains(XMLReadWrite.TargetMonth)));

			// getting date list for entire month and clicking the matched values from excel
			date: for (WebElement dt : objgift.Date) {
				gettext = dt.getText();
				if (gettext.equalsIgnoreCase(XMLReadWrite.Targetday)) {
					dt.click();
					break date;
				}
			}
	    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",objgift.view);
	    	objgift.terms.click();
			objgift.view.click();
	  }
	 
	  @SuppressWarnings("static-access")
	  public static void recipientdetails() {
		  objgift.name.sendKeys(XMLReadWrite.RecipientName);
		  objgift.email.sendKeys(XMLReadWrite.RecipientEmail);
		  objgift.next.click(); 
		  
		  error = objgift.frame.getText().split("\\.")[0];
	      System.out.println("Error message : "+error);
	      ScreenShot.errorscreenshot();
	      logger.log(Status.INFO, "Error message is captured for the invalid email-id");
	         
	      int Readrow = ExcelReadWrite.row;
 	    	
		   ExcelReadWrite.cell = ExcelReadWrite.sheet.getRow(Readrow).getCell(3); 
		  
		  if (ExcelReadWrite.cell == null) 
			  
			  ExcelReadWrite.cell = ExcelReadWrite.sheet.getRow(Readrow).createCell(3); 
			 (ExcelReadWrite.cell).setCellValue(error); 
			 ExcelReadWrite.writeexcel();
	         objgift.okay.click();
	  }
	  
	  public static void main() {
		  
		  giftcard();
		  groupgift();
		  carddetails();
		  recipientdetails();
	  }

}
