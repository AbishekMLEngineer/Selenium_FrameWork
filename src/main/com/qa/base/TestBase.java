package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestBase {
	public  static WebDriver driver;
	Properties pro;
	/**
	 * SettingUp of browser ... Initializing properties file here
	 * maximize window... page load timeout ... implicit wait ... deleteAllCookies .. getUrl()
	 */
	
	public TestBase() {
		try{
			pro = new Properties();
			String str = "D:/SeleniumFramework/Config.properties";
			//String str = System.getProperty("user.dir")+"\\Selenium_FrameWork\\Config.properties";
			FileInputStream ip = new FileInputStream(str);
			pro.load(ip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	
	public void initialization(){
		String browserName = pro.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver","/home/user/Downloads/driver/chromedriver");
			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("I.E")){
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
	}
	
	//this testMethod will be used when we want to add desired capabilities to browser
	
	public static   WebDriver setBrowser(String url)// double checked login using synchronized keyword will increase the time by 100
	{
		if(driver==null){
			synchronized(TestBase.class){
				System.setProperty("webdriver.chrome.driver","/home/user/Downloads/driver/chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
		        chromeOptions.addArguments("--start-maximized");
		        driver = new ChromeDriver(chromeOptions);
		        driver.get(url);
		        System.out.println("its getting initialized");
			}
		}
		return driver;
	}
	
	public static  WebDriver setBrowserWithCapabilities()
	{
		System.out.println("Here With Capabilities");
		String chromeDriver = "/home/user/Downloads/driver/chromedriver";
		String chromeProfile= "/home/user/.config/chromium/Default";
		System.setProperty("webdriver.chrome.driver",chromeDriver);
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
	    options.addArguments("test-type");
	    options.addArguments("user-data-dir="+chromeProfile);
	    capabilities.setCapability("chrome.binary",chromeDriver);
	    capabilities.setCapability(ChromeOptions.CAPABILITY,options);
	    
	    driver = new ChromeDriver(options);
	    driver.get("http://www.lampsplus.com/");
	    return driver;
	}
	
	
	public void setUp(){
		/**
		 * Code for Setting Up for the environment
		 */
	}
	
	@AfterTest
	public void tearDown(){
		/**
		 * Code for tearing up of the test
		 */
	}

}
