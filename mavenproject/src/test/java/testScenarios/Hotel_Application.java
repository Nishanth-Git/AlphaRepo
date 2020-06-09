package testScenarios;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import TestObjectRepository.Hotel_Repository;
import UserDefinedlibraries.ExcelReadWrite;
import UserDefinedlibraries.JSONReadWrite;

public class Hotel_Application extends Home {

	  static Hotel_Repository objhotel = new Hotel_Repository(driver);
	  public static String list;
	  
	  @SuppressWarnings("static-access")
	  public static  void hotel() {
		  for(WebElement element : objhotel.menu) {
	   	    	
				if ((element).getText().equals(ExcelReadWrite.Menu3)) {
					
					(element).click();
					break;
				}
	   	    }
	  }
	  
	  @SuppressWarnings("static-access")
	  public static void rooms() {
		  objhotel.guest.click();
		  int i=0;
		  String arr[]= new String[11];
		  list = "";
		  for (WebElement adlis : objhotel.adultlist) {
			 
				@SuppressWarnings("unused")
				String gettext = adlis.getText();
				arr[i]=adlis.getText();
			    list = list+arr[i]+" "; 
			}
		    int Readrow = ExcelReadWrite.row;		 	    	
			ExcelReadWrite.cell = ExcelReadWrite.sheet.getRow(Readrow).getCell(5);  

			if (ExcelReadWrite.cell == null) 
		    ExcelReadWrite.cell = ExcelReadWrite.sheet.getRow(Readrow).createCell(5); 
		    (ExcelReadWrite.cell).setCellValue(list); 
		    ExcelReadWrite.writeexcel();
		  logger.log(Status.INFO, "Adult count for room is listed");
		  System.out.println("ROOM"); 
	      System.out.println("ADULTS (12y +)"); 
	      System.out.println(list);	
		  JSONReadWrite.writejson();
	  }
	  
	  public static void main() {
		  hotel();
		  rooms();
	  }
}
