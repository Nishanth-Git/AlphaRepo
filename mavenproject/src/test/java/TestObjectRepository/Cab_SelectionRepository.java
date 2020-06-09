package TestObjectRepository;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cab_SelectionRepository {

	  WebDriver driver;
	  public static String fair;
      
	  @FindBy(xpath="//li//div[2]//div[1]//div[1]/p[2]")
	  public static List<WebElement> cabtype;
	  
	  @FindBy(xpath="//li/div[3]/p[2]")
	  public static List<WebElement> budget;
   	  
	  
	  public Cab_SelectionRepository(WebDriver driver){
		  
		  this.driver = driver;
		  
		  //This initElements method will create all WebElements
		  PageFactory.initElements(driver, this);
	    }	  
}
