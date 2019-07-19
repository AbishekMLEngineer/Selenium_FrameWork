package com.qa.base;

import java.util.Iterator;
import java.util.Set;

public class HandlingPopUps extends TestBase{
	
	public  void handleAlert(){
		
	}
	
	public void handleBrowserWindow(){
		
	}
	
	public void handleBrowserWindow(String title){
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		while(it.hasNext()){
			String wndw = it.next();
			if(wndw == title){
				driver.switchTo().window(wndw);
			}
		}
	}

}
