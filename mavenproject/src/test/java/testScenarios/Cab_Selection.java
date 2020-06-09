package testScenarios;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import TestObjectRepository.Cab_SelectionRepository;
import UserDefinedlibraries.ExcelReadWrite;
import UserDefinedlibraries.JSONReadWrite;

public class Cab_Selection extends Home{

	static Cab_SelectionRepository objsel = new Cab_SelectionRepository(driver);
	public static String Budget;
	
    @SuppressWarnings("static-access")
	public static void Cabtype() {
    	  logger.log(Status.INFO, "All types of cabs are listed");
		  int i=0,j=0;
		  String arr[]= new String[objsel.budget.size()];
		  
		  for(WebElement element : objsel.cabtype) {
			  
			  if(element.getText().equalsIgnoreCase(JSONReadWrite.CabType)) {

					for(WebElement e : objsel.budget) {   		
		   	    		arr[i]=e.getText();
		   	    		i=i+1;
		   	        }
					Cab_SelectionRepository.fair=arr[j];
					Budget="Rs. ".concat(Cab_SelectionRepository.fair.replaceAll("[^\\.A-Za-z0-9_,]", ""));
				//	Budget = Cab_SelectionRepository.fair.replaceAll("\\W", "");
					
		   	    	System.out.println("Cab Type : "+JSONReadWrite.CabType+", Lowest fair : "+Budget);
		   	    	logger.log(Status.INFO, "Cab Type : "+JSONReadWrite.CabType+", Lowest fair : "+Budget);
		   	    	
		   	    	 int Readrow = ExcelReadWrite.row;
		   	    	
					   ExcelReadWrite.cell = ExcelReadWrite.sheet.getRow(Readrow).getCell(1); 
					  
					  if (ExcelReadWrite.cell == null) 

						  ExcelReadWrite.cell = ExcelReadWrite.sheet.getRow(Readrow).createCell(1); 
						  (ExcelReadWrite.cell).setCellValue(Budget); 
						  ExcelReadWrite.writeexcel(); 
		   	    	break;
			  }
			  j++; 
			  
		  }
	        	
	  }
}
