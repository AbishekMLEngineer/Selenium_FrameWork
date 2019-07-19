package testClasses;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.HomePage;
import pageClasses.LoginPage;
import utilities.TestUtil;

import com.qa.base.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginPageObj;
	HomePage homePageObj;
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPageObj = new LoginPage();
		TestUtil util = new TestUtil();
		homePageObj = loginPageObj.login(null, null);
	}
	
	//this is added to execute the test case 3 times til it is not getting passed.
	//but this is at the tes level we can also add it at the run time
	@Test(retryAnalyzer= Listeners.RepeatFailedTestCase.class)
	public void validateTitle(){
		String actualTitle =loginPageObj.validateLoginPageTitle();
		//Assert.assertTrue(pro.getProperty("title"));
	}
	
	
	

}
