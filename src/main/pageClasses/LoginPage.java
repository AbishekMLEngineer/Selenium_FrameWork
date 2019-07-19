package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(name ="")
	WebElement username;
	
	@FindBy(name ="")
	WebElement pwd1;
	
	@FindBy(name ="")
	WebElement submit;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		pwd1.sendKeys(pwd);
		submit.click();
		return new HomePage();
	}

}
