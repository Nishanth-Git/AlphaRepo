package TestObjectRepository;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cab_LoginRepository {

	  WebDriver driver;
	  public static boolean value=false;

	  @FindBy(xpath="//ul[@class='makeFlex font12']//span[2]")
	  public static List<WebElement> menu;
     
      @FindBy(css="#fromCity")
	  public static WebElement click_from;    
	 
      @FindBy(xpath="//input[@placeholder='From']")
	  public static WebElement from_textbox;
	 
	  @FindBy(xpath="//*[@id=\"react-autowhatever-1\"]//li")
	  public static List<WebElement> Autosuggest_from;
	  
	  @FindBy(xpath="//input[@placeholder='To']")
	  public static WebElement to_textbox;
	  
	  @FindBy(xpath="//div[contains(@class,'csw_inputBox searchToCity inactiveWidget activeWidget')]//div//div[1]")
	  public static List<WebElement> Autosuggest_to;
	  
	  @FindBy(xpath="//li[@id='react-autowhatever-1-section-0-item-0']")
	  public static WebElement wait;
	  
	  @FindBy(xpath="//div[@class='DayPicker-Months']/div[1]/div[1]")
	  public static WebElement month;
	  
	  @FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	  public static WebElement next_month;
	  
	  @FindBy(className="DayPicker-Day")
	  public static List<WebElement> Date;
	  
	  @FindBy(xpath="//div[contains(@class,'csw_inner')]//li")
	  public static List<WebElement> time;
	  
	  @FindBy(xpath="//a[contains(@class,'primaryBtn font24 latoBold widgetSearchBtn')]")
	  public static WebElement search;
	  
	  public Cab_LoginRepository(WebDriver driver){
		  
		  this.driver = driver;
		  
		  //This initElements method will create all WebElements
		  PageFactory.initElements(driver, this);
		  
	    }

}
