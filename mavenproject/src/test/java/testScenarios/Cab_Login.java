package testScenarios;

import org.openqa.selenium.WebElement
;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import TestObjectRepository.Cab_LoginRepository;
import UserDefinedlibraries.ExcelReadWrite;
import UserDefinedlibraries.JSONReadWrite;

public class Cab_Login extends Home {

	static Cab_LoginRepository objLogin = new Cab_LoginRepository(driver);
	
	@SuppressWarnings("static-access")
	public static void CabApplication() {
		
		//selection of "cab" in menu
   	    for(WebElement element : objLogin.menu) {
   	    	
			if ((element).getText().equals(ExcelReadWrite.Menu1)) {
				
				(element).click();
				break;
			}
   	    }
	}
	
	@SuppressWarnings("static-access")
	public static void FromCab(){

		objLogin.click_from.click();
    	
    	//searching 'from' location  
		objLogin.from_textbox.sendKeys(JSONReadWrite.From);
      	
    	//autosuggestion
   	    for(WebElement element : objLogin.Autosuggest_from) {
			if ((element).getText().equals(JSONReadWrite.From)) {
				(element).click();
				break;
			}
   	    }
   	
    }
	
	 @SuppressWarnings("static-access")
	public static void Tocab() {
	    	
		//searching 'from' location 
		objLogin.to_textbox.sendKeys(JSONReadWrite.To);		    
		
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.textToBePresentInElement(objLogin.wait,JSONReadWrite.To ));

	    //autosuggestion  
	    for(WebElement element : objLogin.Autosuggest_to) {	
				if ((element).getText().equals(JSONReadWrite.To)) {
					(element).click();
					break;
				}
	   	    }
	    }
	    
	    @SuppressWarnings("static-access")
		public static void DateofTravell() {
	    	
	    	String gettext = objLogin.month.getText();
			month: do {
				gettext = objLogin.month.getText();
				if (gettext.contains(JSONReadWrite.TravelMonth)) {
					break month;
				} else {
					objLogin.next_month.click();
				}
			} while (!(gettext.contains(JSONReadWrite.TravelMonth)));

			// getting date list for entire month and clicking the matched values from excel
			date: for (WebElement dt : objLogin.Date) {
				gettext = dt.getText();
				if (gettext.equalsIgnoreCase(JSONReadWrite.Traveldate)) {
					dt.click();
					break date;
				}
			}

	    }
	    
	    @SuppressWarnings("static-access")
		public static void PickUptime() {
	    	
	   	    for(WebElement element : objLogin.time) {     
				if ((element).getText().equals(JSONReadWrite.PickUpTime)) {
					(element).click();			
					break;
				}
	   	    }
	  
	    }
	    
	    @SuppressWarnings("static-access")
		public static void Search() {
	    	objLogin.search.click();
	    	Cab_LoginRepository.value=true;
	    	logger.log(Status.INFO, "Valid data is passed to the fields!");
	        if(Cab_LoginRepository.value) {
	        	 logger.log(Status.PASS, "Test Passed - Searching for cabs...");
	        }else {
	        	 logger.log(Status.FAIL, "Test Failed");
	        }
	    }
	    
	    public static void main() {
	    	
	    	CabApplication();
	    	FromCab();
	    	Tocab();
	    	DateofTravell();
	    	PickUptime();
	    	Search();    	
	    }	
}
