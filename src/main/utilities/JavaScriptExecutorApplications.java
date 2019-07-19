package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorApplications {
	
	public static void generateAlert(WebDriver driver , String msg){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+msg+"')");
	}
	
	public static void refreshBrowserUsingJS(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	public static void clickElementByJS(WebElement ele, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", ele);
	}
	
	public static String getTitleByJS(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title();").toString();
		return title;
	}
	
	public static void refreshBrowserByJS(WebDriver driver){
		
	}
	
	public String getInnerPageText(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String inerText=js.executeScript("return document.documentElement.innerText;").toString();
		return inerText;
	}
	
	public static void scrollPageDown(){
		
	}
	
	public static void scrollPageDownToElement(WebDriver driver ,WebElement ele){
		
	}
	
	public static void scrollPageUp(){
		
	}
	
	public static void scrollPageUpToElement(WebDriver driver ,WebElement ele){
		
	}
	
	public void scrollIntoView(){
		
	}

}
