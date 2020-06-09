package TestObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Giftcard_Repository {

	  WebDriver driver;
      
	  @FindBy(xpath="//ul[@class='makeFlex font12']/li/a/span[2]")
	  public static List<WebElement> menu;
	  
	  @FindBy(linkText="Group Gifting")
	  public static WebElement groupgifting;
	  
	  @FindBy(xpath="//button[@id='next1']")
	  public static WebElement carddetails;
	  
	  @FindBy(xpath="//li[@id='203']")
	  public static WebElement Ecard;
	  
	  @FindBy(id="amount")
	  public static WebElement amount;
	  
	  @FindBy(xpath="//input[@id='deadline']")
	  public static WebElement deadline;
	  
	  @FindBy(xpath="//div[@class='datepicker-days']//thead//tr[2]/th[2]")
	  public static WebElement month;
	  
	  @FindBy(xpath="//div[@class='datepicker-days']//thead//tr[2]/th[3]")
	  public static WebElement next_month;
	  
	  @FindBy(className="day")
	  public static List<WebElement> Date;
	  
	  @FindBy(xpath="//div[@id='form1']//div[@class='col-sm-12 col-md-12 col-lg-12']//input[1]")
	  public static WebElement terms;
	  
	  @FindBy(id="next1")
	  public static WebElement view;
	  
	  @FindBy(id="recipient")
	  public static WebElement name;
	  
	  @FindBy(id="recipientemail")
	  public static WebElement email;
	  
	  @FindBy(id="next2")
	  public static WebElement next;
	  
	  @FindBy(id="flash-message")
	  public static WebElement frame;
	  
	  @FindBy(xpath="//div[@id='flash-message']//br[1]")
	  public static WebElement msg;
	  
	  @FindBy(xpath="//div[@id='okay-container']")
	  public static WebElement okay;

	  public Giftcard_Repository(WebDriver driver){
		  
		  this.driver = driver;
		  
		  //This initElements method will create all WebElements
		  PageFactory.initElements(driver, this);
	    }
}
