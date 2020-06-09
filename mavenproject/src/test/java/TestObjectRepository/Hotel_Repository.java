package TestObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hotel_Repository {
	  WebDriver driver;
      
	  @FindBy(xpath="//ul[@class='makeFlex font12']/li/a/span[2]")
	  public static List<WebElement> menu;
	  
	  @FindBy(xpath="//*[@id=\"guest\"]")
	  public static WebElement guest ;
	  
	  @FindBy(xpath="//div[@class='widgetSection appendBottom40']//ul[1]/li")
	  public static List<WebElement> adultlist ;
 	  
	  
	  public Hotel_Repository(WebDriver driver){
		  
		  this.driver = driver;
		  
		  //This initElements method will create all WebElements
		  PageFactory.initElements(driver, this);
	    }
}