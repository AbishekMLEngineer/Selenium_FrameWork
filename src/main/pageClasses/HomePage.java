package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(name ="")
	WebElement taskLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void open(){
		
	}
	
	public void searchFor(){
		
	}
	
	public void isDisplayed(){
		
	}
	
	public MainPage clickOnMainTask(){
		taskLink.click();
		return new MainPage();
	}
	

}
